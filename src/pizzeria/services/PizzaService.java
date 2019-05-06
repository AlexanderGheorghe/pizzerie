package pizzeria.services;

import pizzeria.configuration.RepositoryConfig;
import pizzeria.domain.entity.Pizza;
import pizzeria.domain.repository.PizzaRepository;

import java.util.List;
import java.util.Random;

public class PizzaService {
    private PizzaRepository pizzaRepository= RepositoryConfig.getInstance().getPizzaRepository();
    public String getRandomPizza(){
        Random rand = new Random();
        int x = rand.nextInt(pizzaRepository.getPizzas().size());
        List<Pizza> pizzas = pizzaRepository.getPizzas();
        AuditService.audit("get random pizza");
        return pizzas.get(x).getName();
    }
    public void listPizzas(){
        List<Pizza> pizzas = pizzaRepository.getPizzas();
        for(Pizza pizza : pizzas){
            System.out.println(pizza.getName());
        }
        AuditService.audit("list pizzas");
    }
    public Boolean existsByName(String name){
        AuditService.audit("pizza exists by name");
        List<Pizza> pizzas = pizzaRepository.getPizzas();
        for(Pizza pizza : pizzas){
            if(pizza.getName().equals(name))
                return true;
        }
        return false;
    }
}
