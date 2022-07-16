package com.example.demo.shared;

import com.example.demo.student.StudentService;
import com.example.demo.university.University;
import com.example.demo.university.UniversityService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SharedController {

    @Autowired
    SharedService sharedService;

    @GetMapping("link-student/{id}")
    private void linkStudentToUniversity(@RequestBody JsonNode jsonNode, @PathVariable long id){
        sharedService.linkStudentToUniversity(jsonNode,id);

    }
}
