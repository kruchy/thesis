package pl.edu.agh.kis.kruchy.mongo.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import pl.edu.agh.kis.kruchy.common.model.User;
import pl.edu.agh.kis.kruchy.common.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@RepositoryDefinition(domainClass = User.class, idClass = String.class)
public interface DefaultMongoRepository extends UserRepository {
    List<User> findAllByName(String name);

    @Query("{'surname.surname'  :?0 }")
    List<User> findAllBySurname(String surname);

    @Query("{'phoneNumber.number' : ?0}")
    Optional<User> findByPhoneNumber(String phoneNumber);

}
