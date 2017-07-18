package pl.edu.agh.kis.kruchy.common.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.regex.Pattern;

@Entity
public class Surname implements Serializable {

    @Transient
    private static Pattern surnamePattern = Pattern.compile("^[A-Z][a-z]{2,15}$");

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    String id;

    private String surname;

    public Surname() {
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Surname(String surname) {
        this.surname = surname;
    }

    public String getId() {
        return id;
    }

    public static boolean validate(String surname) {
        return surnamePattern.matcher(surname).matches();
    }

    public String getSurname() {
        return surname;
    }

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
}
