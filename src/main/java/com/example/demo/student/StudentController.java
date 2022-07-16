package com.example.demo.student;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService  studentService;

    @GetMapping("student-list")
    private List<Student> getListOfStudents(){
        return studentService.getListOfStudents();
    }

    @PostMapping("student-save")
    private Student saveStudent(@RequestBody JsonNode student){
        System.out.println("test");
        return studentService.saveStudent(student);

    }

}
