package nl.miwnn.se12.roland.MovieDemo.controller;

import lombok.RequiredArgsConstructor;
import nl.miwnn.se12.roland.MovieDemo.dto.PasswordDTO;
import nl.miwnn.se12.roland.MovieDemo.model.MovieDbUser;
import nl.miwnn.se12.roland.MovieDemo.repository.MovieDbUserRepository;

import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Roland in 't Hout <r.in.t.hout@st.hanze.nl>
 * Handle everything regarding MovieDbUser objects
 */
@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class MovieDbUserController {
    private final MovieDbUserRepository movieDbUserRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/changepassword")
    private String getChangePasswordForm(Model model) {
        model.addAttribute("passwordDetails", new PasswordDTO());

        return "passwordForm";
    }

    @PostMapping("/changepassword")
    private String updatePassword(
            @ModelAttribute("passowrdDetails") PasswordDTO passwordDTO, Authentication authentication) {
        MovieDbUser user = (MovieDbUser) authentication.getPrincipal();

        if (passwordEncoder.matches(passwordDTO.getOldPassword(), user.getPassword())
                && passwordDTO.getNewPassword().equals(passwordDTO.getConfirmPassword())) {

            user.setPassword(passwordEncoder.encode(passwordDTO.getNewPassword()));
            movieDbUserRepository.save(user);
        }

        return "redirect:/";


    }



} // end of class MovieDbUserController
