package za.ac.cput.factory;

import za.ac.cput.domain.Car;

public class CarFactory {
    public static Car createCar(String carId, String model, double price, String branchId) {
        return new Car.Builder()
                .carId(carId)
                .model(model)
                .pricePerDay(price)
                .branchId(branchId)
                .build();
    }

}
