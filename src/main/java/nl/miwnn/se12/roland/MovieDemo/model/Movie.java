package nl.miwnn.se12.roland.MovieDemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Roland in 't Hout <r.in.t.hout@st.hanze.nl>
 * Showing a favorite movie database
 */
@Entity
public class Movie {

    @Id @GeneratedValue
    private Long movieId;

    private String title;


    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
} // end of class Movie
