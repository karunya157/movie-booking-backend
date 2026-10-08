package com.moviebooking.controller;

import com.moviebooking.model.Booking;
import com.moviebooking.model.Movie;
import com.moviebooking.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000") // Connect with Next.js
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/movies")
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @PostMapping("/book/{movieId}")
    public Booking bookTicket(@PathVariable Long movieId, @RequestBody Booking booking) {
        return movieService.bookTicket(movieId, booking);
    }
}
