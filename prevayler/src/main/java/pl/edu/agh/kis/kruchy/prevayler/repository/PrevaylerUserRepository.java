package pl.edu.agh.kis.kruchy.prevayler.repository;


import org.prevayler.Prevayler;
import org.prevayler.PrevaylerFactory;
import pl.edu.agh.kis.kruchy.prevayler.model.User;
import pl.edu.agh.kis.kruchy.prevayler.repository.transaction.CreateUserTransaction;
import pl.edu.agh.kis.kruchy.prevayler.repository.transaction.GetUsersBySurnameTransaction;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class PrevaylerUserRepository implements UserRepository {

    Prevayler<Root> prevayler;

    public PrevaylerUserRepository() throws Exception {
        prevayler = PrevaylerFactory.createPrevayler(new Root());
    }

    PrevaylerUserRepository(Prevayler<Root> prevayler) throws Exception {
        this.prevayler = prevayler;
    }

    @Override
    public List<User> findAllByName(String name) {
        return null;
    }

    @Override
    public List<User> findAllBySurname(String surname) {
        try {
            return prevayler.execute(new GetUsersBySurnameTransaction(surname));
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    @Override
    public Optional<User> findByPhoneNumber(String phoneNumber) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(String id) {
        return null;
    }

    @Override
    public <T extends User> T save(T user) {
        try {
            User execute = prevayler.execute(new CreateUserTransaction(user, user.getId()));
            return (T) execute;
        } catch (Exception e) {
            return null;
        }
    }
}
