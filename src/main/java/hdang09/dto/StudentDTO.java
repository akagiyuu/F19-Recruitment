/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hdang09.dto;

import hdang09.constants.RegexConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Admin
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudentDTO {

    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    @Schema(example = "Example", description = "First name of an account")
    private String firstName;

    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    @Schema(example = "Example", description = "Last name of an account")
    private String lastName;

    private String major;

    @Pattern(regexp = RegexConstants.STUDENT_ID_REGEX, message = "Invalid student ID format (Example correct format: SE191234)")
    @Schema(example = "SE191234", description = "Phone number of an account")
    private String studentId;

    @Schema(example = "LUK3", description = "Semester of a student: ['LUK1', 'LUK2', 'LUK3', 'LUK4', 'LUK5', 'LUK6', 'CN1', 'CN2', 'CN3']")
    private String semester;

    @Email(message = "Please enter a valid email")
    @Schema(example = "example@gmail.com", description = "Email of an account")
    private String personalEmail;

    @Pattern(regexp = RegexConstants.PHONE_NUMBER_REGEX, message = "Invalid phone number format (Example correct format: 0812345678)")
    @Schema(example = "0812345678", description = "Phone number of an account")
    private String phone;
}
