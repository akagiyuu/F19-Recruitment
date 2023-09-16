/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hdang09.exception;

import hdang09.entities.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Response handleException(Exception ex) {
        return new Response(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    // Add more exception handling methods as needed for specific exceptions
    // For example:
    /*
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException ex) {
        // Create an error response object
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Resource not found");
        // Set other properties of the error response as needed

        // Return the error response with an appropriate HTTP status code
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    */
}