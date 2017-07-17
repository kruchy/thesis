package pl.edu.agh.kis.kruchy.prevayler.repository.transaction;

import org.prevayler.TransactionWithQuery;
import pl.edu.agh.kis.kruchy.prevayler.model.User;
import pl.edu.agh.kis.kruchy.prevayler.repository.Root;

import java.io.Serializable;
import java.util.Date;

public class DeleteUserTransaction implements TransactionWithQuery<Root, User>, Serializable {
    private String id;

    public DeleteUserTransaction(String id) {

        this.id = id;
    }

    @Override
    public User executeAndQuery(Root root, Date date) throws Exception {
        return root.getUsers().remove(id);
    }
}
