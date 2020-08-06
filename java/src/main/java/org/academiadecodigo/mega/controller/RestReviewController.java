package org.academiadecodigo.mega.controller;

import org.academiadecodigo.mega.command.LocationDto;
import org.academiadecodigo.mega.command.ReviewDto;
import org.academiadecodigo.mega.converters.ReviewDtoToReview;
import org.academiadecodigo.mega.converters.ReviewToReviewDto;
import org.academiadecodigo.mega.persistence.model.Location;
import org.academiadecodigo.mega.persistence.model.Review;
import org.academiadecodigo.mega.services.LocationService;
import org.academiadecodigo.mega.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/review")
public class RestReviewController {
    private LocationService locationService;
    private ReviewService reviewService;
    private ReviewDtoToReview reviewDtoToReview;
    private ReviewToReviewDto reviewToReviewDto;

    @Autowired
    public void setLocationService(LocationService locationService) {
        this.locationService = locationService;
    }

    @Autowired
    public void setReviewService(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @Autowired
    public void setReviewDtoToReview(ReviewDtoToReview reviewDtoToReview) {
        this.reviewDtoToReview = reviewDtoToReview;
    }

    @Autowired
    public void setReviewToReviewDto(ReviewToReviewDto reviewToReviewDto) {
        this.reviewToReviewDto = reviewToReviewDto;
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/", ""})
    public ResponseEntity<?> addReview(@Valid @RequestBody ReviewDto reviewDto, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder) {
        if (bindingResult.hasErrors() || reviewDto.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Review savedreview = reviewService.save(reviewDtoToReview.convert(reviewDto));

        // get help from the framework building the path for the newly created resource
        UriComponents uriComponents = uriComponentsBuilder.path("/api/review/" + savedreview.getId()).build();

        // set headers with the created path
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponents.toUri());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<LocationDto> editReview(@Valid @RequestBody ReviewDto reviewDto, BindingResult bindingResult, @PathVariable Integer id) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (reviewDto.getId() != null && !reviewDto.getId().equals(id)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        reviewDto.setId(id);
        reviewService.save(reviewDtoToReview.convert(reviewDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<LocationDto> deleteReview(@PathVariable Integer id) {
        reviewService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
