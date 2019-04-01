package pizzeria.domain.repository;

import pizzeria.domain.entity.Pizza;
import pizzeria.tool.TestData;

public class PizzaRepositoryImpl implements PizzaRepository {
    private Pizza[] pizzas;

    public PizzaRepositoryImpl() {
        String[] data = TestData.getInstance().getPizzaData();
        pizzas = new Pizza[data.length];
        for (int i = 0; i < data.length; i++) {
            pizzas[i] = new Pizza(data[i]);
        }
    }

    @Override
    public Pizza[] getPizzas() {
        return pizzas;
    }
}
