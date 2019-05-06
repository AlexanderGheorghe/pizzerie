package pizzeria.services;

import pizzeria.configuration.RepositoryConfig;
import pizzeria.domain.entity.Customer;
import pizzeria.domain.entity.Reservation;
import pizzeria.domain.repository.CustomerRepository;
import pizzeria.domain.repository.ReservationRepository;

import java.util.List;
import java.util.TreeMap;

public class CustomerService {
    private CustomerRepository customerRepository = RepositoryConfig.getInstance().getCustomerRepository();
    private ReservationRepository reservationRepository = RepositoryConfig.getInstance().getReservationRepository();
    public int getNumberOfReservationsOfCustomer(int customerId) {
        TreeMap<Integer, List<Reservation>> reservations = reservationRepository.getReservations();
        AuditService.audit("get number of reservations of customer " + customerId);
        return reservations.get(customerId).size();
    }

    public String[] searchCustomer(String partialName) {
        List<Customer> customers = customerRepository.getCustomers();
        String[] result = new String[customers.size()];
        int counter = 0;
        String pattern = createPattern(partialName);
        System.out.println(pattern);

        for (Customer customer : customers) {
            if (customer != null && customer.getName().matches(pattern)) {
                result[counter++] = customer.getName();
            }
        }
        AuditService.audit("search customer " + partialName);
        return result;
    }

    private String createPattern(String partialUserName) { // example JDo, JoD, JoDo -> for John Doe
        String[] splitPartialName = partialUserName.split("(?=[A-Z])"); //Split partial user name: {J, Do} {Jo D}
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < splitPartialName.length; i++) {
            resultBuilder.append(splitPartialName[i]);
            resultBuilder.append("[a-z]*"); //append any number of lower case characters

            resultBuilder.append("[[A-z]{1}[a-z]+\\s]*"); //any number of other names
            if (!(i == splitPartialName.length - 1)) { //if it's not the last part
                resultBuilder.append("\\s"); //append one space
            }
        }
        return resultBuilder.toString();
    }

    private void printCustomers(List<Customer> customers) {
        for (Customer customer : customers) {
            if (customer == null) {
                System.out.println("--------------------------");
                break;
            }
            System.out.println(customer.getId() + ": " + customer.getName());
        }
    }

    public void listCustomers() {
        AuditService.audit("list customers");
        printCustomers(customerRepository.getCustomers());
    }
}
