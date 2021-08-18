package mate.dao;

import java.util.List;
import mate.model.Order;

public interface OrderDao {
    Order addOrder(Order order);

    Order gerOrder(Long id);

    List<Order> getAllOrders();
}
