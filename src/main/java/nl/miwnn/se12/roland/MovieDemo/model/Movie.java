package nl.miwnn.se12.roland.MovieDemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Roland in 't Hout <r.in.t.hout@st.hanze.nl>
 * Showing which movie shows where.
 */
@Entity
public class Movie {

    @Id @GeneratedValue
    private Long movieId;
    private String title;
    private String genre;
    private String year;
    private String director;

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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

} // end of class Movie
