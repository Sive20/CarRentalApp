package za.ac.cput.repository;

import za.ac.cput.domain.Car;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarRepository {

    // In-memory storage (key = carId)
    private Map<String, Car> carDB;

    // Constructor
    public CarRepository() {
        this.carDB = new HashMap<>();
    }

    // CREATE / SAVE
    public Car save(Car car) {
        if (car == null || car.getCarId() == null) {
            return null;
        }
        carDB.put(car.getCarId(), car);
        return car;
    }

    // READ
    public Car findById(String carId) {
        if (carId == null) {
            return null;
        }
        return carDB.get(carId);
    }

    // READ ALL
    public Collection<Car> getAll() {
        return carDB.values();
    }

    // DELETE
    public boolean delete(String carId) {
        if (carId == null || !carDB.containsKey(carId)) {
            return false;
        }
        carDB.remove(carId);
        return true;
    }
}
