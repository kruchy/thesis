package pl.edu.agh.kis.kruchy.prevayler.repository;

import org.prevayler.Query;
import pl.edu.agh.kis.kruchy.prevayler.model.User;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class GetAllTransaction implements Query<Root, List<User>>, Serializable {
    @Override
    public List<User> query(Root root, Date date) throws Exception {
        return root.getUsers()
                .entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .collect(toList());
    }
}
