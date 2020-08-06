package org.academiadecodigo.mega.converters;

import org.academiadecodigo.mega.command.ReviewDto;
import org.academiadecodigo.mega.persistence.model.Review;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ReviewToReviewDto implements Converter<Review, ReviewDto> {

    @Override
    public ReviewDto convert(Review review) {
        ReviewDto reviewDto = new ReviewDto();

        reviewDto.setId(review.getId());
        reviewDto.setName(review.getName());
        reviewDto.setComent(review.getComent());
        reviewDto.setEvaluation(review.getEvaluation());
        reviewDto.setType(review.getType());
        reviewDto.setLocation(review.getLocation());

        return reviewDto;
    }
}

