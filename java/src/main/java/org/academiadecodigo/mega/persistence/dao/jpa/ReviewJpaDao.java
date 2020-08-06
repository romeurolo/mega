package org.academiadecodigo.mega.persistence.dao.jpa;

import org.academiadecodigo.mega.persistence.dao.ReviewDao;
import org.academiadecodigo.mega.persistence.model.Review;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewJpaDao extends GenericJpaDao<Review> implements ReviewDao {
    public ReviewJpaDao() {
        super(Review.class);
    }
}
