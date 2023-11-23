package hdang09.controllers;

import hdang09.dto.StudentDTO;
import hdang09.entities.Student;
import hdang09.services.StudentService;
import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/student")
//@Tag(name = "Student")
public class StudentController {

    @Autowired
    StudentService service = new StudentService();

    @PostMapping("/register")
//    @Operation(summary = "Register account")
    public ResponseEntity<String> register(@Valid @RequestBody StudentDTO student) {
        return service.register(student);
    }

}
