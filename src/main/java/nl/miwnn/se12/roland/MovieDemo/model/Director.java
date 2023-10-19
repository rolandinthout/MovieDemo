package nl.miwnn.se12.roland.MovieDemo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Roland in 't Hout <r.in.t.hout@st.hanze.nl>
 * Purpose of the program
 */
@Entity
@Getter
@Setter
public class Director {

    @Id
    @GeneratedValue
    private Long directorId;

    @Column(nullable = false)
    private String firstName;
    private String infixName;
    @Column(nullable = false)
    private String lastName;

    public String getDisplayName() {
        String displayName = firstName;

        if (infixName != null && !infixName.equals("")) {
            displayName += " " + infixName;
        }

        displayName += " " + lastName;

        return displayName;
    }
} // end of class Director
