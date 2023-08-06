package hiber.service;

import hiber.model.User;

import javax.transaction.Transactional;
import java.util.List;

public interface UserService {
    void add(User user);

    List<User> getUsers();

    User getUserByCar(String bmw, int i);
}
