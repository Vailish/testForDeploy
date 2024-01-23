package com.example.springserver.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class TestController {

    @GetMapping("/test")
    public ResponseEntity getTest() {
        return new ResponseEntity("abcde", HttpStatus.OK);
    }

    @PostMapping("/test")
    public ResponseEntity createData() {
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
