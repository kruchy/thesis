package pl.edu.agh.kis.kruchy.common.model.builder;

public interface UserWithAddress {
    UserWithPhoneNumber withAddress(String address, int number);
}
