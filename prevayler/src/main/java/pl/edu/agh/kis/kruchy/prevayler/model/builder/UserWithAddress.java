package pl.edu.agh.kis.kruchy.prevayler.model.builder;

public interface UserWithAddress {
    UserWithPhoneNumber withAddress(String address, int number);
}
