package pl.edu.agh.kis.kruchy.prevayler.repository;

import org.prevayler.Query;
import pl.edu.agh.kis.kruchy.prevayler.model.User;

import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

import static java.util.Optional.of;

public class GetByIdTransaction implements Query<Root, Optional<User>>, Serializable {
    private String id;

    public GetByIdTransaction(String id) {
        this.id = id;
    }

    @Override
    public Optional<User> query(Root root, Date date) throws Exception {
        return of(root.getUsers().get(id));
    }
}
