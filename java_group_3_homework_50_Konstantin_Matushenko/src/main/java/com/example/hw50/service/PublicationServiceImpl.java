package com.example.hw50.service;

import com.example.hw50.model.Publication;
import com.example.hw50.repository.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicationServiceImpl {

    private final PublicationRepository pubRepo;

    @Autowired
    public PublicationServiceImpl(PublicationRepository publicationRepository) {
        this.pubRepo = publicationRepository;
    }

    public List<Publication> getAll() {
        return pubRepo.findAll();
    }


}
