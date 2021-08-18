package mate;

import java.util.List;
import mate.dao.CarDao;
import mate.dao.OrderDao;
import mate.dao.UserDao;
import mate.dao.impl.CarDaoImpl;
import mate.dao.impl.OrderDaoImpl;
import mate.dao.impl.UserDaoImpl;
import mate.model.Car;
import mate.model.Order;
import mate.model.User;

public class main {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        User user = new User();
        user.setLogin("Admin");
        user.setPassword("1234");
        System.out.println(userDao.addUser(user));

        CarDao carDao = new CarDaoImpl();
        Car car = new Car();
        car.setBrand("Mercedes");
        car.setModel("E63");
        car.setYear(2020);
        System.out.println(carDao.addCar(car));

        OrderDao orderDao = new OrderDaoImpl();
        Order order = new Order();
        order.setUser(user);
        order.setCar(car);
        System.out.println(orderDao.addOrder(order));
    }
}
