package pizzeria.domain.repository;

import pizzeria.domain.entity.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> getCustomers();
}
