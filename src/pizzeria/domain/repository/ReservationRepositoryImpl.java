package pizzeria.domain.repository;

import pizzeria.domain.entity.Customer;
import pizzeria.domain.entity.Reservation;
import pizzeria.domain.entity.Table;

import java.util.*;

public class ReservationRepositoryImpl implements ReservationRepository {
    private TreeMap<Integer, List<Reservation>> reservations = new TreeMap<>();
    private int currentIndex = 0;

    @Override
    public void addReservation(Customer customer, Table table, Date date) {
        Integer id = customer.getId();
        if(!reservations.containsKey(id))
            reservations.put(id, new ArrayList<>());
        reservations.get(id).add(new Reservation(customer, table, date));
    }

    @Override
    public int getNumberOfReservations() {
        return currentIndex;
    }

    @Override
    public TreeMap<Integer, List<Reservation>> getReservations() {
        return reservations;
    }
}
