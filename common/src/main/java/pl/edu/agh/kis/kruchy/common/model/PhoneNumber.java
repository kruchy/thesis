package pl.edu.agh.kis.kruchy.common.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
public class PhoneNumber implements Serializable {

    public BigInteger getId() {
        return id;
    }

    @Id
    BigInteger id;

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
