package com.example.demo.shared;

import lombok.Data;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class Address implements Serializable {

    String houseNumber;
    String sector;
    String city;
    String State;

}
