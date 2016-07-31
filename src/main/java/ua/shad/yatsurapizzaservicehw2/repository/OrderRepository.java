package ua.shad.yatsurapizzaservicehw2.repository;

import java.util.List;
import ua.shad.yatsurapizzaservicehw2.domain.Order;

/**
 *
 * @author Maksym Yatsura
 */
public interface OrderRepository {
    
    Integer saveOrder(Order pizza);
    
    Order getOrderById(Integer id);
    
    public List<Order> getOrders();
    
    void updateOrder(Order order);
    
    void deleteOrder(Integer id);
}
