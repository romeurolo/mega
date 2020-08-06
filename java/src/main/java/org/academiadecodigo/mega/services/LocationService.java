package org.academiadecodigo.mega.services;

import org.academiadecodigo.mega.persistence.model.Location;
import org.academiadecodigo.mega.persistence.model.Review;

import java.util.List;

public interface LocationService {


    Location get(Integer id);

    double getEvaluation(Integer id);

    Location save(Location location);

    void delete(Integer id);

    List<Location> list();
        
    Review addReview(Integer id, Review review);

}