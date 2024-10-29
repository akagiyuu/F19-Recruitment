package tech.fcode.recruitment.dto;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponseObject {
    HttpStatus status;
    boolean success;
    Object data;
    String message;
}
