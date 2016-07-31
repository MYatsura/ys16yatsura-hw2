package ua.shad.yatsurapizzaservicehw2.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.shad.yatsurapizzaservicehw2.domain.Pizza;
import ua.shad.yatsurapizzaservicehw2.domain.Pizza.PizzaType;
import ua.shad.yatsurapizzaservicehw2.repository.PizzaRepository;

/**
 *
 * @author Maksym Yatsura
 */
@Service("pizzaService")
public class PizzaServiceImpl implements PizzaService {
    
    @Autowired
    private PizzaRepository pizzaRepository;

    @Override
    public void addPizza(Pizza pizza) {
        pizzaRepository.addPizza(pizza);
    }
    
    @Override
    public void updatePizza(Pizza pizza) {
        pizzaRepository.updatePizza(pizza);
    }
    
    @Override
    public void deletePizza(Integer id) {
        pizzaRepository.deletePizza(id);
    }
    
    @Override
    public List<Pizza> getAllPizzas() {
        return pizzaRepository.getPizzas();
    }
    
    @Override
    public List<Pizza> getPizzasByType(PizzaType type) {
        
        List<Pizza> pizzas = null;
        try {
            pizzas = pizzaRepository.getPizzasByType(type);
        } catch (RuntimeException e) {
            return null;
        }
                
        return pizzas;
    }
    
    @Override
    public Pizza getPizzaById(Integer id) {
        
        Pizza pizza = null;
        try {
            pizza = pizzaRepository.getPizzaById(id);
        } catch (RuntimeException e) {
            return null;
        }
                
        return pizza;
    }

    @Override
    public List<Pizza> getPizzasSortedByPrice() {
        List<Pizza> pizzasSortedByPrice = new ArrayList<>();
        List<Pizza> pizzas = getAllPizzas();
        Collections.copy(pizzasSortedByPrice, pizzas);
        Collections.sort(pizzasSortedByPrice);
        return pizzasSortedByPrice;
    } 
}
