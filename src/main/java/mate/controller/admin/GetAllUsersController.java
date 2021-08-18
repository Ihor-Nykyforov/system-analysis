package mate.controller.admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import mate.model.User;
import mate.service.UserService;
import mate.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = "/users")
public class GetAllUsersController extends HttpServlet {
    private static final String USER_ID = "user_id";

    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Long userId = (Long) session.getAttribute(USER_ID);
        UserService service = new UserServiceImpl();
        String login = service.getUser(userId).get().getLogin();
        req.setAttribute("login", login);
        List<User> users = userService.getAllUsers();
        req.setAttribute("users", users);
        req.getRequestDispatcher("/WEB-INF/views/users.jsp").forward(req, resp);
    }
}
