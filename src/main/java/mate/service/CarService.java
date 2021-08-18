package mate.service;

import java.util.List;
import java.util.Optional;
import mate.model.Car;

public interface CarService {
    Car addCar(Car car);

    Car getCar(Long id);

    List<Car> getAllCars();

    Optional<Car> getCarByBrandModelYear(String brand, String model, int year);
}
