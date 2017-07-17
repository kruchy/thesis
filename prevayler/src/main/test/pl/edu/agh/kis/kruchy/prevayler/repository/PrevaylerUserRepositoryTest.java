package pl.edu.agh.kis.kruchy.prevayler.repository;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.prevayler.Prevayler;
import org.prevayler.PrevaylerFactory;
import pl.edu.agh.kis.kruchy.prevayler.model.User;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.edu.agh.kis.kruchy.prevayler.model.builder.UserBuilder.anUser;

public class PrevaylerUserRepositoryTest {

    private PrevaylerUserRepository repository;
    private Prevayler<Root> prevayler;

    @Before
    public void setUp() throws Exception {
        prevayler = PrevaylerFactory.createPrevayler(new Root());
        this.repository = new PrevaylerUserRepository(prevayler);
        User johnSmith = anUser().withName("John").withSurname("Smith").withAddress("Wroclawska", 10).withPhoneNumber("321321321");
        User johnWick = anUser().withName("John").withSurname("Wick").withAddress("Krolewska", 15).withPhoneNumber("123123123");
        User marySmith = anUser().withName("Mary").withSurname("Smith").withAddress("Lea", 20).withPhoneNumber("555555555");
        User edNorton = anUser().withName("John").withSurname("Smith").withAddress("Czarnowiejska", 25).withPhoneNumber("99999999");
        Stream.of(johnSmith, johnWick, marySmith, edNorton).forEach(
                user -> {
                    user.setId(UUID.randomUUID().toString());
                    prevayler.prevalentSystem().getUsers().put(user.getId(), user);
                });
    }

    @After
    public void tearDown() throws IOException {
        prevayler.prevalentSystem().getUsers().clear();
        prevayler.close();
    }

    @Test
    public void shouldSaveSuccessfullyUser() throws Exception {
        User babaYaga = anUser().withName("Baba").withSurname("Yaga").withAddress("Piernikowa", 5).withPhoneNumber("000000000");
        babaYaga.setId(UUID.randomUUID().toString());
        User storedBabaYaga = repository.save(babaYaga);
        assertThat(storedBabaYaga).isEqualTo(babaYaga);
    }

    @Test
    public void shouldReturnAllUsersByName() throws Exception {
        User johnSmith = anUser().withName("John").withSurname("Smith").withAddress("Wroclawska", 10).withPhoneNumber("321321321");
        User johnWick = anUser().withName("John").withSurname("Wick").withAddress("Krolewska", 15).withPhoneNumber("123123123");
        Stream.of(johnSmith, johnWick).forEach(
                user -> {
                    user.setId(UUID.randomUUID().toString());
                    prevayler.prevalentSystem().getUsers().put(user.getId(), user);
                });
        List<User> johns = repository.findAllByName("John");
        assertThat(johns).hasSize(2);
        assertThat(johns).contains(johnSmith, johnWick);
    }

    @Test
    public void shouldReturnUserById() throws Exception {

    }

    @Test
    public void shouldReturnUsersBySurname() throws Exception {

    }


    @Test
    public void shouldDeleteUser() throws Exception {

    }


}