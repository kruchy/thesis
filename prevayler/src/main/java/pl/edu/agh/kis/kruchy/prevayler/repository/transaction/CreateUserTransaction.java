package pl.edu.agh.kis.kruchy.prevayler.repository.transaction;

import org.prevayler.TransactionWithQuery;
import pl.edu.agh.kis.kruchy.prevayler.model.User;
import pl.edu.agh.kis.kruchy.prevayler.repository.Root;

import java.io.Serializable;
import java.util.Date;

public class CreateUserTransaction implements TransactionWithQuery<Root, User>, Serializable {
    private static final long serialVersionUID = 1L;

    private User user;
    private String UId;

    public CreateUserTransaction(User user, String UId) {
        this.user = user;
        this.UId = UId;
    }

    @Override
    public User executeAndQuery(Root root, Date date) throws Exception {
        user.setId(UId);
        root.getUsers().put(user.getId(), user);
        return user;
    }
}
