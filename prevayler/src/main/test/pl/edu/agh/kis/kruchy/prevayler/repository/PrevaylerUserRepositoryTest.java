package pl.edu.agh.kis.kruchy.prevayler.repository;


import org.apache.commons.lang.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.prevayler.Prevayler;
import org.prevayler.PrevaylerFactory;
import pl.edu.agh.kis.kruchy.prevayler.model.User;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.edu.agh.kis.kruchy.prevayler.model.builder.UserBuilder.anUser;

public class PrevaylerUserRepositoryTest {

    private PrevaylerUserRepository repository;
    private Prevayler<Root> prevayler;

    @Before
    public void setUp() throws Exception {
        prevayler = PrevaylerFactory.createTransientPrevayler(new Root());
        this.repository = new PrevaylerUserRepository(prevayler);
    }

    @After
    public void tearDown() throws IOException {
        prevayler.prevalentSystem().getUsers().clear();
        prevayler.close();

    }

    @Test
    public void shouldSaveSuccessfullyUser() throws Exception {
        User babaYaga = testUser("Baba", "Yaga");
        babaYaga.setId(UUID.randomUUID().toString());
        User storedBabaYaga = repository.save(babaYaga);
        assertThat(storedBabaYaga).isEqualTo(babaYaga);
    }

    @Test
    public void shouldReturnAllUsersByName() throws Exception {
        User johnSmith = testUser("John", "Smith");
        User johnWick = testUser("John", "Wick");
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
        User johnSmith = testUser("John", "Smith");
        johnSmith.setId(UUID.randomUUID().toString());
        prevayler.prevalentSystem().getUsers().put(johnSmith.getId(), johnSmith);
        Optional<User> foundJohnSmith = repository.findById(johnSmith.getId());
        assertThat(foundJohnSmith).isPresent();
        assertThat(foundJohnSmith).hasValue(johnSmith);
    }

    @Test
    public void shouldReturnAll() throws Exception {

        IntStream.range(0, 10).boxed().forEach(i -> {
            User user = testUser();
            user.setId(UUID.randomUUID().toString());
            prevayler.prevalentSystem().getUsers().put(user.getId(), user);
        });

        List<User> all = repository.findAll();
        assertThat(all).hasSize(10);
    }

    @Test
    public void shouldReturnUsersBySurname() throws Exception {

        User johnSmith = testUser("John", "Smith");
        User marySmith = testUser("Mary", "Smith");
        Stream.of(johnSmith, marySmith).forEach(
                user -> {
                    user.setId(UUID.randomUUID().toString());
                    prevayler.prevalentSystem().getUsers().put(user.getId(), user);
                });
        List<User> johns = repository.findAllBySurname("Smith");
        assertThat(johns).hasSize(2);
        assertThat(johns).contains(johnSmith, marySmith);
    }

    @Test
    public void shouldDeleteUser() throws Exception {

    }

    private User testUser(String name, String surname, String phoneNumber) {
        return anUser().withName(name).withSurname(surname).withAddress(RandomStringUtils.randomAlphabetic(15), new Random().nextInt(50) + 1).withPhoneNumber(phoneNumber);
    }

    private User testUser(String name, String surname) {
        return anUser().withName(name).withSurname(surname).withAddress(RandomStringUtils.randomAlphabetic(15), new Random().nextInt(50) + 1).withPhoneNumber(RandomStringUtils.random(9));
    }


    private User testUser() {
        return anUser().withName(RandomStringUtils.random(10)).withSurname(RandomStringUtils.random(10)).withAddress(RandomStringUtils.randomAlphabetic(15), new Random().nextInt(50) + 1).withPhoneNumber(RandomStringUtils.random(9));
    }


}