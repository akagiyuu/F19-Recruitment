package hdang09.controllers;

import hdang09.dto.StudentDTO;
import hdang09.entities.Response;
import hdang09.entities.Student;
import hdang09.services.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService service = new StudentService();

    @PostMapping("/register")
    public ResponseEntity<Response<Student>> register(@RequestBody StudentDTO student) {
        return service.register(student);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAll() {
        return service.getAll();
    }
    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getUserResult(@PathVariable String studentId) {
        return service.getStudentbyStudentId(studentId);
    }
}
