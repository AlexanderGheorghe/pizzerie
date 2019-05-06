import pizzeria.domain.entity.Customer;
import pizzeria.services.*;

import java.util.Date;

public class Start {
    public static void main(String[] args) {
        System.out.println("Welcome to Alex's pizzeria!");
        String dataPath="src/pizzeria/data/";
        FileService.setDataPath(dataPath);
        FileService.readData();
        PizzaService pizzaService = new PizzaService();
        CustomerService customerService = new CustomerService();
        ReservationService reservationService = new ReservationService();
        TableService tableService = new TableService();
        System.out.println(pizzaService.getRandomPizza());
        pizzaService.listPizzas();
        customerService.listCustomers();
        reservationService.addReservation(1, "Table 1", new Date());
        reservationService.listReservations();
        System.out.println(pizzaService.existsByName("Margherita"));
        System.out.println(customerService.getNumberOfReservationsOfCustomer(1));
        String[] matchingCustomers = customerService.searchCustomer("RaD");
        for (String name : matchingCustomers) {
            if (name == null) {
                break;
            }
            System.out.println(name);
        }
        tableService.listTables();
        System.out.println((tableService.getRandomTable()));
    }
}
