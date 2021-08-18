package mate.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import mate.dao.OrderDao;
import mate.dao.impl.OrderDaoImpl;
import mate.model.Order;
import mate.service.OrderService;

public class OrderServiceImpl implements OrderService {
    OrderDao orderDao = new OrderDaoImpl();
    @Override
    public Order addOrder(Order order) {
        order.setDate(LocalDateTime.now());
        return orderDao.addOrder(order);
    }

    @Override
    public Order gerOrder(Long id) {
        return orderDao.gerOrder(id);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderDao.getAllOrders();
    }

    @Override
    public List<Order> getDoneOrders() {
        return orderDao.getAllOrders().stream()
                .filter(Order::isDone)
                .collect(Collectors.toList());
    }
}
