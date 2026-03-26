package za.ac.cput.repository;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CustomerFactory;

import static org.junit.jupiter.api.Assertions.*;

class CustomerRepositoryTest {

    private static CustomerRepository repository = CustomerRepository.getRepository();

    @Test
    void create() {

        Customer customer = CustomerFactory.createCustomer(
                "C001",
                "Avuyile",
                "Cape Town",
                "DL12345"
        );

        Customer created = repository.create(customer);

        assertNotNull(created);
        System.out.println("Created: " + created);
    }

    @Test
    void read() {

        Customer customer = repository.read("C001");

        assertNotNull(customer);
        System.out.println("Read: " + customer);
    }

    @Test
    void update() {

        Customer updatedCustomer = CustomerFactory.createCustomer(
                "C001",
                "Avuyile Updated",
                "Cape Town",
                "DL12345"
        );

        Customer updated = repository.update(updatedCustomer);

        assertNotNull(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    void delete() {

        boolean deleted = repository.delete("C001");

        assertTrue(deleted);
        System.out.println("Deleted successfully");
    }

    @Test
    void getAll() {

        System.out.println("All Customers: " + repository.getAll());
    }
}