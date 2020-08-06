package org.academiadecodigo.mega.services;

import org.academiadecodigo.mega.persistence.dao.LocationDao;
import org.academiadecodigo.mega.persistence.dao.ReviewDao;
import org.academiadecodigo.mega.persistence.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Transactional
    @Override
    public void delete(Integer id) {
        reviewDao.delete(id);
    }

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

    @Override
    public Review save(Review review) {
        reviewDao.saveOrUpdate(review);
        return null;
    }

    @Transactional
    @Override
    public Review get(Integer id) {

        return reviewDao.findById(id);
    }
}
