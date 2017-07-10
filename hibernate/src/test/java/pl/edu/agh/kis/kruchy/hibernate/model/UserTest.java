package pl.edu.agh.kis.kruchy.hibernate.model;

import org.mockito.Mockito;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


class UserTest
{
    @Test
    public void sameUsersWithDifferentIdShouldBeEqual()
    {

        Surname surname = Mockito.mock(Surname.class);
        PhoneNumber phoneNumber = Mockito.mock(PhoneNumber.class);
        Address address = Mockito.mock(Address.class);
        String name = "";

        User user1 = new User(name,surname,address,phoneNumber);
        user1.setId(1L);
        User user2 = new User(name,surname,address,phoneNumber);
        user2.setId(2L);
        assertThat(user1).isEqualTo(user2);
    }



}
