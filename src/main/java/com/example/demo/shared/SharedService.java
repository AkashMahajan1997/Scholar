package com.example.demo.shared;

import com.example.demo.student.Student;
import com.example.demo.student.StudentService;
import com.example.demo.university.University;
import com.example.demo.university.UniversityService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SharedService {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    StudentService studentService;

    @Autowired
    UniversityService universityService;

    public void linkStudentToUniversity(JsonNode jsonNode, long id) {
        University university = objectMapper.convertValue(jsonNode,University.class);
        Student student = studentService.getStudent(id);
      university.setStudent(student);
        universityService.updateUniversity(university);
    }
}
