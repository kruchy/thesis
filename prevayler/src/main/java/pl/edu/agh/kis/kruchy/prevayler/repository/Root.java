package pl.edu.agh.kis.kruchy.prevayler.repository;

import pl.edu.agh.kis.kruchy.prevayler.model.User;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Root implements Serializable {
    private static final long serialVersionUID = 1l;

    Map<String, User> users = new HashMap<>();

    public Map<String, User> getUsers() {
        return users;
    }
}
