package homework017;

import java.util.List;

public interface CarRepository {
    List<Car> findAll();
    void save(Car car);
    Car findByBrandAndModel(String brand, String model);
}