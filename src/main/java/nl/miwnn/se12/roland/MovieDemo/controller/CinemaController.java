package nl.miwnn.se12.roland.MovieDemo.controller;

import lombok.RequiredArgsConstructor;
import nl.miwnn.se12.roland.MovieDemo.model.Cinema;
import nl.miwnn.se12.roland.MovieDemo.model.Movie;
import nl.miwnn.se12.roland.MovieDemo.repository.CinemaRepository;
import nl.miwnn.se12.roland.MovieDemo.repository.MovieRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * @author Roland in 't Hout <r.in.t.hout@st.hanze.nl>
 * Gives a overview where wich movie is showing
 */
@Controller
@RequestMapping("/cinema")
@RequiredArgsConstructor
public class CinemaController {
    private final MovieRepository movieRepository;
    private final CinemaRepository cinemaRepository;

    @GetMapping("/new/{movieId}")
    private String createNewCinema(@PathVariable("movieId") Long movieId) {
        Optional<Movie> movieOptional = movieRepository.findById(movieId);

        if (movieOptional.isPresent()) {
            Cinema cinema = new Cinema();
            cinema.setMovie(movieOptional.get());
            cinemaRepository.save(cinema);
        }

        return "redirect:/movie/overview";
    }

    @GetMapping("/addMovie/{cinemaId}")
    private String makeNotInCinema(@PathVariable("cinemaId") Long cinemaId) {
        return setShowOrHideMovie(cinemaId, false);
    }

    @GetMapping("/removeMovie/{cinemaId}")
    private String makeInCinema(@PathVariable("cinemaId") Long cinemaId) {
        return setShowOrHideMovie(cinemaId, true);
    }

    private String setShowOrHideMovie(Long cinemaId, boolean inCinema) {
        Optional<Cinema> optionalCinema = cinemaRepository.findById(cinemaId);

        if (optionalCinema.isEmpty()) {
            return "redirect:/movie/overview";
        }

        Cinema cinema = optionalCinema.get();
        cinema.setInCinema(inCinema);
        cinemaRepository.save(cinema);

        return String.format("redirect:/movie/detail/%s", cinema.getMovie().getTitle());
    }

}
