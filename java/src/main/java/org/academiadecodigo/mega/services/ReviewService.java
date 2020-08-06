package org.academiadecodigo.mega.services;


import org.academiadecodigo.mega.persistence.model.Review;

public interface ReviewService {

    Review get(Integer id);

    Review save(Review review);

    void delete(Integer id);
}

