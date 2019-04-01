package pizzeria.configuration;

import pizzeria.domain.repository.*;

public class RepositoryConfig {
    private final CustomerRepository customerRepository = new CustomerRepositoryImpl();
    private final PizzaRepository pizzaRepository = new PizzaRepositoryImpl();
    private final ReservationRepository reservationRepository = new ReservationRepositoryImpl();
    private static RepositoryConfig instance = new RepositoryConfig();

    public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }

    public PizzaRepository getPizzaRepository() {
        return pizzaRepository;
    }

    public ReservationRepository getReservationRepository() {
        return reservationRepository;
    }

    public static RepositoryConfig getInstance() {
        return instance;
    }

    private RepositoryConfig() {
    }
}
