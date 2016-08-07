package ua.shad.yatsurapizzaservicehw2.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import ua.shad.yatsurapizzaservicehw2.domain.Order;

/**
 *
 * @author Maksym Yatsura
 */
@Repository
public class InMemOrderRepository implements OrderRepository {

    private List<Order> orders = new ArrayList<>();
    
    @Override
    public Integer saveOrder(Order order) {
        orders.add(order);
        return order.getId();
    }

    @Override
    public Order getOrderById(Integer id) {
        return orders.get(id - 1);
    }

    @Override
    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public void updateOrder(Order order) {
        for(Order o: orders) {
            if(o.getId().equals(order.getId())) {
                o.setCustomer(order.getCustomer());
                o.setDate(order.getDate());
                o.setPizzas(order.getPizzas());
                break;
            }
        } 
    }

    @Override
    public void deleteOrder(Integer id) {
        for(Order o: orders) {
            if(o.getId().equals(id)) {
                orders.remove(o);
                break;
            }
        }    
    }
}
