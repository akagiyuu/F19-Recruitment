package hdang09.controllers;

import hdang09.dto.StudentDTO;
import hdang09.entities.Student;
import hdang09.services.StudentService;
import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/student")
@Tag(name = "Student")
public class StudentController {

    @Autowired
    StudentService service = new StudentService();

    @PostMapping("/register")
    @Operation(summary = "Register account")
    public ResponseEntity<String> register(@Valid @RequestBody StudentDTO student) {
        return service.register(student);
    }

    @GetMapping("/all")
    @Operation(summary = "Get all account")
    public ResponseEntity<List<Student>> getAll() {
        return service.getAll();
    }

    @GetMapping("/{studentId}")
    @Operation(summary = "Get account by student ID (Example: SE123456)")
    public ResponseEntity<?> getByStudentId(@PathVariable String studentId) {
        return service.getByStudentId(studentId);
    }
}
