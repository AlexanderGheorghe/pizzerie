package pizzeria.services;

import pizzeria.configuration.RepositoryConfig;
import pizzeria.domain.entity.Pizza;
import pizzeria.domain.repository.PizzaRepository;

import java.util.Random;

public class PizzaService {
    private PizzaRepository pizzaRepository= RepositoryConfig.getInstance().getPizzaRepository();
    public String getRandomPizza(){
        Random rand = new Random();
        int x = rand.nextInt(pizzaRepository.getNumberOfPizzas());
        Pizza[] pizzas = pizzaRepository.getPizzas();
        return pizzas[x].getName();
    }
}
