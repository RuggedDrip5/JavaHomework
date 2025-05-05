package homework09;

public class App {
    public static void main(String[] args) {
        CarRepository carRepository = new CarRepositoryFileImpl("src/main/resources/cars.txt");

        // Create some cars
        PerformanceCar performanceCar1 = new PerformanceCar("Ferrari", "488 GTB", 2020, 670, 3, 300, 500);
        PerformanceCar performanceCar2 = new PerformanceCar("Lamborghini", "Huracan", 2021, 640, 3, 320, 550);
        ShowCar showCar1 = new ShowCar("Porsche", "911 Turbo S", 2022, 650, 3, 350, 600);
        ShowCar showCar2 = new ShowCar("McLaren", "720S", 2021, 710, 3, 340, 580);

        // Save cars to repository
        carRepository.save(performanceCar1);
        carRepository.save(performanceCar2);
        carRepository.save(showCar1);
        carRepository.save(showCar2);

        // Rest of the original code...
        // (Create races, garage, etc.)
    }
}