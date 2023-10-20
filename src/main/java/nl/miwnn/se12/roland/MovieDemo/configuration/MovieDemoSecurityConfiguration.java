package nl.miwnn.se12.roland.MovieDemo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author Roland in 't Hout <r.in.t.hout@st.hanze.nl>
 * Purpose of the program
 */
@Configuration
@EnableWebSecurity
public class MovieDemoSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests((authorize) -> authorize
                        .antMatchers("/css/**", "/webjars/**").permitAll()
                        .antMatchers("/", "/movie/overview").permitAll()
                        .anyRequest().authenticated())
                .formLogin().and()
                .logout().logoutSuccessUrl("/movie/overview");

        return httpSecurity.build();
    }

}