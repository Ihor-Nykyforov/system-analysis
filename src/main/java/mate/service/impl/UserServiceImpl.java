package mate.service.impl;

import java.util.List;
import java.util.Optional;
import mate.dao.UserDao;
import mate.dao.impl.UserDaoImpl;
import mate.model.Car;
import mate.model.User;
import mate.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public User addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public Optional<User> getUser(Long id) {
        try {
            return Optional.ofNullable(userDao.getUser(id));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public Optional<User> findByLogin(String login) {
        return userDao.findByLogin(login);
    }

}
