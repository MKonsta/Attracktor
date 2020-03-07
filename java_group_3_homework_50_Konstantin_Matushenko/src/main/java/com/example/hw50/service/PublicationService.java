package com.example.hw50.service;

import com.example.hw50.model.Publication;

public interface PublicationService {

    public Publication getPublicationById(String id);

    public void save(Publication publication);

    public void delete(String id);

    public Iterable<Publication> getAll();
}
