package homework09;

import homework017.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CarRepositoryTest {
    private static final String TEST_FILE = "src/test/resources/test-cars.txt";
    private CarRepository repository;

    @BeforeEach
    void setUp() throws IOException {
        // Clear test file before each test
        Path path = Paths.get(TEST_FILE);
        if (Files.exists(path)) {
            Files.delete(path);
        }
        Files.createFile(path);

        repository = new CarRepositoryFileImpl(TEST_FILE);
    }

    @Test
    void testSaveAndFindAll() {
        PerformanceCar car = new PerformanceCar("Test", "Model", 2020, 500, 3, 300, 400);
        repository.save(car);

        List<Car> cars = repository.findAll();
        assertEquals(1, cars.size());
        assertEquals("Test", cars.get(0).getBrand());
    }

    @Test
    void testFindByBrandAndModel() {
        repository.save(new PerformanceCar("Test", "Model1", 2020, 500, 3, 300, 400));
        repository.save(new ShowCar("Test", "Model2", 2021, 600, 3, 350, 450));

        Car found = repository.findByBrandAndModel("Test", "Model2");
        assertNotNull(found);
        assertEquals(2021, found.getYear());
    }
}