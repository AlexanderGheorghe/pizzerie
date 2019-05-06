package pizzeria.services;

import pizzeria.configuration.RepositoryConfig;
import pizzeria.domain.entity.Reservation;
import pizzeria.domain.entity.Table;
import pizzeria.domain.repository.CustomerRepository;
import pizzeria.domain.repository.ReservationRepository;
import pizzeria.domain.repository.TableRepository;

import java.util.Date;
import java.util.List;
import java.util.TreeMap;

public class ReservationService {
    private ReservationRepository reservationRepository = RepositoryConfig.getInstance().getReservationRepository();
    private CustomerRepository customerRepository = RepositoryConfig.getInstance().getCustomerRepository();
    private TableRepository tableRepository = RepositoryConfig.getInstance().getTableRepository();
    public void addReservation(int customerId, String tableName, Date date){
        reservationRepository.addReservation(customerRepository.getCustomers().get(customerId), tableRepository.getTables().get(tableName), date);
    }
    public void listReservations(){
        TreeMap<Integer, List<Reservation>> reservations = reservationRepository.getReservations();
        for (List<Reservation> l : reservations.values()) {
            for (Reservation reservation : l) {
                System.out.println(reservation.getCustomer().getName() + " " + reservation.getTable().getName() + " " + reservation.getDate().toString());
            }
        }
    }
}
