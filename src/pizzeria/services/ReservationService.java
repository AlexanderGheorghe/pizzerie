package pizzeria.services;

import pizzeria.configuration.RepositoryConfig;
import pizzeria.domain.entity.Customer;
import pizzeria.domain.entity.Reservation;
import pizzeria.domain.entity.Table;
import pizzeria.domain.repository.CustomerRepository;
import pizzeria.domain.repository.ReservationRepository;
import pizzeria.domain.repository.TableRepository;

import java.util.Date;

public class ReservationService {
    private ReservationRepository reservationRepository = RepositoryConfig.getInstance().getReservationRepository();
    private CustomerRepository customerRepository = RepositoryConfig.getInstance().getCustomerRepository();
    private TableRepository tableRepository = RepositoryConfig.getInstance().getTableRepository();
    public void addReservation(int customerId, String tableName, Date date){
        Table table = null;
        Table[] tables = tableRepository.getTables();
        for(Table t : tables){
            if(t.getName().equals(tableName)){
                table = t;
                break;
            }
        }
        reservationRepository.addReservation(customerRepository.getCustomers()[customerId], table, date);
    }
    public void listReservations(){
        Reservation[] reservations = reservationRepository.getReservations();
        for(int i=0; i<reservationRepository.getNumberOfReservations(); i++){
            System.out.println(reservations[i].getCustomer().getName()+ " " +reservations[i].getTable().getName() + " " + reservations[i].getDate().toString());
        }
    }
}
