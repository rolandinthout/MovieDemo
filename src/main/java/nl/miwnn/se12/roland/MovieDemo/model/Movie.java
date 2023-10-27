package nl.miwnn.se12.roland.MovieDemo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Roland in 't Hout <r.in.t.hout@st.hanze.nl>
 * Showing which movie shows in which cinema.
 */
@Entity
@Getter @Setter
public class Movie {
    public Movie(String title) {
        this.title = title;
    }

    public Movie() {
    }

    @Id
    @GeneratedValue
    private Long movieId;

    @Column(unique = true)

    private String title;

    private String genre;

    private int year;

    @ManyToMany()
    private Set<Director> directors = new HashSet<>();

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private Set<Cinema> cinemas;

    public void addDirector(Director director) {
        directors.add(director);
    }

    public int amountInCinemas() {
        int count = 0;

        for (Cinema cinema : cinemas) {
            if (cinema.getInCinema()) {
                count++;
            }
        }

        return count;
    }

    public String getAllDirectorsDisplayString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Director director : directors) {
            stringBuilder.append(director.getDisplayName()).append(", ");
        }
        return stringBuilder.toString();
    }


} // end of class Movie
