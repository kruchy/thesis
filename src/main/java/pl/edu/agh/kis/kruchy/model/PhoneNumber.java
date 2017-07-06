package pl.edu.agh.kis.kruchy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PhoneNumber
{

    public Long getId()
    {
        return id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    public String getNumber()
    {
        return number;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        PhoneNumber that = (PhoneNumber) o;

        return number.equals(that.number);
    }

    @Override
    public int hashCode()
    {
        return number.hashCode();
    }

    private String number;

    public PhoneNumber(String number)
    {
        this.number = number.replace("-", "");
    }
}
