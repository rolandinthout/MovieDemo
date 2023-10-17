package nl.miwnn.se12.roland.MovieDemo.repository;

import nl.miwnn.se12.roland.MovieDemo.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

} // end of class MovieRepository
