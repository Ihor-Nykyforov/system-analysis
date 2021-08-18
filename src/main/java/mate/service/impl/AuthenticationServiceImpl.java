package mate.service.impl;

import java.util.Optional;
import mate.lib.Service;
import mate.lib.exception.AuthenticationException;
import mate.model.User;
import mate.service.AuthenticationService;
import mate.service.UserService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private UserService userService = new UserServiceImpl();

    @Override
    public User login(String login, String password) throws AuthenticationException {
        Optional<User> driverOptional = userService.findByLogin(login);
        if (driverOptional.isPresent() && driverOptional.get().getPassword().equals(password)) {
            return driverOptional.get();
        }
        throw new AuthenticationException("Incorrect login or password");
    }
}
