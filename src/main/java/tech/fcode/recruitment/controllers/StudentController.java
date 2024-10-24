package tech.fcode.recruitment.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import tech.fcode.recruitment.dto.StudentDTO;
import tech.fcode.recruitment.services.StudentService;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService service;
    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody StudentDTO student) {
        return service.register(student);
    }
}