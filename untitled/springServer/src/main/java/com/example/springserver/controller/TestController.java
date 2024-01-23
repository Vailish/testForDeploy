package com.example.springserver.controller;

import com.example.springserver.dto.CreateDataRequestDto;
import com.example.springserver.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping("/test")
    public ResponseEntity getTest() {
        return new ResponseEntity("abcde", HttpStatus.OK);
    }

    @PostMapping("/data")
    public ResponseEntity createData(@RequestBody CreateDataRequestDto createDataRequestDto) {
        return new ResponseEntity(testService.createData(createDataRequestDto),HttpStatus.CREATED);
    }

    @GetMapping("/data")
    public ResponseEntity getAllData() {
        return new ResponseEntity(testService.getAllData(), HttpStatus.OK);
    }

    @GetMapping("/data/{dataId}")
    public ResponseEntity getData(@PathVariable Long dataId){
        return new ResponseEntity(testService.getData(dataId), HttpStatus.OK);
    }

    @DeleteMapping("/data/{dataId}")
    public ResponseEntity deleteData(@PathVariable Long dataId){
        return new ResponseEntity(testService.deleteData(dataId), HttpStatus.OK);
    }

}
