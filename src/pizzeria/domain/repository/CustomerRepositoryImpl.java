package pizzeria.domain.repository;

import pizzeria.domain.entity.Customer;
import pizzeria.tool.TestData;

public class CustomerRepositoryImpl implements CustomerRepository {
    private Customer[] customers;

    public CustomerRepositoryImpl() {
        String[] data = TestData.getInstance().getCustomerData();
        customers = new Customer[data.length];
        for (int i = 0; i < data.length; i++) {
            String[] splitData = data[i].split(",");
            customers[i] = new Customer(i, splitData[0] + " " + splitData[1]);
        }
    }

    @Override
    public Customer[] getCustomers() {
        return customers;
    }
}
