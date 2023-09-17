/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hdang09.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Admin
 * @param <T>
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Response<T> {

    private HttpStatus status;
    private String message;
    private T data;

    public Response(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
