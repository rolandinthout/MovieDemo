package nl.miwnn.se12.roland.MovieDemo.repository;

import nl.miwnn.se12.roland.MovieDemo.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Roland in 't Hout <r.in.t.hout@st.hanze.nl>
 * Purpose of the program
 */
public interface MovieRepository extends JpaRepository<Movie, Long> {

} // end of class MovieRepository
