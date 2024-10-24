/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tech.fcode.recruitment.services.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tech.fcode.recruitment.constants.RegexConstants;
import tech.fcode.recruitment.dto.StudentDTO;
import tech.fcode.recruitment.entities.Student;
import tech.fcode.recruitment.repositories.StudentRepository;
import tech.fcode.recruitment.services.StudentService;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repo;

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
        studentDb = repo.getByPhone(student.getPhone());
        if (studentDb != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This phone number has been used");
        }

        String[] SEMESTERS = {"LUK1", "LUK2", "LUK3", "LUK4", "TRS4", "TRS5", "TRS6", "CN1", "CN2", "CN3"};
        String studentSemester = student.getSemester();
        if (!Arrays.asList(SEMESTERS).contains(studentSemester)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Semester must in ['LUK1', 'LUK2', 'LUK3', 'LUK4', 'TRS4', 'TRS5', 'TRS6', 'CN1', 'CN2', 'CN3']");
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
