package pizzeria.domain.repository;

import pizzeria.domain.entity.Customer;
import pizzeria.domain.entity.Reservation;
import pizzeria.domain.entity.Table;

import java.util.Date;

public class ReservationRepositoryImpl implements ReservationRepository {
    private Reservation[] reservations = new Reservation[50];
    private int currentIndex = 0;

    @Override
    public void addReservation(Customer customer, Table table, Date date) {
        reservations[currentIndex++] = new Reservation(customer, table, date);
    }

    @Override
    public int getNumberOfReservations() {
        return currentIndex;
    }

    @Override
    public Reservation[] getReservations() {
        return reservations;
    }
}
