package mate.dao;

import java.util.List;
import java.util.Optional;
import mate.model.User;

public interface UserDao {
    User addUser(User user);

    User getUser(Long id);

    List<User> getAllUsers();

    Optional<User> findByLogin(String login);

}
