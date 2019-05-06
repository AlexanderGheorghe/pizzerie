package pizzeria.domain.repository;

import pizzeria.domain.entity.Pizza;
import pizzeria.tool.TestData;

import java.util.ArrayList;
import java.util.List;

public class PizzaRepositoryImpl implements PizzaRepository {
    private List<Pizza> pizzas;

    public PizzaRepositoryImpl() {
//        String[] data = TestData.getInstance().getPizzaData();
//        numberOfPizzas = data.length;
        pizzas = new ArrayList<>();
//        for (int i = 0; i < numberOfPizzas; i++) {
//            pizzas.add(new Pizza(data[i]));
//        }
    }

    @Override
    public List<Pizza> getPizzas() {
        return pizzas;
    }

}
