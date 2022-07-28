package com.example.demo.student;

import com.example.demo.shared.Annotation.VerifyAge;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/verify-age")
    public String verifyAge(@RequestParam int age){
        return studentService.verifyAge();
    }

    @GetMapping("/student/{id}")
    @Cacheable(value = "student",key ="#id")
    public Student getStudent(@PathVariable(value = "id") long id){
        return studentService.getStudent(id);
    }
}
