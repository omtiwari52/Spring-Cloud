package com.movie.movie_catalog_service.models;

public class Rating {

    private Long movieId;
    private double rating;

    public Long getmovieId() {
        return movieId;
    }

    public void setmovieId(Long movieId) {
        this.movieId = movieId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Rating() {
    }

    public Rating(Long movieId, double rating) {
        this.movieId = movieId;
        this.rating = rating;
    }
}
