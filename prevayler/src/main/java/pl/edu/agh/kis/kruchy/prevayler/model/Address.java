package pl.edu.agh.kis.kruchy.prevayler.model;


import java.io.Serializable;
import java.math.BigInteger;

public class Address implements Serializable {

    public BigInteger getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (!street.equals(address.street)) return false;
        return number.equals(address.number);
    }

    @Override
    public int hashCode() {
        int result = street.hashCode();
        result = 31 * result + number.hashCode();
        return result;
    }

    BigInteger id;
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