package com.movie.movie_info_service.controller;

import com.movie.movie_info_service.models.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class MovieInfoController {

    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") Long movieId){
        return new Movie(movieId, "Red Notice");
    }

}
