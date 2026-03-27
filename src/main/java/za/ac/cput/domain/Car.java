package za.ac.cput.domain;

public class Car {
    private final String carId;
    private final String model;
    private final double pricePerDay;
    private final String branchId;

    // Private constructor
    private Car(Builder builder) {
        this.carId = builder.carId;
        this.model = builder.model;
        this.pricePerDay = builder.pricePerDay;
        this.branchId = builder.branchId;
    }

    // Getters
    public String getCarId() {
        return carId;
    }

    public String getModel() {
        return model;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public String getBranchId() {
        return branchId;
    }

    // Static builder method
    public static Builder builder() {
        return new Builder();
    }

    // Builder class
    public static class Builder {
        private String carId;
        private String model;
        private double pricePerDay;
        private String branchId;

        public Builder carId(String carId) {
            this.carId = carId;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder pricePerDay(double pricePerDay) {
            this.pricePerDay = pricePerDay;
            return this;
        }

        public Builder branchId(String branchId) {
            this.branchId = branchId;
            return this;
        }

        public Builder copy(Car car) {
            this.carId = car.carId;
            this.model = car.model;
            this.pricePerDay = car.pricePerDay;
            this.branchId = car.branchId;
            return this;
        }

        public Car build() {
            if (carId == null || carId.isEmpty()) {
                throw new IllegalStateException("Car ID cannot be null");
            }
            return new Car(this);
        }
    }
}
