package tech.fcode.recruitment.services;

import org.springframework.http.ResponseEntity;

import tech.fcode.recruitment.dto.StudentDTO;

public interface StudentService {
    ResponseEntity<String> register(StudentDTO studentDTO);
}
