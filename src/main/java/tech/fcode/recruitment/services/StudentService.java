package tech.fcode.recruitment.services;

import tech.fcode.recruitment.dto.ResponseObject;
import tech.fcode.recruitment.dto.StudentDTO;

public interface StudentService {
    ResponseObject register(StudentDTO studentDTO);
}
