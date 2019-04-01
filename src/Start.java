import pizzeria.services.CustomerService;
import pizzeria.services.PizzaService;
import pizzeria.services.ReservationService;

import java.util.Date;

public class Start {

    public static void main(String[] args) {
        System.out.println("Welcome to Alex's pizzeria!");
        PizzaService pizzaService = new PizzaService();
        CustomerService customerService = new CustomerService();
        ReservationService reservationService = new ReservationService();
        System.out.println(pizzaService.getRandomPizza());
        pizzaService.listPizzas();
        customerService.listCustomers();
        reservationService.addReservation(1, "Table 1", new Date());
        reservationService.listReservations();
        System.out.println(pizzaService.existsByName("Margherita"));
    }

}
