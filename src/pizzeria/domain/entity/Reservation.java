package pizzeria.domain.entity;

import java.util.Date;

public class Reservation {
    private Customer customer;
    private Table table;
    private Date date;

    public Reservation(Customer customer, Table table, Date date) {
        this.customer = customer;
        this.table = table;
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
