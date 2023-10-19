package nl.miwnn.se12.roland.MovieDemo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

/**
 * @author Roland in 't Hout <r.in.t.hout@st.hanze.nl>
 * List of cinema's where the movie is showing
 */

@Entity
@Getter @Setter
public class Cinema {
    public Cinema(Movie movie) {
        this.movie = movie;
    }

    public Cinema() {
    }

    @Id @GeneratedValue
    private Long cinemaId;
    private String city;
    private String cinemaName;
    private LocalDate premiere;


    private Boolean inCinema = true;

    @ManyToOne
    private Movie movie;

} // end of class Cinema
