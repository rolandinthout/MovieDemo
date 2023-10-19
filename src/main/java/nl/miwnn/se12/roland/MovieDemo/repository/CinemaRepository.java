package nl.miwnn.se12.roland.MovieDemo.repository;


import nl.miwnn.se12.roland.MovieDemo.model.Cinema;
import nl.miwnn.se12.roland.MovieDemo.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {


}
