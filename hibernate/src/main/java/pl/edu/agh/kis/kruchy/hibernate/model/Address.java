package pl.edu.agh.kis.kruchy.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Address implements Serializable
{

    public Long getId()
    {
        return id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String street;

    private Integer number;

    public Address(String street, Integer number)
    {
        this.street = street;
        this.number = number;
    }
    public Integer getNumber()
    {
        return number;
    }

    public String getStreet()
    {
        return street;
    }


}
