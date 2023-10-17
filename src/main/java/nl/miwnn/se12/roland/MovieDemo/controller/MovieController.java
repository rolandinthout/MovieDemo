package nl.miwnn.se12.roland.MovieDemo.controller;

import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import nl.miwnn.se12.roland.MovieDemo.model.Movie;
import nl.miwnn.se12.roland.MovieDemo.repository.MovieRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.awt.print.Book;

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

    @GetMapping("/movie/new")
    private String showMovieForm(Model model) {
        model.addAttribute("movie", new Movie());

        return "movieForm";
    }

    @PostMapping("movie/new")
    private String saveOrUpdateMovie(
            @ModelAttribute("movie") Movie movieToBeSaved, BindingResult result) {
        if (!result.hasErrors()) {
            movieRepository.save(movieToBeSaved);
        }

        return "redirect:/";
    }



} // end of class MovieController
