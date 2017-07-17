package pl.edu.agh.kis.kruchy.prevayler.repository;

import pl.edu.agh.kis.kruchy.prevayler.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> findAllByName(String name);

    List<User> findAllBySurname(String surname);

    Optional<User> findByPhoneNumber(String phoneNumber);

    List<User> findAll();

    Optional<User> findById(String id);

    <T extends User> T save(T user);

    void delete(User user);

    void delete(String id);
}
