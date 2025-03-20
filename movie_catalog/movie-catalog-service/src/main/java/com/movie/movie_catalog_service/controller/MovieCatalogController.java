package com.movie.movie_catalog_service.controller;

import com.movie.movie_catalog_service.models.CatalogItem;
import com.movie.movie_catalog_service.models.Movie;
import com.movie.movie_catalog_service.models.Rating;
import com.movie.movie_catalog_service.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){

        UserRating ratings = restTemplate.getForObject("http://rating-data-service/ratingData/users/" + userId, UserRating.class );

        return ratings.getUserRating().stream().map(rating -> {
            Movie movie = restTemplate.getForObject("http://movie-info-service/info/"+ rating.getmovieId(), Movie.class);
//            Movie movie = webClientBuilder.build()
//                    .get()
//                    .uri("http://localhost:9002/info/"+ rating.getmovieId())
//                    .retrieve()
//                    .bodyToMono(Movie.class)//a promise that one will get an object back but do not know when
//                    .block();
            assert movie != null;
            return new CatalogItem(movie.getMovieName(), "Movie with car races", rating.getRating());
        }).collect(Collectors.toList());
    }
}
