package pizzeria.services;

import pizzeria.configuration.RepositoryConfig;
import pizzeria.domain.entity.Customer;
import pizzeria.domain.repository.CustomerRepository;

public class CustomerService {
    private CustomerRepository customerRepository = RepositoryConfig.getInstance().getCustomerRepository();
    public void listCustomers(){
        Customer[] customers = customerRepository.getCustomers();
        for(Customer customer : customers){
            System.out.println(customer.getName());
        }
    }
}
