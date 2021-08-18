package mate.service;

import java.util.List;
import java.util.Optional;
import mate.model.Car;
import mate.model.User;

public interface UserService {
    User addUser(User user);

    Optional<User> getUser(Long id);

    List<User> getAllUsers();

    Optional<User> findByLogin(String login);

}
