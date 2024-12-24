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

    @GetMapping("link-student/{studentId}")
        private void linkStudentToUniversity( @PathVariable long studentId,@RequestParam("universityId") long universityId){
        sharedService.linkStudentToUniversity(studentId,universityId);

    }
}
