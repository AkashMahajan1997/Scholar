package com.example.demo.shared;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Embeddable
@Data
public class Address {

    String houseNumber;
    String sector;
    String city;
    String State;

}
