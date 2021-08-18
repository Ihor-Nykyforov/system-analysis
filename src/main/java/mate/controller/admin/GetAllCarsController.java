package mate.controller.admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import mate.model.Car;
import mate.model.User;
import mate.service.CarService;
import mate.service.UserService;
import mate.service.impl.CarServiceImpl;
import mate.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = "/cars")
public class GetAllCarsController extends HttpServlet {
    private static final String USER_ID = "user_id";

    CarService carService = new CarServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Long userId = (Long) session.getAttribute(USER_ID);
        UserService service = new UserServiceImpl();
        String login = service.getUser(userId).get().getLogin();
        req.setAttribute("login", login);
        List<Car> cars = carService.getAllCars();
        req.setAttribute("cars", cars);
        req.getRequestDispatcher("/WEB-INF/views/cars.jsp").forward(req, resp);
    }
}
