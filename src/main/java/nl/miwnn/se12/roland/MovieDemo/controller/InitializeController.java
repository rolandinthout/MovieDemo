package nl.miwnn.se12.roland.MovieDemo.controller;

import lombok.RequiredArgsConstructor;
import net.datafaker.Faker;
import net.datafaker.providers.base.Name;
import nl.miwnn.se12.roland.MovieDemo.model.Director;
import nl.miwnn.se12.roland.MovieDemo.model.Movie;
import nl.miwnn.se12.roland.MovieDemo.model.Cinema;
import nl.miwnn.se12.roland.MovieDemo.model.MovieDbUser;
import nl.miwnn.se12.roland.MovieDemo.repository.CinemaRepository;
import nl.miwnn.se12.roland.MovieDemo.repository.DirectorRepository;
import nl.miwnn.se12.roland.MovieDemo.repository.MovieDbUserRepository;
import nl.miwnn.se12.roland.MovieDemo.repository.MovieRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Locale;
/**
 * @director Roland in 't Hout <r.in.t.hout@st.hanze.nl>
 * Purpose of the program
 */
@Controller
@RequiredArgsConstructor
public class InitializeController {
    private final DirectorRepository directorRepository;
    private final MovieRepository movieRepository;
    private final CinemaRepository cinemaRepository;
    private final MovieDbUserRepository movieDbUserRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/initialize")
    private String initializeDB() {
        if (!movieDbUserRepository.findAll().isEmpty()) {
            return "redirect:/";
        }

    MovieDbUser adminUser = new MovieDbUser();
    adminUser.setUsername("admin");
    adminUser.setPassword(passwordEncoder.encode("admin"));
    // TODO Enforce the user to select a better password
    System.err.println("Admin user created, please make sure to change the password");
    movieDbUserRepository.save(adminUser);


    Faker faker = new Faker(new Locale("nl"));

    ArrayList<Director> directors = new ArrayList<>();
    for (int director = 0; director < 10; director++) {
        Name name = faker.name();
        directors.add(new Director(name.firstName(), name.lastName()));
    }

    directorRepository.saveAll(directors);

//        Director patrick = new Director("Patrick", "Rothfuss");
//        Director paul = new Director("Paul", "van", "Loon");
//
//        directorRepository.save(patrick);
//        directorRepository.save(paul);
//
//        Movie wind = new Movie("The Name of the Wind");
//        wind.addDirector(patrick);
//
//        movieRepository.save(wind);
//
//        ArrayList<Cinema> cinemas = new ArrayList<>();
//
//        cinemas.add(new Cinema(wind));
//        cinemas.add(new Cinema(wind));
//        cinemas.add(new Cinema(wind));
//
//        Movie bus = new Movie("De Griezelbus");
//        bus.addDirector(paul);
//        movieRepository.save(bus);
//
//        cinemas.add(new Cinema(bus));
//        cinemas.add(new Cinema(bus));
//
//        cinemaRepository.saveAll(cinemas);

        return "redirect:/";
    }

} // end of class InitializeController
