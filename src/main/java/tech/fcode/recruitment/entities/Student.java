package tech.fcode.recruitment.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "students")
@Data
@ToString
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "major", nullable = false)
    private String major;
    
    @Column(name = "student_id", nullable = false, unique = true)
    private String studentId;
    @Column(name = "semester", nullable = false)
    private String semester;
    
    @Column(name = "personal_email", nullable = false, unique = true)
    private String personalEmail;
    
    @Column(name = "phone", nullable = false, unique = true)
    private String phone;
     
}
