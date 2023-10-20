package nl.miwnn.se12.roland.MovieDemo.repository;

import nl.miwnn.se12.roland.MovieDemo.model.MovieDbUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieDbUserRepository extends JpaRepository<MovieDbUser, Long> {
    Optional<MovieDbUser> findMovieDbUserByUsername(String username);
}
