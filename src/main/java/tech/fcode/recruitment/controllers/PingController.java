package tech.fcode.recruitment.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "ping")
public class PingController {
    @GetMapping()
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("Hello world");
    }
}
