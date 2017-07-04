package pl.edu.agh.kis.kruchy.repository;

import pl.edu.agh.kis.kruchy.model.User;

import javax.transaction.Transactional;

import org.springframework.transaction.annotation.Propagation;

@org.springframework.stereotype.Repository

public class HibernateRepository implements Repository
{
    public User findByUsername(String name)
    {
        return null;
    }

    public User findById(Integer id)
    {
        return null;
    }

    public boolean saveUser(User user)
    {
        return false;
    }

    public boolean deleteUser(User user)
    {
        return false;
    }

    public boolean updateUser(User user)
    {
        return false;
    }
}
