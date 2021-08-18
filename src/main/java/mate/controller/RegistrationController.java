package mate.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import mate.lib.exception.AuthenticationException;
import mate.model.User;
import mate.service.UserService;
import mate.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = "/registration")
public class RegistrationController extends HttpServlet {
    UserService userService = new UserServiceImpl();
    private static final String USER_ID = "user_id";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String login = req.getParameter("login");
//        String password = req.getParameter("password");
//        String phone = req.getParameter("phone");
//        User user = new User();
//        user.setLogin(login);
//        user.setPassword(password);
//        user.setPhone(phone);
//        userService.addUser(user);

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");

        try {
            if (userService.findByLogin(login).isPresent()) {
                throw new Exception("Current username already exists");
            }
            User user = new User();
            user.setLogin(login);
            user.setPassword(password);
            user.setPhone(phone);
            userService.addUser(user);
            HttpSession session = req.getSession();
            session.setAttribute(USER_ID, user.getId());
            resp.sendRedirect("/index");
        } catch (Exception e) {
            req.setAttribute("errorMessage", e.getMessage());
            req.getRequestDispatcher("/WEB-INF/views/registration.jsp").forward(req, resp);
        }

    }
}
