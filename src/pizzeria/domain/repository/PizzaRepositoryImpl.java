package pizzeria.domain.repository;

import pizzeria.domain.entity.Pizza;
import pizzeria.tool.TestData;

public class PizzaRepositoryImpl implements PizzaRepository {
    private Pizza[] pizzas;
    private int numberOfPizzas;

    public PizzaRepositoryImpl() {
        String[] data = TestData.getInstance().getPizzaData();
        numberOfPizzas = data.length;
        pizzas = new Pizza[numberOfPizzas];
        for (int i = 0; i < numberOfPizzas; i++) {
            pizzas[i] = new Pizza(data[i]);
        }
    }

    @Override
    public Pizza[] getPizzas() {
        return pizzas;
    }

    public int getNumberOfPizzas() {
        return numberOfPizzas;
    }
}
