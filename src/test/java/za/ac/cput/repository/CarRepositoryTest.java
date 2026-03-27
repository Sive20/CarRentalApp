package za.ac.cput.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Car;
import java.util.*;
import za.ac.cput.factory.CarFactory;

import static org.junit.jupiter.api.Assertions.*;

class CarRepositoryTest {


    private CarRepository repository;
    private Car car;

    @BeforeEach
    void setUp() {
        repository = new CarRepository();
        car = new Car.Builder()
                .carId("C001")
                .model("Toyota Corolla")
                .pricePerDay(500.0)
                .branchId("B001")
                .build();
        repository.save(car);
    }

    @Test
    void saveCar() {
        Car newCar = new Car.Builder()
                .carId("CA MDALI")
                .model("Toyota Corolla")
                .pricePerDay(550.0)
                .branchId("24D89")
                .build();
        repository.save(newCar);
        assertEquals(2, repository.getAll().size());
    }

    @Test
    void findCarById() {
        Car found = repository.findById("CA MDALI");
        assertNotNull(found);
        assertEquals("CA MDALI", found.getCarId());
    }

    @Test
    void getAllCars() {
        Collection<Car> allCars = repository.getAll();
        assertEquals(1, allCars.size());
    }

    @Test
    void deleteCar() {
        repository.delete("CA MDALI");
        assertNull(repository.findById("CA MDALI"));
        assertEquals(0, repository.getAll().size());
    }

}