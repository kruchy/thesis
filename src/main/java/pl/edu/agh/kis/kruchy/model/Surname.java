package pl.edu.agh.kis.kruchy.model;

import java.util.regex.Pattern;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Surname
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    public Long getId()
    {
        return id;
    }

    private String surname;

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Surname surname1 = (Surname) o;

        return surname.equals(surname1.surname);
    }

    @Override
    public int hashCode()
    {
        return surname.hashCode();
    }

    private static Pattern surnamePattern = Pattern.compile("^[A-Z][a-z]{2,15}$");

    public Surname(String surname)
    {
        this.surname = surname;
    }

    public static boolean validate(String surname)
    {
        return surnamePattern.matcher(surname).matches();
    }

    public String getSurname()
    {
        return surname;
    }
}
