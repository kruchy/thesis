package pl.edu.agh.kis.kruchy.common.model.builder;

import pl.edu.agh.kis.kruchy.common.model.Address;
import pl.edu.agh.kis.kruchy.common.model.PhoneNumber;
import pl.edu.agh.kis.kruchy.common.model.Surname;
import pl.edu.agh.kis.kruchy.common.model.User;

public final class UserBuilder implements UserWithAddress, UserWithSurname, UserWithName, UserWithPhoneNumber {
    private String name;
    private Surname surname;
    private Address address;
    private PhoneNumber phoneNumber;

    private UserBuilder() {
    }

    public static UserWithName anUser() {
        return new UserBuilder();
    }


    public UserWithSurname withName(String name) {
        this.name = name;
        return this;
    }

    public UserWithAddress withSurname(String surname) {
        this.surname = new Surname(surname);
        return this;
    }

    public UserWithPhoneNumber withAddress(String address, int number) {
        this.address = new Address(address, number);
        return this;
    }

    public User withPhoneNumber(String phoneNumber) {
        this.phoneNumber = new PhoneNumber(phoneNumber);
        return build();
    }

    private User build() {
        return new User(name, surname, address, phoneNumber);
    }

}


