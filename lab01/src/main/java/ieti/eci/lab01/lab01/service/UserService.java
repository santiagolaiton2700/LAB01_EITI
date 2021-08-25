package ieti.eci.lab01.lab01.service;

import ieti.eci.lab01.lab01.datos.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    public User create(User user);

    public User findById(UUID id );

    public List<User> all();

    public void deleteById( String id );

    public User update( User user, String userId );
}
