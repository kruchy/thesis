package pl.edu.agh.kis.kruchy.repository;

import org.springframework.data.repository.CrudRepository;
import pl.edu.agh.kis.kruchy.model.User;

import java.util.List;

public interface Repository extends CrudRepository<User, Long>
{
    List<User> findAllByName(String name);
}
