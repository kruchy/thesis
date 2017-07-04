package pl.edu.agh.kis.kruchy.model;

public class Address
{
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
