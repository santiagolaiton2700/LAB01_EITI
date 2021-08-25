package ieti.eci.lab01.lab01.service.impl;

import ieti.eci.lab01.lab01.datos.User;
import ieti.eci.lab01.lab01.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceHashMap implements UserService {
    private HashMap<String,User> users= new HashMap<String,User>();
    @Override
    public User create(User user) {
        users.put(user.getId(),user);
        return user;
    }

    @Override
    public User findById(String id) {
        return users.get(id);
    }

    @Override
    public List<User> all() {
        List<User> userList = new ArrayList<>();
        for(String id: users.keySet()){
            userList.add(users.get(id));
        }
        return userList;
    }

    @Override
    public void deleteById(String id) {
        users.remove(id);
    }

    @Override
    public User update(User user, String userId) {
        users.put(userId,user);
        return user;
    }
}
