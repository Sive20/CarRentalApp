package za.ac.cput.domain;

public class Customer {
    private String customerId;
    private String name;
    private String address;
    private String driverLicenseNumber;


    private Customer(Builder builder) {
        this.customerId = builder.customerId;
        this.name = builder.name;
        this.address = builder.address;
        this.driverLicenseNumber = builder.driverLicenseNumber;
    }


    // Getters
    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", driverLicenseNumber='" + driverLicenseNumber + '\'' +
                '}';
    }
    public static class Builder {
        private String customerId;
        private String name;
        private String address;
        private String driverLicenseNumber;

        public Builder setCustomerId(String customerId) {
            this.customerId = customerId;
            return this;
        }
        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setDriverLicenseNumber(String driverLicenseNumber) {
            this.driverLicenseNumber = driverLicenseNumber;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }





}
