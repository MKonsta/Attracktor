package com.example.hw50.service;

import com.example.hw50.model.Publication;
import com.example.hw50.model.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PublicationServiceImpl implements PublicationService {

    @Autowired
    PublicationRepository publicationRepository;

    public PublicationServiceImpl(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }

    @Override
    public Publication getPublicationById(String id) {
        return publicationRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Publication publication) {
        publicationRepository.save(publication);
    }

    @Override
    public void delete(String id) {
        publicationRepository.deleteById(id);
    }

    @Override
    public List<Publication> getAll() {
        return (List<Publication>) publicationRepository.findAll();
    }
}
