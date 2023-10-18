package nl.miwnn.se12.roland.MovieDemo.repository;


import nl.miwnn.se12.roland.MovieDemo.model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {

}
