package nl.miwnn.se12.roland.MovieDemo.controller;

import lombok.RequiredArgsConstructor;
import nl.miwnn.se12.roland.MovieDemo.model.Director;
import nl.miwnn.se12.roland.MovieDemo.repository.DirectorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author Roland in 't Hout <r.in.t.hout@st.hanze.nl>
 * Purpose of the program
 */

@Controller
@RequestMapping("/director")
@RequiredArgsConstructor
public class DirectorController {
    private final DirectorRepository directorRepository;


    @GetMapping("/overview")
    protected String showDirectorOverview(Model model) {
        model.addAttribute("allDirectors", directorRepository.findAll());
        model.addAttribute("newDirector", new Director());
        return "directorOverview";
    }

    @PostMapping("/new")
    protected String saveOrUpdateDirector(@ModelAttribute("newDirector") Director director, BindingResult result) {
        if (!result.hasErrors()) {
            directorRepository.save(director);
        }

        return "redirect:/director/overview";
    }

} // end of class DirectorController





