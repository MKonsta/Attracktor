package com.example.hw50.service;

import com.example.hw50.model.*;
import com.example.hw50.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl {

    private final UserRepository userRepository;
    private final PublicationRepository publicationRepository;
    private final LikeRepository likeRepository;
    private final CommentRepository commentRepository;
    private final EventRepository eventRepository;



    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           PublicationRepository publicationRepository,
                           LikeRepository likeRepository,
                           CommentRepository commentRepository,
                           EventRepository eventRepository) {
        this.userRepository = userRepository;
        this.publicationRepository = publicationRepository;
        this.likeRepository = likeRepository;
        this.commentRepository = commentRepository;
        this.eventRepository = eventRepository;
    }

    public User delete(String email) {
        if (existsUser(email)) {
            User user = getUserByEmail(email);
            userRepository.deleteByEmail(email);
            return user;
        }
        return null;
    }

    public User getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public boolean existsUser(String email) {
        return userRepository.existsByEmail(email);
    }

    public List<Publication> getUsersPublications(String email) {
        return publicationRepository.findAllByUserId(getUserByEmail(email).getId());
    }

    //Выборка публикаций для своей ленты на основе подписок на других пользователей
    public List<Publication> getLentaOfPubForUser(String email) {
        List<Publication> result = new ArrayList<>();

        List<String> folowers  = userRepository.findUserByEmail(email).getSubsciptions();

        for (String followerEmail : folowers) {
            result.addAll(getUsersPublications(followerEmail));
        }

        return result;
    }

    //Проверка на установку "лайка" на публикацию.
    public boolean checkLikeForPublication(String userEmail, String publicationId) {

        String userId = getUserByEmail(userEmail).getId();

        if (likeRepository.existsByUserID(userId)) {

            for (Like like : likeRepository.findAllByUserID(userId)) {
                if (like.getPublicationId().equals(publicationId)) {
                    return true;
                }
            }
        }

        return false;
    }


    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public List<User> getAll() {
        return (List<User>) userRepository.findAll();
    }

    //регистрация нового юзера
    public User addNewUser(User user) {

        if (!existsUser(user.getEmail())) {
            user.setSubsciptions(new ArrayList<>());
            user.setSubscibers(new ArrayList<>());
            userRepository.save(user);
            return user;
        }
        return null;
    }

    public Publication addPublication(Publication publication) {
        publicationRepository.save(publication);
        return publication;
    }

//    public Like addLike(String publicationId, String userId) {
//        Like like = new Like(userId, publicationId, LocalDateTime.now());
//        likeRepository.save(like);
//        return like;
//    }



    //подписка одного пользователя на другого
    public void subscribe(String userEmail, String subscriberEmail) {

        User user = getUserByEmail(userEmail);
        User subscriber = getUserByEmail(subscriberEmail);

        user.getSubscibers().add(subscriber.getEmail());
        subscriber.getSubsciptions().add(user.getEmail());

        userRepository.save(user);
        userRepository.save(subscriber);

        Event event = new Event(user.getId(), subscriber.getId(), LocalDateTime.now());
        eventRepository.save(event);
    }


}
