package pl.edu.agh.kis.kruchy.common.model;

import org.junit.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;


class UserTest {

    @Test
    public void sameUsersWithDifferentIdShouldBeEqual() {

        Surname surname = Mockito.mock(Surname.class);
        PhoneNumber phoneNumber = Mockito.mock(PhoneNumber.class);
        Address address = Mockito.mock(Address.class);
        String name = "";

        User user1 = new User(name, surname, address, phoneNumber);
        user1.setId("1");
        User user2 = new User(name, surname, address, phoneNumber);
        user2.setId("2");
        assertThat(user1).isEqualTo(user2);
    }


}
