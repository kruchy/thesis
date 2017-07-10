package pl.edu.agh.kis.kruchy.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document
public class Address implements Serializable {

    public Long getId() {
        return id;
    }

    @Id
    Long id;
    private String street;

    private Integer number;

    public Address(String street, Integer number) {
        this.street = street;
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public String getStreet() {
        return street;
    }


}
