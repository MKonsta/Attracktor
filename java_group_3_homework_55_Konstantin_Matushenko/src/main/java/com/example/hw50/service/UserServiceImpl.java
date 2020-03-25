package com.example.hw50.service;

import com.example.hw50.model.*;
import com.example.hw50.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void deleteAll() {
        userRepository.deleteAll();
    }

    public User getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public boolean existsUser(String email) {
        return userRepository.existsByEmail(email);
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

    public List<User> getAll() {
        return userRepository.findAll();
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

    public User updateUser(User user) {
        if (existsUser(user.getEmail())) {
            return userRepository.save(user);
        }
        return null;
    }

    public User getByName(String name) {
        return userRepository.findUserByName(name);
    }

    public void addAllUsers(List<User> users) {
        userRepository.saveAll(users);
    }


}
