package mate.service;

import java.util.List;
import mate.model.Order;

public interface OrderService {
    Order addOrder(Order order);

    Order gerOrder(Long id);

    List<Order> getAllOrders();

    List<Order> getDoneOrders();
}
