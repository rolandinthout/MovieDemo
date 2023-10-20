package nl.miwnn.se12.roland.MovieDemo.service;

import lombok.RequiredArgsConstructor;
import nl.miwnn.se12.roland.MovieDemo.repository.MovieDbUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Roland in 't Hout <r.in.t.hout@st.hanze.nl>
 * Purpose of the program
 */
@Service
@RequiredArgsConstructor
public class MovieDbUserDetailsService implements UserDetailsService {
    private final MovieDbUserRepository movieDbUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return movieDbUserRepository.findMovieDbUserByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException(String.format("User: %s does not exist", username))
        );
    }
} // end of class MovieDbUserDetailsService
