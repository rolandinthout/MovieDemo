package nl.miwnn.se12.roland.MovieDemo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * @author Roland in 't Hout <r.in.t.hout@st.hanze.nl>
 * Showing which movie shows where.
 */
@Entity
@Getter @Setter
public class Movie {

    @Id
    @GeneratedValue
    private Long movieId;
    private String title;
    private String genre;
    private int year;
    private String director;

    @OneToMany(mappedBy = "movie")
    private List<Cinema> cinemas;

    public int getAmountInCinemas() {
        int count = 0;

        for (Cinema cinema : cinemas) {
            if (cinema.getInCinema()) {
                count++;
            }
        }

        return count;
    }


} // end of class Movie
