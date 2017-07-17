package pl.edu.agh.kis.kruchy.prevayler.repository;

import org.prevayler.Query;
import pl.edu.agh.kis.kruchy.prevayler.model.User;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class GetUsersByNameTransaction implements Query<Root, List<User>>, Serializable {
    private String name;

    public GetUsersByNameTransaction(String name) {

        this.name = name;
    }

    @Override
    public List<User> query(Root root, Date date) throws Exception {
        return root.getUsers()
                .entrySet()
                .stream()
                .filter(stringUserEntry -> stringUserEntry.getValue().getName().equals(name))
                .map(Map.Entry::getValue)
                .collect(toList());
    }
}
