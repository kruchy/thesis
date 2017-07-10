package pl.edu.agh.kis.kruchy.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document
public class PhoneNumber implements Serializable {

    public Long getId() {
        return id;
    }

    @Id
    Long id;

    public String getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        PhoneNumber that = (PhoneNumber) o;

        return number.equals(that.number);
    }

    @Override
    public int hashCode() {
        return number.hashCode();
    }

    private String number;

    public PhoneNumber(String number) {
        this.number = number.replace("-", "");
    }
}
