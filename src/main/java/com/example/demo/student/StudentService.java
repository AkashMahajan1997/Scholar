package com.example.demo.student;


import com.example.demo.shared.Annotation.VerifyAge;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    ObjectMapper objectMapper;

    public List<Student> getListOfStudents() {
        return studentRepository.findAll();
    }

    public Student saveStudent(JsonNode jsonNode) {
        try {
            Student student = objectMapper.convertValue(jsonNode, Student.class);
            return studentRepository.save(student);
        } catch (Exception exception) {
            System.out.println(exception);
        }

        return null;
    }

    public Student getStudent(long id) {
        return studentRepository.findById(id).get();
    }

    @VerifyAge
    public String verifyAge() {
        return "you are eligible to apply ";
    }

    public Page<Student> getStudentListBasedOnPage(int pageNumber, int numberOfElementPerPage) {
        return studentRepository.findAll(PageRequest.of(pageNumber, numberOfElementPerPage));
    }

    public Student updateAge(JsonNode jsonNode, int age) {
        Student student = objectMapper.convertValue(jsonNode, Student.class);
        student.setAge(age);
        return studentRepository.save(student);

    }

}
