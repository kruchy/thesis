package pl.edu.agh.kis.kruchy.hibernate.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;
import pl.edu.agh.kis.kruchy.common.model.User;
import pl.edu.agh.kis.kruchy.common.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@RepositoryDefinition(domainClass = User.class, idClass = String.class)
public interface HibernateRepository extends UserRepository {
    List<User> findAllByName(String name);

    @Query("SELECT u from User u where u.surname.surname = :surname")
    List<User> findAllBySurname(@Param("surname") String surname);

    @Query("SELECT u from User u where u.phoneNumber.number = :phoneNumber")
    Optional<User> findByPhoneNumber(@Param("phoneNumber") String phoneNumber);

}
