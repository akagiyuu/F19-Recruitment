/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hdang09.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Admin
 * @param <T>
 */

@Getter
@Setter
@ToString
public class Response<T> extends ResponseEntity<T> {

    private int code;
    private String message;
//    private T data;

    public Response(HttpStatus status, String message, T data) {
        super(data, status);
        this.code = status.value();
        this.message = message;
//        this.data = data;
    }

    public Response(HttpStatus status, String message) {
        super(status);
        this.code = status.value();
        this.message = message;
//        this.data = null;
    }
}
