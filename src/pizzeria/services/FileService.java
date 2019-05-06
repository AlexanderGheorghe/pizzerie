package pizzeria.services;

import pizzeria.configuration.RepositoryConfig;
import pizzeria.domain.entity.Customer;
import pizzeria.domain.entity.Pizza;
import pizzeria.domain.entity.Reservation;
import pizzeria.domain.entity.Table;
import pizzeria.domain.repository.CustomerRepository;
import pizzeria.domain.repository.PizzaRepository;
import pizzeria.domain.repository.ReservationRepository;
import pizzeria.domain.repository.TableRepository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class FileService {
    private ReservationRepository reservationRepository = RepositoryConfig.getInstance().getReservationRepository();
    private CustomerRepository customerRepository = RepositoryConfig.getInstance().getCustomerRepository();
    private TableRepository tableRepository = RepositoryConfig.getInstance().getTableRepository();
    private PizzaRepository pizzaRepository= RepositoryConfig.getInstance().getPizzaRepository();
    private String dataPath;

    public FileService(String dataPath) {
        this.dataPath = dataPath;
    }

    public void readData() {
        try {
            File customerData = new File(dataPath+"customers.csv");
            FileInputStream fileInputStream = new FileInputStream(customerData);
            Scanner scanner = new Scanner(fileInputStream);
            List<Customer> customers = customerRepository.getCustomers();
            int i = 0;
            while (scanner.hasNext()) {
                String data = scanner.nextLine();
                i++;
                String[] splitData = data.split(",");
                customers.add(new Customer(i, splitData[0] + " " + splitData[1]));
            }
        } catch (FileNotFoundException e) {
            System.out.println(dataPath+"customers.csv not found");
        }

        try {
            File tableData = new File(dataPath+"tables.csv");
            FileInputStream fileInputStream = new FileInputStream(tableData);
            Scanner scanner = new Scanner(fileInputStream);
            HashMap<String, Table> tables = tableRepository.getTables();
            int i = 0;
            while (scanner.hasNext()) {
                String data = scanner.nextLine();
                i++;
                tables.put(data, new Table(data));
            }
        } catch (FileNotFoundException e) {
            System.out.println(dataPath+"tables.csv not found");
        }

        try {
            File pizzaData = new File(dataPath+"pizzas.csv");
            FileInputStream fileInputStream = new FileInputStream(pizzaData);
            Scanner scanner = new Scanner(fileInputStream);
            List<Pizza> pizzas = pizzaRepository.getPizzas();
            int i = 0;
            while (scanner.hasNext()) {
                String data = scanner.nextLine();
                i++;
                pizzas.add(new Pizza(data));
            }
        } catch (FileNotFoundException e) {
            System.out.println(dataPath+"pizzas.csv not found");
        }

        try {
            File reservationData = new File(dataPath+"reservations.csv");
            FileInputStream fileInputStream = new FileInputStream(reservationData);
            Scanner scanner = new Scanner(fileInputStream);
            TreeMap<Integer, List<Reservation>> reservations = reservationRepository.getReservations();
            while (scanner.hasNext()) {
                String data = scanner.nextLine();
                String[] splitData = data.split(",");
                Integer id = Integer.parseInt(splitData[0]);
                Customer c = customerRepository.getCustomers().get(id);
                Table t = tableRepository.getTables().get(splitData[1]);
                Date d = new Date(Integer.parseInt(splitData[2]));
                if(!reservations.containsKey(id))
                    reservations.put(id, new ArrayList<>());
                reservations.get(id).add(new Reservation(c, t, d));
            }
        } catch (FileNotFoundException e) {
            System.out.println(dataPath+"reservations.csv not found");
        }
    }
}
