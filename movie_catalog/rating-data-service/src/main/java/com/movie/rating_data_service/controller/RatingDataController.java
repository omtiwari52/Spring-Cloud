package com.movie.rating_data_service.controller;

import com.movie.rating_data_service.models.Rating;
import com.movie.rating_data_service.models.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingData")
public class RatingDataController {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") Long movieId){
        return new Rating(movieId, 8.9);
    }

    @RequestMapping("/users/{userId}")
    public UserRating getUSerRating(@PathVariable("userId") Long userId){
        List<Rating> ratings = Arrays.asList(
                new Rating(1L, 8),
                new Rating(2L, 9.1)
        );
        UserRating userRating = new UserRating();
        userRating.setUserRating(ratings);
        return userRating;
    }
}
