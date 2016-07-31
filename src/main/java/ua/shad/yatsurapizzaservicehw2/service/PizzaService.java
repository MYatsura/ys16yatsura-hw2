package ua.shad.yatsurapizzaservicehw2.service;

import java.util.List;
import ua.shad.yatsurapizzaservicehw2.domain.Pizza;
import ua.shad.yatsurapizzaservicehw2.domain.Pizza.PizzaType;

/**
 *
 * @author Maksym Yatsura
 */
public interface PizzaService {
    
    void addPizza(Pizza pizza);
    
    void updatePizza(Pizza pizza);
    
    void deletePizza(Integer id);
    
    List<Pizza> getAllPizzas();
    
    List<Pizza> getPizzasByType(PizzaType type);
    
    Pizza getPizzaById(Integer id);
    
    List<Pizza> getPizzasSortedByPrice();
    
}
