package pizzeria.domain.repository;

import pizzeria.domain.entity.Customer;
import pizzeria.tool.TestData;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    private List<Customer> customers;

    public CustomerRepositoryImpl() {
//        String[] data = TestData.getInstance().getCustomerData();
        customers = new ArrayList<>();
//        for (int i = 0; i < data.length; i++) {
//            String[] splitData = data[i].split(",");
//            customers.add(new Customer(i, splitData[0] + " " + splitData[1]));
//        }
    }

    @Override
    public List<Customer> getCustomers() {
        return customers;
    }
}
