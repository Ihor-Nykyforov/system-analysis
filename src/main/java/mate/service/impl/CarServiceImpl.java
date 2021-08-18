package mate.service.impl;

import java.util.List;
import java.util.Optional;
import mate.dao.CarDao;
import mate.dao.impl.CarDaoImpl;
import mate.model.Car;
import mate.service.CarService;

public class CarServiceImpl implements CarService {
    CarDao carDao = new CarDaoImpl();

    @Override
    public Car addCar(Car car) {
        return carDao.addCar(car);
    }

    @Override
    public Car getCar(Long id) {
        return carDao.getCar(id);
    }

    @Override
    public List<Car> getAllCars() {
        return carDao.getAllCars();
    }

    @Override
    public Optional<Car> getCarByBrandModelYear(String brand, String model, int year) {
        return carDao.getCarByBrandModelYear(brand, model, year);
    }
}
