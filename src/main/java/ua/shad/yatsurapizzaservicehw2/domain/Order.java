package ua.shad.yatsurapizzaservicehw2.domain;

import java.util.Date;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Maksym Yatsura
 */
@Component
@Scope(scopeName = "prototype")
public class Order {

    private static int count;

    private Integer id;
    private Customer customer;
    private Date date;
    private String name;
    private List<Pizza> pizzas;

    public Order() {
        id = ++count;
    }

    public Order(Customer customer, Date date, List<Pizza> pizzas) {
        this();
        this.customer = customer;
        this.date = date;
        this.pizzas = pizzas;
        name = date.toString() + "_" + id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotalPrice() {
        return pizzas.stream().mapToDouble(Pizza::getPrice).sum();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Order { " + "id: " + id + ", pizzas: " + pizzas + '}';
    }

}
