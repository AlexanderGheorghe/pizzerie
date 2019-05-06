package pizzeria.domain.repository;

import pizzeria.domain.entity.Customer;
import pizzeria.domain.entity.Reservation;
import pizzeria.domain.entity.Table;

import java.util.Date;
import java.util.List;
import java.util.TreeMap;

public interface ReservationRepository {
    void addReservation(Customer customer, Table table, Date date);

    int getNumberOfReservations();

    TreeMap<Integer, List<Reservation>> getReservations();
}
