package pl.edu.agh.kis.kruchy.common.model.builder;

import pl.edu.agh.kis.kruchy.common.model.User;

public interface UserWithPhoneNumber {
    User withPhoneNumber(String phoneNumber);
}
