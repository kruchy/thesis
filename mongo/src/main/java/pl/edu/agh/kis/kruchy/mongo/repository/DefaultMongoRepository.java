package pl.edu.agh.kis.kruchy.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.edu.agh.kis.kruchy.mongo.model.User;

public interface DefaultMongoRepository extends MongoRepository<User, Long> {
//    List<User> findAllByName(String name);

//    List<User> findAllBySurname(String surname);

//    Optional<User> findByPhoneNumber(String phoneNumber);

}
