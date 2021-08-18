package mate.controller.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import mate.model.Order;
import mate.model.User;
import mate.service.OrderService;
import mate.service.UserService;
import mate.service.impl.OrderServiceImpl;
import mate.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = "/user-order")
public class GerCurrentOrdersController extends HttpServlet {
    private static final String USER_ID = "user_id";

    OrderService orderService = new OrderServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Long userId = (Long) session.getAttribute(USER_ID);
        UserService service = new UserServiceImpl();
        User user = service.getUser(userId).get();
        String login = service.getUser(userId).get().getLogin();
        req.setAttribute("login", login);

        List<Order> orders = orderService.getAllOrders().stream()
                .filter(order -> order.getUser().equals(user))
                .sorted(Comparator.comparing(Order::getDate))
                .collect(Collectors.toList());
        req.setAttribute("orders", orders);
        req.getRequestDispatcher("/WEB-INF/views/order-user.jsp").forward(req, resp);
    }
}
