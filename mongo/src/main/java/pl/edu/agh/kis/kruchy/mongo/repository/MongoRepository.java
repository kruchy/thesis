package pl.edu.agh.kis.kruchy.mongo.repository;

import org.springframework.data.repository.RepositoryDefinition;
import pl.edu.agh.kis.kruchy.mongo.model.User;

@RepositoryDefinition(domainClass = User.class, idClass = String.class)
public interface MongoRepository extends UserRepository {
}
