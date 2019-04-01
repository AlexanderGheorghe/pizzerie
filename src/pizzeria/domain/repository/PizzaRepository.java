package pizzeria.domain.repository;

import pizzeria.domain.entity.Pizza;

public interface PizzaRepository {
    Pizza[] getPizzas();
    int getNumberOfPizzas();
}
