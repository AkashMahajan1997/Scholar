package com.example.demo.university;

import com.example.demo.student.Student;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityService {

    @Autowired
    UniversityRepository universityRepository;

    @Autowired
    ObjectMapper objectMapper;


    public List<University> getListOfUniversities() {
        List<University> universities = universityRepository.findAll();
        return universities;
    }

    public University saveUniversity(JsonNode jsonNode) {
        University university = objectMapper.convertValue(jsonNode, University.class);
        return universityRepository.save(university);
    }

    public void updateUniversity(University university) {
        universityRepository.save(university);
    }


    public University getUniversityById(long universityId) {
       return  universityRepository.getReferenceById(universityId);
    }
}
