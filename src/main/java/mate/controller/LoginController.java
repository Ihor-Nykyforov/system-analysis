package mate.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import mate.lib.exception.AuthenticationException;
import mate.model.User;
import mate.service.AuthenticationService;
import mate.service.impl.AuthenticationServiceImpl;

public class LoginController extends HttpServlet {
    AuthenticationService authenticationService = new AuthenticationServiceImpl();
    private static final String USER_ID = "user_id";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        try {
            User user = authenticationService.login(login, password);
            HttpSession session = req.getSession();
            session.setAttribute(USER_ID, user.getId());
            if (user.getLogin().equals("Admin")){
                resp.sendRedirect("/index");
            } else resp.sendRedirect("/index-user");
        } catch (AuthenticationException e) {
            req.setAttribute("errorMessage", e.getMessage());
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
        }
    }
}
