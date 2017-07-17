package pl.edu.agh.kis.kruchy.prevayler.repository;

import org.prevayler.TransactionWithQuery;
import pl.edu.agh.kis.kruchy.prevayler.model.User;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DeleteAllTransaction implements TransactionWithQuery<Root, List<User>>, Serializable {
    @Override
    public List<User> executeAndQuery(Root root, Date date) throws Exception {
        List<User> deleted = root.getUsers().entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
        root.getUsers().clear();
        return deleted;
    }
}
