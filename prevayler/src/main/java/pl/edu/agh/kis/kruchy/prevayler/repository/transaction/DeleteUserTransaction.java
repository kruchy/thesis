package pl.edu.agh.kis.kruchy.prevayler.repository.transaction;

import org.prevayler.TransactionWithQuery;
import pl.edu.agh.kis.kruchy.prevayler.model.User;
import pl.edu.agh.kis.kruchy.prevayler.repository.Root;

import java.util.Date;

public class DeleteUserTransaction implements TransactionWithQuery<Root, User> {
    @Override
    public User executeAndQuery(Root root, Date date) throws Exception {
        return null;
    }
}
