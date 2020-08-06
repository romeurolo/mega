package org.academiadecodigo.mega.converters;

import org.academiadecodigo.mega.command.ReviewDto;
import org.academiadecodigo.mega.persistence.model.Review;
import org.academiadecodigo.mega.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ReviewDtoToReview implements Converter<ReviewDto, Review> {

        private ReviewService reviewService;

        @Autowired
        public void setReviewService(ReviewService reviewService) {
            this.reviewService = reviewService;
        }

        @Override
        public Review convert(ReviewDto reviewDto) {
            Review review = (reviewDto.getId() != null ? reviewService.get(reviewDto.getId()) : new Review());

            review.setLocation(reviewDto.getLocation());
            review.setComent(reviewDto.getComent());
            review.setEvaluation(reviewDto.getEvaluation());
            review.setName(reviewDto.getName());
            review.setType(reviewDto.getType());
            review.setId(reviewDto.getId());

            return review;
    }

}
