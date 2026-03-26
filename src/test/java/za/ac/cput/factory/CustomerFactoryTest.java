package za.ac.cput.factory;


import za.ac.cput.domain.Customer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerFactoryTest {

    @Test
        public void testCreateCustomer() {
            Customer customer = CustomerFactory.createCustomer(
                    "C001",
                    "Avuyile Twesha",
                    "123 Main Street",
                    "DL123456"
            );

            assertNotNull(customer);
            assertEquals("C001", customer.getCustomerId());
            assertEquals("Avuyile Twesha", customer.getName());
            assertEquals("123 Main Street", customer.getAddress());
            assertEquals("DL123456", customer.getDriverLicenseNumber());
        }
    }























