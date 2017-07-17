package pl.edu.agh.kis.kruchy.prevayler.model.builder;

import pl.edu.agh.kis.kruchy.prevayler.model.User;

public interface UserWithPhoneNumber {
    User withPhoneNumber(String phoneNumber);
}
