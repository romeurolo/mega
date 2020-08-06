package org.academiadecodigo.mega.controller;

import org.academiadecodigo.mega.command.LocationDto;
import org.academiadecodigo.mega.command.ReviewDto;
import org.academiadecodigo.mega.converters.LocationDtoToLocation;
import org.academiadecodigo.mega.converters.LocationToLocationDto;
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
@RequestMapping("/api/location")
public class RestLocationController {
    private LocationService locationService;
    private ReviewService reviewService;
    private LocationToLocationDto locationToLocationDto;
    private LocationDtoToLocation locationDtoToLocation;
    private ReviewToReviewDto reviewToReviewDto;
    private ReviewDtoToReview reviewDtoToReview;

    @Autowired
    public void setReviewToReviewDto(ReviewToReviewDto reviewToReviewDto) {
        this.reviewToReviewDto = reviewToReviewDto;
    }

    @Autowired
    public void setReviewDtoToReview(ReviewDtoToReview reviewDtoToReview) {
        this.reviewDtoToReview = reviewDtoToReview;
    }

    @Autowired
    public void setLocationToLocationDto(LocationToLocationDto locationToLocationDto) {
        this.locationToLocationDto = locationToLocationDto;
    }

    @Autowired
    public void setLocationDtoToLocation(LocationDtoToLocation locationDtoToLocation) {
        this.locationDtoToLocation = locationDtoToLocation;
    }

    @Autowired
    public void setLocationService(LocationService locationService) {
        this.locationService = locationService;
    }

    @Autowired
    public void setReviewService(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public ResponseEntity<List<LocationDto>> listLocation() {

        List<LocationDto> locationDtos = new ArrayList<>();
        for (Location location : locationService.list()) {
            locationDtos.add(locationToLocationDto.convert(location));
        }
        return new ResponseEntity<>(locationDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<LocationDto> showLocation(@PathVariable Integer id) {
        Location location = locationService.get(id);
        if (location == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(locationToLocationDto.convert(location), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{lid}/review")
    public ResponseEntity<List<ReviewDto>> showLocationReviews(@PathVariable Integer lid) {
        Location location = locationService.get(lid);
        if (location == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<ReviewDto> reviewDtos = new ArrayList<>();

        for (Review review :locationService.get(lid).getReviews()){
            reviewDtos.add(reviewToReviewDto.convert(review));
        }
        return new ResponseEntity<>(reviewDtos,HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET, path = "/city/{str}")
    public ResponseEntity<List<LocationDto>> ListLocationsByCity(@PathVariable String str) {
        List<LocationDto> locationDtos = new ArrayList<>();
        for (Location location : locationService.list()) {
            if (location.getCity().toLowerCase().contains(str.toLowerCase())) {
                locationDtos.add(locationToLocationDto.convert(location));
            }
        }
        return new ResponseEntity<>(locationDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/name/{str}")
    public ResponseEntity<List<LocationDto>> ListLocationsByName(@PathVariable String str) {
        List<LocationDto> locationDtos = new ArrayList<>();
        for (Location location : locationService.list()) {
            if (location.getName().toLowerCase().contains(str.toLowerCase())) {
                locationDtos.add(locationToLocationDto.convert(location));
            }
        }
        return new ResponseEntity<>(locationDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/", ""})
    public ResponseEntity<?> addLocation(@Valid @RequestBody LocationDto locationDto, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder) {
        if (bindingResult.hasErrors() || locationDto.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Location savedLocation = locationService.save(locationDtoToLocation.convert(locationDto));

        // get help from the framework building the path for the newly created resource
        UriComponents uriComponents = uriComponentsBuilder.path("/api/location/" + savedLocation.getId()).build();

        // set headers with the created path
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponents.toUri());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<LocationDto> editLocation(@Valid @RequestBody LocationDto locationDto, BindingResult bindingResult, @PathVariable Integer id) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (locationDto.getId() != null && !locationDto.getId().equals(id)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        locationDto.setId(id);
        locationService.save(locationDtoToLocation.convert(locationDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<LocationDto> deleteLocation(@PathVariable Integer id) {
        locationService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
