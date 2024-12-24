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
    StudentService studentService;

    @Autowired
    UniversityService universityService;

    public void linkStudentToUniversity(long studentId, long universityId) {

        University university = universityService.getUniversityById(universityId);
        Student student = studentService.getStudent(studentId);
        university.setStudent(student);
        universityService.updateUniversity(university);
    }

}
