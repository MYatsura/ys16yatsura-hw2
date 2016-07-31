package ua.shad.yatsurapizzaservicehw2.service;

import java.util.List;
import ua.shad.yatsurapizzaservicehw2.domain.Customer;
import ua.shad.yatsurapizzaservicehw2.domain.Order;

/**
 *
 * @author Maksym Yatsura
 */
public interface OrderService {

    List<Order> getAllOrders();
    
    Order placeNewOrder(Customer customer, Integer... pizzasID);
    
    Order addPizzaToOrder(Order order, Integer pizzaId);
    
    Order removePizzaFromOrder(Order order, Integer pizzaId);
    
}
