package za.ac.cput.repository;

import za.ac.cput.domain.Customer;

import java.util.HashSet;
import java.util.Set;

public class CustomerRepository {


        private static CustomerRepository repository = null;
        private Set<Customer> customerDB;

        private CustomerRepository() {
            customerDB = new HashSet<>();
        }

        public static CustomerRepository getRepository() {
            if (repository == null) {
                repository = new CustomerRepository();
            }
            return repository;
        }

        public Customer create(Customer customer) {
            customerDB.add(customer);
            return customer;
        }

        public Customer read(String customerId) {
            for (Customer c : customerDB) {
                if (c.getCustomerId().equals(customerId)) {
                    return c;
                }
            }
            return null;
        }

        public Customer update(Customer customer) {
            Customer oldCustomer = read(customer.getCustomerId());
            if (oldCustomer != null) {
                customerDB.remove(oldCustomer);
                customerDB.add(customer);
                return customer;
            }
            return null;
        }

        public boolean delete(String customerId) {
            Customer customer = read(customerId);
            if (customer != null) {
                customerDB.remove(customer);
                return true;
            }
            return false;
        }

        public Set<Customer> getAll() {
            return customerDB;
        }
    }











