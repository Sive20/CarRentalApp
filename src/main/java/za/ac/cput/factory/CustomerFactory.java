package za.ac.cput.factory;

import za.ac.cput.domain.Customer;

public class CustomerFactory {

        public static Customer createCustomer(String customerId, String name, String address,String driverLicenseNumber) {

            return new Customer.Builder()
                    .setCustomerId(customerId)
                    .setName(name)
                    .setAddress(address)
                    .setDriverLicenseNumber(driverLicenseNumber)
                    .build();
        }
    }










