package ua.shad.yatsurapizzaservicehw2.repository;

import java.util.List;
import ua.shad.yatsurapizzaservicehw2.domain.Pizza;

/**
 *
 * @author andrii
 */
public interface PizzaRepository {
    
    void addPizza(Pizza pizza);
    
    Pizza getPizzaById(Integer id);
    
    List<Pizza> getPizzasByType(Pizza.PizzaType type);
    
    List<Pizza> getPizzas();
    
    void updatePizza(Pizza pizza);
    
    void deletePizza(Integer id);
}
