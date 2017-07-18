package pl.edu.agh.kis.kruchy.common.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.regex.Pattern;

@Entity
public class Surname implements Serializable {

    @Id
    String id;

    public String getId() {
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
