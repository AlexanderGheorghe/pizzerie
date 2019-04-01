package pizzeria.domain.repository;

import pizzeria.domain.entity.Customer;

public interface CustomerRepository {
    Customer[] getCustomers();
}
