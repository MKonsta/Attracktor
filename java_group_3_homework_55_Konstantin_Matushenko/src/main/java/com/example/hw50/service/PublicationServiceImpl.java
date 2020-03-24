package com.example.hw50.service;

import com.example.hw50.model.Publication;
import com.example.hw50.repository.PublicationRepository;
import com.example.hw50.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PublicationServiceImpl {

    private final PublicationRepository pubRepo;
    private final UserRepository userRepository;

    @Autowired
    public PublicationServiceImpl(PublicationRepository publicationRepository,
                                  UserRepository userRepository) {
        this.pubRepo = publicationRepository;
        this.userRepository = userRepository;
    }

    public List<Publication> getAll() {
        return pubRepo.findAll();
    }

    public boolean existsById(String id) {
        return pubRepo.existsById(id);
    }

    public Publication addPublication(Publication publication) {
        publication.setDate(LocalDateTime.now());
        pubRepo.save(publication);
        return publication;
    }

    public void deleteAll() {
        pubRepo.deleteAll();
    }

    public Publication getById(String id) {
       return pubRepo.findById(id).orElse(null);
    }

    public Publication delete(String id) {
        if (existsById(id)) {
            Publication publication = getById(id);
            pubRepo.delete(publication);
            return publication;
        }
        return null;
    }

    //Ищет все публикации пользователя по мылу
    public List<Publication> getAllByUserEmail(String email) {
        return pubRepo.findAllByUserId(userRepository.findUserByEmail(email).getId());
    }

    //Ищет все публикации пользователя по id
    public List<Publication> getAllByUserId(String userId) {
        return pubRepo.findAllByUserId(userId);
    }

    //Выборка публикаций для своей ленты на основе подписок на других пользователей
    public List<Publication> getLentaOfPubForUser(String userId) {
        List<Publication> result = new ArrayList<>();

        List<String> subsciptions  = userRepository.findUserById(userId).getSubsciptions();

        for (String subscriptionEmail : subsciptions) {
            result.addAll(getAllByUserEmail(subscriptionEmail));
        }

        return result;
    }


}
