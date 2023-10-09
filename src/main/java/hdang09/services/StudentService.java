/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hdang09.services;

import hdang09.constants.RegexConstants;
import hdang09.dto.StudentDTO;
import hdang09.entities.Student;
import hdang09.repositories.StudentRepository;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public ResponseEntity<String> register(StudentDTO studentDTO) {
        Student student = new Student().fromStudentDTO(studentDTO);

        Student studentDb = repo.getByStudentId(student.getStudentId());
        if (studentDb != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This student ID has been used");
        }
        
        studentDb = repo.getByPersonalEmail(student.getPersonalEmail());
        if (studentDb != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This personal email has been used");
        }

        // Validate phone number is unique???

        String[] SEMESTERS = {"LUK1", "LUK2", "LUK3", "LUK4", "LUK5", "LUK6", "CN1", "CN2", "CN3"};
        String studentSemester = student.getSemester();
        if (!Arrays.asList(SEMESTERS).contains(studentSemester)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Semester must in ['LUK1', 'LUK2', 'LUK3', 'LUK4', 'LUK5', 'LUK6', 'CN1', 'CN2', 'CN3']");
        }

        repo.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body("Registered successfully!");
    }

    public ResponseEntity<List<Student>> getAll() {
        List<Student> students = repo.getAllStudent();
        
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

    public ResponseEntity<?> getByStudentId(String studentId) {
        if (!studentId.matches(RegexConstants.STUDENT_ID_REGEX)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid student ID format (Example correct format: SE191234)");
        }

        Student student = repo.getByStudentId(studentId);
        if (student == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cannot find student with student ID " + studentId + "!");
        }
        
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }
}
