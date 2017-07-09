package pl.edu.agh.kis.kruchy.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pl.edu.agh.kis.kruchy.model.User;

import java.util.List;
import java.util.Optional;

public interface Repository extends CrudRepository<User, Long>
{
    List<User> findAllByName(String name);

    @Query("SELECT u from User u where u.surname.surname = :surname")
    List<User> findAllBySurname(@Param("surname") String surname);

    @Query("SELECT u from User u where u.phoneNumber.number = :phoneNumber")
    Optional<User> findByPhoneNumber(@Param("phoneNumber") String phoneNumber);

}
