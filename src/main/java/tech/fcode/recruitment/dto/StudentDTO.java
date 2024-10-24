/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tech.fcode.recruitment.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tech.fcode.recruitment.constants.RegexConstants;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudentDTO {
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    private String firstName;
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastName;
    private String major;
    @Pattern(regexp = RegexConstants.STUDENT_ID_REGEX, message = "Invalid student ID format (Example correct format: SE191234)")
    private String studentId;
    private String semester;
    @Email(message = "Please enter a valid email")
    private String personalEmail;
    @Pattern(regexp = RegexConstants.PHONE_NUMBER_REGEX, message = "Invalid phone number format (Example correct format: 0812345678)")
    private String phone;
}
