package pizzeria.configuration;

import pizzeria.domain.repository.*;

public class RepositoryConfig {
    private final CustomerRepository customerRepository = new CustomerRepositoryImpl();
    private final PizzaRepository pizzaRepository = new PizzaRepositoryImpl();
    private final ReservationRepository reservationRepository = new ReservationRepositoryImpl();
}
