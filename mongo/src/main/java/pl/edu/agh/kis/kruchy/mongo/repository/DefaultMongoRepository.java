package pl.edu.agh.kis.kruchy.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import pl.edu.agh.kis.kruchy.mongo.model.User;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public interface DefaultMongoRepository extends MongoRepository<User, BigInteger> {
    List<User> findAllByName(String name);

    @Query("{'surname.surname'  :?0 }")
    List<User> findAllBySurname(String surname);

    @Query("{'phoneNumber.number' : ?0}")
    Optional<User> findByPhoneNumber(String phoneNumber);

    List<User> findAll();

    Optional<User> findById(String id);

    <T extends User> T save(T user);


}
