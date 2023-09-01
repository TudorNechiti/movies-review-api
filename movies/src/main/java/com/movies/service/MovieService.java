package com.movies.service;

import com.movies.model.Movie;
import com.movies.repository.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> findAllMovies(){
        return movieRepository.findAll();
    }

    public Optional<Movie> findMovie(String imdbId){
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
