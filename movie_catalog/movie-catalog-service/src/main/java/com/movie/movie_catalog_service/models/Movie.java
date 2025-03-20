package com.movie.movie_catalog_service.models;

public class Movie {

    private Long movieId;
    private String movieName;

    public Movie(Long movieId, String movieName) {
        this.movieId = movieId;
        this.movieName = movieName;
    }

    public Movie() {
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
}
