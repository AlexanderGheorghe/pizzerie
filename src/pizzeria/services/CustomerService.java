package pizzeria.services;

import pizzeria.configuration.RepositoryConfig;
import pizzeria.domain.entity.Customer;
import pizzeria.domain.entity.Reservation;
import pizzeria.domain.repository.CustomerRepository;
import pizzeria.domain.repository.ReservationRepository;

public class CustomerService {
    private CustomerRepository customerRepository = RepositoryConfig.getInstance().getCustomerRepository();
    private ReservationRepository reservationRepository = RepositoryConfig.getInstance().getReservationRepository();
    public int getNumberOfReservationsOfCustomer(int customerId) {
        int counter = 0;
        Reservation[] reservations = reservationRepository.getReservations();
        for (Reservation reservation : reservations) {
            if (reservation != null && reservation.getCustomer().getId() == customerId) {
                counter++;
            }
        }
        return counter;
    }

    public String[] searchCustomer(String partialName) {
        Customer[] customers = customerRepository.getCustomers();
        String[] result = new String[customers.length];
        int counter = 0;
        String pattern = createPattern(partialName);
        System.out.println(pattern);

        for (Customer customer : customers) {
            if (customer != null && customer.getName().matches(pattern)) {
                result[counter++] = customer.getName();
            }
        }
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

    private void printCustomers(Customer[] customers) {
        for (Customer customer : customers) {
            if (customer == null) {
                System.out.println("--------------------------");
                break;
            }
            System.out.println(customer.getId() + ": " + customer.getName());
        }
    }

    public void listCustomers() {
        printCustomers(customerRepository.getCustomers());
    }
}
