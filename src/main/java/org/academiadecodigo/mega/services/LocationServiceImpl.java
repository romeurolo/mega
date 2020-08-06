package org.academiadecodigo.mega.services;

import org.academiadecodigo.mega.persistence.dao.LocationDao;
import org.academiadecodigo.mega.persistence.dao.ReviewDao;
import org.academiadecodigo.mega.persistence.model.Location;
import org.academiadecodigo.mega.persistence.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
public class LocationServiceImpl implements LocationService {

    private LocationDao locationDao;
    private ReviewDao reviewDao;

    @Autowired
    public void setLocationDao(LocationDao locationDao) {
        this.locationDao = locationDao;
    }

    @Autowired
    public void setReviewDao(ReviewDao reviewDao) {
        this.reviewDao = reviewDao;
    }

    @Transactional
    @Override
    public Location get(Integer id) {
        return locationDao.findById(id);
    }

    @Transactional
    @Override
    public double getEvaluation(Integer id) {
        List<Review> reviews = locationDao.findById(id).getReviews();
        int acc = 0;
        for (Review review : reviews) {
            if (review.getType()) {
                acc += review.getEvaluation();
                continue;
            }
            acc -= review.getEvaluation();
        }
        return (acc/reviews.size());
    }

    @Transactional
    @Override
    public Location save(Location location) {

        return locationDao.saveOrUpdate(location);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        locationDao.delete(id);
    }

    @Transactional
    @Override
    public List<Location> list() {
        return locationDao.findAll();
    }

    @Transactional
    @Override
    public Review addReview(Integer id, Review review) {

        Location location = locationDao.findById(id);
        location.addReview(review);
        locationDao.saveOrUpdate(location);

        return location.getReviews().get(location.getReviews().size() - 1);

    }
}