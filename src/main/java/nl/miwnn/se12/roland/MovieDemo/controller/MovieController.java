package nl.miwnn.se12.roland.MovieDemo.controller;

import lombok.RequiredArgsConstructor;
import nl.miwnn.se12.roland.MovieDemo.model.Movie;
import nl.miwnn.se12.roland.MovieDemo.repository.DirectorRepository;
import nl.miwnn.se12.roland.MovieDemo.repository.MovieRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.awt.print.Book;
import java.util.Optional;

/**
 * @author Roland in 't Hout <r.in.t.hout@st.hanze.nl>
 * Purpose of the program
 */
@Controller
@RequiredArgsConstructor
public class MovieController {
    private final DirectorRepository directorRepository;
    private final MovieRepository movieRepository;


    @GetMapping({"/", "/movie/overview"})
    private String showMovieOverview(Model model) {
        model.addAttribute("allMovies", movieRepository.findAll());

        return "movieOverview";
    }

    @GetMapping("/movie/new")
    private String showMovieForm(Model model) {
        model.addAttribute("movie", new Movie());
        model.addAttribute("allDirectors", directorRepository.findAll());

        return "movieForm";
    }

    @GetMapping("/movie/detail/{title}")
    private String showMovieDetails(@PathVariable("title") String title, Model model) {
        Optional<Movie> optionalMovie = movieRepository.findMovieByTitle(title);

        if (optionalMovie.isEmpty()) {
            return "redirect:/";
        }

        model.addAttribute("movieToBeShown", optionalMovie.get());

        return "movieDetail";
    }

    @GetMapping("/movie/edit/{title}")
    private String showEditMovieForm(@PathVariable("title") String title, Model model) {
        Optional<Movie> optionalMovie = movieRepository.findMovieByTitle(title);

        if (optionalMovie.isEmpty()) {
            return "redirect:/movie/overview";
        }

        model.addAttribute("movie", optionalMovie.get());
        model.addAttribute("allDirectors", directorRepository.findAll());

        return "movieForm";
    }

    @GetMapping("/movie/delete/{title}")
    private String deleteMovie(@PathVariable("title") String title) {
        Optional<Movie> optionalMovie = movieRepository.findMovieByTitle(title);

        if (optionalMovie.isEmpty()) {
            return "redirect:/movie/overview";
        }

        movieRepository.delete(optionalMovie.get());

        return "redirect:/movie/overview";
    }



    @PostMapping("/movie/new")
    private String saveOrUpdateMovie(@ModelAttribute("movie") Movie movieToBeSaved, BindingResult result) {
        if (!result.hasErrors()) {
            movieRepository.save(movieToBeSaved);
        }

        return "redirect:/";
    }





} // end of class MovieController
