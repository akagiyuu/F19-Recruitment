/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tech.fcode.recruitment.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tech.fcode.recruitment.dto.StudentDTO;

@Entity
@Table(name = "students")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;
    private String major;
    
    @Column(name = "student_id")
    private String studentId;
    
    private String semester;
    
    @Column(name = "personal_email")
    private String personalEmail;
    
    @Column(name = "phone")
    private String phone;
    
    public Student fromStudentDTO(StudentDTO studentDTO) {
        Student student = new Student();
        
        student.setFirstName(studentDTO.getFirstName().trim());
        student.setLastName(studentDTO.getLastName().trim());
        student.setMajor(studentDTO.getMajor().trim());
        student.setStudentId(studentDTO.getStudentId().trim());
        student.setSemester(studentDTO.getSemester().trim());
        student.setPersonalEmail(studentDTO.getPersonalEmail().trim());
        student.setPhone(studentDTO.getPhone().trim());
        
        return student;
    }
}
