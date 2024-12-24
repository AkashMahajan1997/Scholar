package com.example.demo.student;

import com.example.demo.shared.Annotation.VerifyAge;
import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.annotations.ApiOperation;
import lombok.extern.apachecommons.CommonsLog;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CommonsLog
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("student-list")
    @ApiOperation(value = "Get list of student",
            response = Student.class,
            notes = "some notes")
    private List<Student> getListOfStudents() {
        return studentService.getListOfStudents();
    }

    @PostMapping("student-save")
    private Student saveStudent(@RequestBody JsonNode student) {
        System.out.println("test");
        return studentService.saveStudent(student);
    }

    @GetMapping("/verify-age")
    public String verifyAge(@RequestParam int age) {
        return studentService.verifyAge();
    }

    @GetMapping("/student/{id}")
    // @Cacheable(value = "student",key ="#id")
    public Student getStudent(@PathVariable(value = "id") long id) {
        return studentService.getStudent(id);
    }

    @GetMapping("/page")
    public Page<Student> getStudentListBasedOnPage(@RequestParam int pageNumber, @RequestParam int numberOfElement) {
        return studentService.getStudentListBasedOnPage(pageNumber, numberOfElement);
    }

    @PatchMapping("/update-age/{age}")
    public Student updateAge(@RequestBody JsonNode jsonNode, @PathVariable("age") int age) {
        log.info("yo yo");
        return studentService.updateAge(jsonNode, age);
    }
}
