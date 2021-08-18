package mate.service;

import mate.lib.exception.AuthenticationException;
import mate.model.User;

public interface AuthenticationService {
    User login(String login, String password) throws AuthenticationException;
}
