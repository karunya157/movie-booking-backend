package com.moviebooking.service;

import com.moviebooking.model.Booking;
import com.moviebooking.model.Movie;
import com.moviebooking.repository.BookingRepository;
import com.moviebooking.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private BookingRepository bookingRepository;

    // 1. Add new Movie
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    // 2. Get All Movies
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // 3. Book a Ticket
    public Booking bookTicket(Long movieId, Booking booking) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie Not Found"));

        booking.setMovie(movie);
        booking.setTotalAmount(movie.getPrice() * booking.getNumberOfTickets());

        return bookingRepository.save(booking);
    }
}
