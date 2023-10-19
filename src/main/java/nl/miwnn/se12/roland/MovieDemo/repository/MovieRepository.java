package nl.miwnn.se12.roland.MovieDemo.repository;

import nl.miwnn.se12.roland.MovieDemo.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Optional<Movie> findMovieByTitle(String title);
} // end of class MovieRepository
