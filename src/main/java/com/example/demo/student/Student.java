package com.example.demo.student;

import com.example.demo.shared.Address;
import com.example.demo.university.University;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String name;

    long age;

    private Address address;

    @OneToMany(mappedBy = "student",fetch =FetchType.EAGER)
    private List<University> universities;

}
