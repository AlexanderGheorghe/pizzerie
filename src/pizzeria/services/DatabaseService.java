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

import java.io.*;
import java.sql.*;
import java.util.*;

public class DatabaseService {
    private Connection cnx;
    private Statement statement;
    private static DatabaseService ourInstance = new DatabaseService();

    public static DatabaseService getInstance() {
        return ourInstance;
    }

    private DatabaseService() {
        String url = "jdbc:mysql://db4free.net:3306/apizzeriadb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
        String user = "pizzadb";
        String password = "12345678";

        try {
            cnx = DriverManager.getConnection(url, user, password);
            statement = cnx.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static private ReservationRepository reservationRepository = RepositoryConfig.getInstance().getReservationRepository();
    static private CustomerRepository customerRepository = RepositoryConfig.getInstance().getCustomerRepository();
    static private TableRepository tableRepository = RepositoryConfig.getInstance().getTableRepository();
    static private PizzaRepository pizzaRepository= RepositoryConfig.getInstance().getPizzaRepository();

    public void createReservations(){
        try {
            statement.execute("create table reservations (id number(2), masa varchar2(200), data date)");
            statement.execute("insert into reservations values(1, 'Table 1', '2019.03.01')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void create(){
        try {
            statement.execute("create table reservations (id number(2), masa varchar2(200), data date)");
            statement.execute("insert into reservations values(1, 'Table 1', '2019.03.01')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
