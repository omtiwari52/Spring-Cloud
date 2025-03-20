package com.movie.movie_catalog_service.controller;

import com.movie.movie_catalog_service.models.CatalogItem;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
        return List.of(
                new CatalogItem("Fast&Furious", "Movie with car races", 8.9),
                new CatalogItem("Jack Reacher", "Story about retired Major", 9.1),
                new CatalogItem("Harry Potter", "Story about Magical world", 7.8)
        );
    }
}
