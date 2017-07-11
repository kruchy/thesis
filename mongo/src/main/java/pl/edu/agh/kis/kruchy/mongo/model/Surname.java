package pl.edu.agh.kis.kruchy.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.regex.Pattern;


@Document
public class Surname implements Serializable {
    @Id
    BigInteger id;

    public BigInteger getId() {
        return id;
    }

    private String surname;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Surname surname1 = (Surname) o;

        return surname.equals(surname1.surname);
    }

    @Override
    public int hashCode() {
        return surname.hashCode();
    }

    private static Pattern surnamePattern = Pattern.compile("^[A-Z][a-z]{2,15}$");

    public Surname(String surname) {
        this.surname = surname;
    }

    public static boolean validate(String surname) {
        return surnamePattern.matcher(surname).matches();
    }

    public String getSurname() {
        return surname;
    }
}
