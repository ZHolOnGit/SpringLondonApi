package com.LondonApiTest.controller;

import com.LondonApiTest.model.Person;
import com.LondonApiTest.service.LondonService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/London")
@RequiredArgsConstructor
public class LondonController {
    private final LondonService londonService;
    @GetMapping
    public ResponseEntity<List<Person>> getAllLondonPeople(){
        List<Person> personList = londonService.findLondonders();

        return new ResponseEntity<>(personList, HttpStatus.OK);
    }



}
