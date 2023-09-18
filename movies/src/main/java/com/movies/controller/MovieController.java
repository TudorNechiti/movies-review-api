package com.movies.controller;

import com.movies.model.Movie;
import com.movies.service.MovieService;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getMovies(){
        return new ResponseEntity<>(movieService.findAllMovies(), HttpStatus.OK);
    }

    @GetMapping(path = "/{imdbId}")
    public ResponseEntity<Optional<Movie>> getMovie(@PathVariable String imdbId){
        return new ResponseEntity<>(movieService.findMovie(imdbId), HttpStatus.OK);
    }
}
