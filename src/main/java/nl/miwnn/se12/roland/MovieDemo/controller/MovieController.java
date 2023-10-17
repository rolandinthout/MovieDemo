package nl.miwnn.se12.roland.MovieDemo.controller;

import nl.miwnn.se12.roland.MovieDemo.repository.MovieRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Roland in 't Hout <r.in.t.hout@st.hanze.nl>
 * Purpose of the program
 */
@Controller
public class MovieController {
    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/")
    private String showMovieOverview(Model model) {
        model.addAttribute("allMovies", movieRepository.findAll());

        return "movieOverview";
    }



} // end of class MovieController
