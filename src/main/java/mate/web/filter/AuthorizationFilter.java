package mate.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import mate.service.UserService;
import mate.service.impl.UserServiceImpl;

@WebFilter("/*")
public class AuthorizationFilter implements Filter {
    private static final String USER_ID = "user_id";
    private final Set<String> allowedAdminUrl = new HashSet<>();
    private final Set<String> allowedUserUrl = new HashSet<>();
    private final Set<String> allowedUrls = new HashSet<>();
    private final UserService userService = new UserServiceImpl();

    @Override
    public void init(FilterConfig filterConfig) {
        allowedAdminUrl.add("/login");
        allowedAdminUrl.add("/registration");
        allowedAdminUrl.add("/index");
        allowedAdminUrl.add("/orders");
        allowedAdminUrl.add("/users");
        allowedAdminUrl.add("/cars");
        allowedAdminUrl.add("/add-order");

        allowedUserUrl.add("/login");
        allowedUserUrl.add("/registration");
        allowedUserUrl.add("/index-user");
        allowedUserUrl.add("/user-order");
        allowedUserUrl.add("/add-order");

        allowedUrls.add("/login");
        allowedUrls.add("/registration");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        Long driverId = (Long) session.getAttribute(USER_ID);
        if (driverId == null && allowedUrls.contains(req.getServletPath())) {
            chain.doFilter(req, resp);
            return;
        }
        if (driverId == null) {
            resp.sendRedirect("/login");
            return;
        }
        if (userService.getUser(driverId).get().getLogin().equals("Admin")
                && allowedAdminUrl.contains(req.getServletPath())) {
            chain.doFilter(req, resp);
            return;
        } else if (userService.getUser(driverId).get().getLogin().equals("Admin")
                && !allowedAdminUrl.contains(req.getServletPath())) {
            resp.sendRedirect("/index");
            return;
        } else if (allowedUserUrl.contains(req.getServletPath())) {
            chain.doFilter(req, resp);
            return;
        } else if (!allowedUserUrl.contains(req.getServletPath())) {
            resp.sendRedirect("/index-user");
            return;
        }
       // chain.doFilter(req, resp);
    }
}
