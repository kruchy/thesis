package pl.edu.agh.kis.kruchy.prevayler.repository;


import org.prevayler.Prevayler;
import org.prevayler.PrevaylerFactory;
import pl.edu.agh.kis.kruchy.common.model.User;
import pl.edu.agh.kis.kruchy.common.repository.UserRepository;
import pl.edu.agh.kis.kruchy.prevayler.repository.transaction.*;

import java.io.IOException;
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
        try {
            return prevayler.execute(new GetUsersByNameTransaction(name));
        } catch (Exception e) {
            return Collections.emptyList();
        }
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
        try {
            return prevayler.execute(new GetUserByPhoneNumber(phoneNumber));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public List<User> findAll() {
        try {
            return prevayler.execute(new GetAllTransaction());
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    @Override
    public Optional<User> findById(String id) {
        try {
            return prevayler.execute(new GetByIdTransaction(id));
        } catch (Exception e) {
            return Optional.empty();
        }
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

    @Override
    public User delete(User user) {
        try {
            prevayler.execute(new DeleteUserTransaction(user.getId()));
            return user;
        } catch (Exception ignored) {
            return null;
        }
    }

    @Override
    public String delete(String id) {
        try {
            prevayler.execute(new DeleteUserTransaction(id));
            return id;
        } catch (Exception ignored) {
            return null;
        }
    }

    @Override
    public Object deleteAll() {
        try {
            prevayler.execute(new DeleteAllTransaction());
        } catch (Exception ignored) {
        }
        return new Object();
    }

    public void close() throws IOException {
        prevayler.close();
    }
}
