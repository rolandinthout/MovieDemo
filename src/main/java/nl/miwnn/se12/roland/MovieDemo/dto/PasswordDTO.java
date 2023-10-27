package nl.miwnn.se12.roland.MovieDemo.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Roland in 't Hout <r.in.t.hout@st.hanze.nl>
 * Information needed to change a password
 */
@Getter @Setter
public class PasswordDTO {
    private String oldPassword;
    private String newPassword;
    private String confirmPassword;

} // end of class PasswordDTO
