package pl.edu.agh.kis.kruchy.repository;

import pl.edu.agh.kis.kruchy.model.User;

public interface Repository
{
    public User findByUsername(String name);

    User findById(Integer id);

    boolean saveUser(User user);

    boolean deleteUser(User user);

    boolean updateUser(User user);
}
