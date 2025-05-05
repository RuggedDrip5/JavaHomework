package homework017;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRepositoryFileImpl implements CarRepository {
    private final String filePath;

    public CarRepositoryFileImpl(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Car> findAll() {
        try {
            Path path = Paths.get(filePath);
            if (!Files.exists(path)) {
                return new ArrayList<>();
            }
            return Files.lines(path)
                    .map(this::parseCar)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Failed to read cars from file", e);
        }
    }

    @Override
    public void save(Car car) {
        try {
            Path path = Paths.get(filePath);
            String carLine = convertCarToString(car);
            if (Files.exists(path)) {
                Files.write(path, (carLine + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
            } else {
                Files.write(path, carLine.getBytes());
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to save car to file", e);
        }
    }

    @Override
    public Car findByBrandAndModel(String brand, String model) {
        return findAll().stream()
                .filter(c -> c.getBrand().equals(brand) && c.getModel().equals(model))
                .findFirst()
                .orElse(null);
    }

    private Car parseCar(String line) {
        String[] parts = line.split(",");
        String type = parts[0];
        String brand = parts[1];
        String model = parts[2];
        int year = Integer.parseInt(parts[3]);
        int horsepower = Integer.parseInt(parts[4]);
        int acceleration = Integer.parseInt(parts[5]);
        int suspension = Integer.parseInt(parts[6]);
        int durability = Integer.parseInt(parts[7]);

        if ("Performance".equals(type)) {
            return new PerformanceCar(brand, model, year, horsepower, acceleration, suspension, durability);
        } else if ("Show".equals(type)) {
            return new ShowCar(brand, model, year, horsepower, acceleration, suspension, durability);
        }
        throw new IllegalArgumentException("Unknown car type: " + type);
    }

    private String convertCarToString(Car car) {
        String type = car instanceof PerformanceCar ? "Performance" : "Show";
        return String.join(",",
                type,
                car.getBrand(),
                car.getModel(),
                String.valueOf(car.getYear()),
                String.valueOf(car.getHorsepower()),
                String.valueOf(car.getAcceleration()),
                String.valueOf(car.getSuspension()),
                String.valueOf(car.getDurability()));
    }
}