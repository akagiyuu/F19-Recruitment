/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hdang09.services;

import hdang09.dto.StudentDTO;
import hdang09.entities.Response;
import hdang09.entities.Student;
import hdang09.repositories.StudentRepository;
import java.util.ArrayList;
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

    public ResponseEntity<Response<Student>> register(StudentDTO studentDTO) {
        Student student = new Student().fromStudentDTO(studentDTO);

        Student studentDb = repo.getByStudentId(student.getStudentId());
        if (studentDb != null) {
            Response response = new Response(HttpStatus.BAD_REQUEST, "This student ID has been used");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        //        String userDbName = userDb.getName().toUpperCase();
        //        if (!userDbName.equals(name)) {
        //            CustomResponse response = new CustomResponse(false, "Họ tên không trùng với MSSV đã đăng ký trước đó!");
        //            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        //
        
        studentDb = repo.getByPersonalEmail(student.getPersonalEmail());
        if (studentDb != null) {
            Response response = new Response(HttpStatus.BAD_REQUEST, "This personal email has been used");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        // Validate phone numbe is unique???
        
        if (student.getFirstName().length() > 100) {
            Response response = new Response(HttpStatus.BAD_REQUEST, "First name not larger than 100 characters");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        if (student.getLastName().length() > 100) {
            Response response = new Response(HttpStatus.BAD_REQUEST, "Last name not larger than 100 characters");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        String studentIdRegex = "^(S|s|H|h|D|d)[E|e|A|a|S|s]+([0-9]{6})$";
        if (!student.getStudentId().matches(studentIdRegex)) {
            Response response = new Response(HttpStatus.BAD_REQUEST, "Student ID is not correct");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        String[] SEMESTERS = {"LUK1", "LUK2", "LUK3", "LUK4", "LUK5", "LUK6", "CN1", "CN2", "CN3"};
        String studentSemester = student.getSemester();
        if (!Arrays.asList(SEMESTERS).contains(studentSemester)) {
            Response response = new Response(HttpStatus.BAD_REQUEST, "Semester must in ['LUK1', 'LUK2', 'LUK3', 'LUK4', 'LUK5', 'LUK6', 'CN1', 'CN2', 'CN3']");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        String mailRegex = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        if (!student.getPersonalEmail().matches(mailRegex)) {
            Response response = new Response(HttpStatus.BAD_REQUEST, "Personal email is not correct");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        String phoneRegex = "^(0|\\+?84)(3|5|7|8|9)[0-9]{8}$";
        if (!student.getPhone().matches(phoneRegex)) {
            Response response = new Response(HttpStatus.BAD_REQUEST, "Not correct phone number. Phone region must be in Vietnam");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        student = repo.save(student);
        Response response = new Response(HttpStatus.CREATED, "Register successfully!", student);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    public ResponseEntity<List<Student>> getAll() {
        List<Student> students = new ArrayList<>();

        for (Student student : repo.findAll()) {
            students.add(student);
        }
        
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

    public ResponseEntity<Response<Student>> getByStudentId(String studentId) {
        Student student = repo.getByStudentId(studentId);
        
        if (student == null) {
            Response response = new Response(HttpStatus.NOT_FOUND, "Cannot find student with student ID " + studentId + "!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        
        Response response = new Response(HttpStatus.OK, "Get data of student with student ID " + studentId + " successfully", student);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
