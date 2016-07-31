package ua.shad.yatsurapizzaservicehw2.repository;

import java.util.ArrayList;
import java.util.List;
import ua.shad.yatsurapizzaservicehw2.domain.Pizza;
import ua.shad.yatsurapizzaservicehw2.domain.Pizza.PizzaType;

/**
 *
 * @author Maksym Yatsura
 */
public class InMemPizzaRepository implements PizzaRepository {
    
    private List<Pizza> pizzas;

    @Override
    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }
    
    @Override
    public Pizza getPizzaById(Integer id) {
        for(Pizza p: pizzas) {
            if(p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }
    
    @Override
    public List<Pizza> getPizzasByType(PizzaType type) {
        List<Pizza> result = new ArrayList<>();
        for(Pizza p: pizzas) {
            if(p.getType().equals(type)) {
                result.add(p);
            }
        }
        
        return result;
    }    

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }
    
    @Override
    public void updatePizza(Pizza pizza) {
        for(Pizza p: pizzas) {
            if(p.getId().equals(pizza.getId())) {
                p.setName(pizza.getName());
                p.setPrice(pizza.getPrice());
                p.setType(pizza.getType());
                break;
            }
        } 
    }
    
    @Override
    public void deletePizza(Integer id) {
        for(Pizza p: pizzas) {
            if(p.getId().equals(id)) {
                pizzas.remove(p);
                break;
            }
        }
    }
    
    public void init() {
        addPizza(new Pizza(4, "Pizza 4", 211.4, Pizza.PizzaType.MEAT));
        addPizza(new Pizza(5, "Pizza 5", 160.35, Pizza.PizzaType.SEA));
        addPizza(new Pizza(6, "Pizza 6", 79.8, Pizza.PizzaType.VEGAN));
    }
    
}
