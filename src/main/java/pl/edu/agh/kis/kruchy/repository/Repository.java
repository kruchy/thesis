package pl.edu.agh.kis.kruchy.repository;

import org.springframework.data.repository.CrudRepository;

import pl.edu.agh.kis.kruchy.model.User;

public interface Repository extends CrudRepository<User, Long>
{
}
