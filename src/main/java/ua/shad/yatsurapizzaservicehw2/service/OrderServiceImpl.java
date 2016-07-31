package ua.shad.yatsurapizzaservicehw2.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;
import ua.shad.yatsurapizzaservicehw2.domain.Customer;
import ua.shad.yatsurapizzaservicehw2.domain.Order;
import ua.shad.yatsurapizzaservicehw2.domain.Pizza;
import ua.shad.yatsurapizzaservicehw2.repository.OrderRepository;
import ua.shad.yatsurapizzaservicehw2.repository.PizzaRepository;

/**
 *
 * @author andrii
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    
    private PizzaRepository pizzaRepository;
    private OrderRepository orderRepository;

    public OrderServiceImpl() {        
    }
    
    @Autowired
    public OrderServiceImpl(PizzaRepository pizzaRepozitory
            , OrderRepository orderRepository) {
        this.pizzaRepository = pizzaRepozitory;
        this.orderRepository = orderRepository;
    }    

        public PizzaRepository getPizzaRepozitory() {
        return pizzaRepository;
    }

    public void setPizzaRepozitory(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public OrderRepository getOrderRepository() {
        return orderRepository;
    }

    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }    
    
    @Override
    public List<Order> getAllOrders() {
        return orderRepository.getOrders();
    }

    @Override
    public Order placeNewOrder(Customer customer, Integer... pizzasID) {
        List<Pizza> pizzas = pizzasListFromArrayOfIds(pizzasID);
        Order newOrder = getNewOrder();
        newOrder.setCustomer(customer);
        newOrder.setPizzas(pizzas);
       
        orderRepository.saveOrder(newOrder);  // set Order Id and save Order to in-memory list
        return newOrder;
    }
    
    @Lookup
    protected Order getNewOrder() {
        return null;
    }

    @Override
    public Order addPizzaToOrder(Order order, Integer pizzaId) {
        List<Pizza> pizzas = order.getPizzas();
        pizzas.add(pizzaRepository.getPizzaById(pizzaId));
        order.setPizzas(pizzas);
        return order;
    }

    @Override
    public Order removePizzaFromOrder(Order order, Integer pizzaId) {
        List<Pizza> pizzas = order.getPizzas();
        pizzas.remove(pizzaRepository.getPizzaById(pizzaId));
        order.setPizzas(pizzas);
        return order;
    }
    
    private List<Pizza> pizzasListFromArrayOfIds(Integer[] pizzasID) {
        List<Pizza> pizzas = new ArrayList<>();
        for(Integer id : pizzasID){
            pizzas.add(pizzaRepository.getPizzaById(id));  // get Pizza from predifined in-memory list
        }
        return pizzas;
    }

}
