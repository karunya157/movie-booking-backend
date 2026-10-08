package com.moviebooking;

import com.moviebooking.model.Movie;
import com.moviebooking.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MovieBookingApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieBookingApplication.class, args);
    }

    // This Bean will run automatically when the application starts
    // and insert dummy movies into the database
    @Bean
    public CommandLineRunner loadData(MovieRepository movieRepository) {
        return args -> {
            if (movieRepository.count() == 0) { // Add only if database is empty
                Movie movie1 = new Movie();
                movie1.setTitle("Leo");
                movie1.setLanguage("Tamil");
                movie1.setGenre("Action");
                movie1.setPrice(150.0);
                
                Movie movie2 = new Movie();
                movie2.setTitle("Jawan");
                movie2.setLanguage("Hindi");
                movie2.setGenre("Action");
                movie2.setPrice(200.0);
                
                Movie movie3 = new Movie();
                movie3.setTitle("Avatar 2");
                movie3.setLanguage("English");
                movie3.setGenre("Sci-Fi");
                movie3.setPrice(250.0);

                movieRepository.save(movie1);
                movieRepository.save(movie2);
                movieRepository.save(movie3);

                System.out.println("Dummy Movies added to the database successfully!");
            }
        };
    }
}
