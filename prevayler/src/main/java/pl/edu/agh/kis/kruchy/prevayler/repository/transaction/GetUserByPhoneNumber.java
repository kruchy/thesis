package pl.edu.agh.kis.kruchy.prevayler.repository.transaction;

import org.prevayler.Query;
import pl.edu.agh.kis.kruchy.prevayler.model.User;
import pl.edu.agh.kis.kruchy.prevayler.repository.Root;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

public class GetUserByPhoneNumber implements Query<Root, Optional<User>>, Serializable {
    private String phoneNumber;

    public GetUserByPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public Optional<User> query(Root root, Date date) throws Exception {
        return root.getUsers().entrySet()
                .stream()
                .filter(stringUserEntry -> stringUserEntry.getValue().getPhoneNumber().equals(phoneNumber))
                .map(Map.Entry::getValue)
                .findFirst();
    }
}
