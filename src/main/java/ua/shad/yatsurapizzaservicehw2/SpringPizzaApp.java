package ua.shad.yatsurapizzaservicehw2;

import java.util.List;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.shad.yatsurapizzaservicehw2.domain.Customer;
import ua.shad.yatsurapizzaservicehw2.domain.Order;
import ua.shad.yatsurapizzaservicehw2.domain.Pizza;
import ua.shad.yatsurapizzaservicehw2.service.OrderService;
import ua.shad.yatsurapizzaservicehw2.service.PizzaService;

/**
 *
 * @author Maksym Yatsura
 */
public class SpringPizzaApp {
    
    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext repositoryContext = new ClassPathXmlApplicationContext("repositoryContext.xml"); // Spring application context for repository beans
        ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext(new String[] {"appContext.xml"}, repositoryContext); // Spring application context for service beans with access to repository beans context

        PizzaService pizzaService = appContext.getBean("pizzaService", PizzaService.class);
        OrderService orderService = appContext.getBean("orderService", OrderService.class);
        //-------------------------------------------
        
        Customer customer = new Customer(1, "John", "Wall street, New-York");
        Order order = orderService.placeNewOrder(customer, 1, 2, 4, 5);

        orderService.addPizzaToOrder(order, 2);
        System.out.println("Price: " + order.getTotalPrice());
        List<Order> orders = orderService.getAllOrders();
        orders.stream().forEach(System.out::println);
        //--------------------------------------------
        
        pizzaService.addPizza(new Pizza(125, "Pizza 125", 105.4, Pizza.PizzaType.SEA));
        pizzaService.updatePizza(new Pizza(2, "Pizza 2", 140.35, Pizza.PizzaType.SEA));
        Order anotherOrder = orderService.placeNewOrder(customer, 2, 125);
        System.out.println("Price: " + anotherOrder.getTotalPrice());
        orders = orderService.getAllOrders();
        orders.stream().forEach(System.out::println);
        

    }
}
