package mate.controller.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import mate.model.Car;
import mate.model.Order;
import mate.model.User;
import mate.service.CarService;
import mate.service.OrderService;
import mate.service.UserService;
import mate.service.impl.CarServiceImpl;
import mate.service.impl.OrderServiceImpl;
import mate.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = "/add-order")
public class CreateOrderController extends HttpServlet {
    private static final String USER_ID = "user_id";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        Long userId = (Long) session.getAttribute(USER_ID);
        UserService service = new UserServiceImpl();
        String login = service.getUser(userId).get().getLogin();
        req.setAttribute("login", login);
        req.getRequestDispatcher("/WEB-INF/views/add-user-order.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        Car car = new Car();
        String brand = req.getParameter("brand");
        String model = req.getParameter("model");
        int year = Integer.parseInt(req.getParameter("year"));
        CarService carService = new CarServiceImpl();

        if (carService.getCarByBrandModelYear(brand, model, year).isPresent()) {
            car = carService.getCarByBrandModelYear(brand, model, year).get();
        } else {
            car.setBrand(brand);
            car.setModel(model);
            car.setYear(year);
            car = carService.addCar(car);
        }

        HttpSession session = req.getSession();
        Long userId = (Long) session.getAttribute(USER_ID);
        UserService service = new UserServiceImpl();
        User user = service.getUser(userId).get();
        Order order = new Order();
        order.setCar(car);
        order.setUser(user);
        OrderService orderService = new OrderServiceImpl();
        orderService.addOrder(order);
        if (user.getLogin().equals("Admin")) {
            resp.sendRedirect("/index");
        } else resp.sendRedirect("/index-user");
    }
}
