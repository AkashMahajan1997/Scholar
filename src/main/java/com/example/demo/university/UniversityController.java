package com.example.demo.university;

import com.example.demo.student.Student;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UniversityController {

    @Autowired
    private UniversityService universityService;

    @GetMapping("university-list")
    private List<University> getListOfUniversities(){
        return universityService.getListOfUniversities();
    }

    @PostMapping("university-save")
    private University  saveUniversity (@RequestBody JsonNode student){
        return universityService.saveUniversity(student);

    }



}
