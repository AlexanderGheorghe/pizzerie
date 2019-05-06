package pizzeria.domain.repository;

import pizzeria.domain.entity.Pizza;

import java.util.List;

public interface PizzaRepository {
    List<Pizza> getPizzas();
}
