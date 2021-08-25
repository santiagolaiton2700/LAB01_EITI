package ieti.eci.lab01.lab01.service.impl;

import ieti.eci.lab01.lab01.datos.User;
import ieti.eci.lab01.lab01.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceHashMap implements UserService {
    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public User findById(UUID id) {
        return null;
    }

    @Override
    public List<User> all() {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public User update(User user, String userId) {
        return null;
    }
}
