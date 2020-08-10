package uk.gorodny.securitydemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @GetMapping("/hello")
    public ResponseEntity<String> getHello() {
        return new ResponseEntity<>("hello-url", HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<String> getUser() {
        return new ResponseEntity<>("user-url", HttpStatus.OK);
    }

    @GetMapping("/admin")
    public ResponseEntity<String> getAdmin() {
        return new ResponseEntity<>("admin-url", HttpStatus.OK);
    }
}
