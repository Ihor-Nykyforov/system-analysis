package mate.controller.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import mate.service.UserService;
import mate.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = "/index-user")
public class UserIndexController extends HttpServlet {
    private static final String USER_ID = "user_id";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        Long userId = (Long) session.getAttribute(USER_ID);
        UserService service = new UserServiceImpl();
        String login = service.getUser(userId).get().getLogin();
        req.setAttribute("login", login);
        req.getRequestDispatcher("/WEB-INF/views/index-user.jsp").forward(req, resp);
    }
}
