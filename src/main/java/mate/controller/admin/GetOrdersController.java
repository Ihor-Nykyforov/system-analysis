package mate.controller.admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import mate.lib.Injector;
import mate.model.Order;
import mate.service.OrderService;
import mate.service.UserService;
import mate.service.impl.OrderServiceImpl;
import mate.service.impl.UserServiceImpl;

@WebServlet("/orders")
public class GetOrdersController extends HttpServlet {
    private static final String USER_ID = "user_id";

    OrderService orderService = new OrderServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Long userId = (Long) session.getAttribute(USER_ID);
        UserService service = new UserServiceImpl();
        String login = service.getUser(userId).get().getLogin();
        req.setAttribute("login", login);
        List<Order> orders = orderService.getAllOrders();
        req.setAttribute("orders", orders);
        req.getRequestDispatcher("/WEB-INF/views/orders.jsp").forward(req, resp);
    }
}
