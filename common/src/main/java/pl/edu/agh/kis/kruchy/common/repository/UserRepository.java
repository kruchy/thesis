package pl.edu.agh.kis.kruchy.common.repository;


import org.springframework.data.repository.RepositoryDefinition;
import pl.edu.agh.kis.kruchy.common.model.User;

import java.util.List;
import java.util.Optional;

@RepositoryDefinition(domainClass = User.class, idClass = String.class)
public interface UserRepository {
    List<User> findAllByName(String name);

    List<User> findAllBySurname(String surname);

    Optional<User> findByPhoneNumber(String phoneNumber);

    List<User> findAll();

    Optional<User> findById(String id);

    <T extends User> T save(T user);

    void delete(User user);

    void delete(String id);

    void deleteAll();


}
