package pl.edu.agh.kis.kruchy.model.builder;

import pl.edu.agh.kis.kruchy.model.Address;
import pl.edu.agh.kis.kruchy.model.PhoneNumber;
import pl.edu.agh.kis.kruchy.model.Surname;
import pl.edu.agh.kis.kruchy.model.User;

public final class UserBuilder
{
    private Long id;
    private String name;
    private Surname surname;
    private Address address;
    private PhoneNumber phoneNumber;

    private UserBuilder()
    {
    }

    public static UserBuilder anUser()
    {
        return new UserBuilder();
    }


    public UserBuilder withName(String name)
    {
        this.name = name;
        return this;
    }

    public UserBuilder withSurname(String surname)
    {
        this.surname = new Surname(surname);
        return this;
    }

    public UserBuilder withAddress(String address,Integer number)
    {
        this.address = new Address(address,number);
        return this;
    }

    public UserBuilder withPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = new PhoneNumber(phoneNumber);
        return this;
    }

    public User build()
    {
        return new User(name,surname,address,phoneNumber);
    }
}
