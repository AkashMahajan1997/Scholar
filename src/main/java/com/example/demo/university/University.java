package com.example.demo.university;

import com.example.demo.student.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class University implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String universityName;

    @JsonIgnore
    @ManyToOne
    private Student student;






}
