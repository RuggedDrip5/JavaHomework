package homework011;

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        // Создаем список автомобилей
        List<Car> cars = Arrays.asList(
                new Car("a123me", "Mercedes", "White", 0L, 8_300_000L),
                new Car("b873of", "Volga", "Black", 0L, 673_000L),
                new Car("w487mn", "Lexus", "Grey", 76_000L, 900_000L),
                new Car("p987hj", "Volga", "Red", 610L, 704_340L),
                new Car("c987ss", "Toyota", "White", 254_000L, 761_000L),
                new Car("o983op", "Toyota", "Black", 698_000L, 740_000L),
                new Car("p146op", "BMW", "White", 271_000L, 850_000L),
                new Car("u893ii", "Toyota", "Purple", 210_900L, 440_000L),
                new Car("l097df", "Toyota", "Black", 108_000L, 780_000L),
                new Car("y876wd", "Toyota", "Black", 160_000L, 1_000_000L)
        );

        // Выводим все автомобили
        System.out.println("Автомобили в базе:");
        System.out.println("Number Model    Color  Mileage Cost");
        cars.forEach(System.out::println);

        // 1. Номера автомобилей по цвету или пробегу
        String colorToFind = "Black";
        long mileageToFind = 0L;

        System.out.println("\nНомера автомобилей по цвету или пробегу:");
        String numbers = cars.stream()
                .filter(c -> c.getColor().equals(colorToFind) || c.getMileage() == mileageToFind)
                .map(Car::getNumber)
                .collect(Collectors.joining(" "));
        System.out.println(numbers);

        // 2. Количество уникальных моделей в ценовом диапазоне
        long minPrice = 700_000L;
        long maxPrice = 800_000L;

        long uniqueModelsCount = cars.stream()
                .filter(c -> c.getPrice() >= minPrice && c.getPrice() <= maxPrice)
                .map(Car::getModel)
                .distinct()
                .count();
        System.out.println("\nУникальные автомобили: " + uniqueModelsCount + " шт.");

        // 3. Цвет автомобиля с минимальной стоимостью
        String minPriceColor = cars.stream()
                .min(Comparator.comparingLong(Car::getPrice))
                .map(Car::getColor)
                .orElse("Не найден");
        System.out.println("\nЦвет автомобиля с минимальной стоимостью: " + minPriceColor);

        // 4. Средняя стоимость искомой модели
        String modelToFind1 = "Toyota";
        String modelToFind2 = "Volvo";

        double avgPrice1 = cars.stream()
                .filter(c -> c.getModel().equals(modelToFind1))
                .mapToLong(Car::getPrice)
                .average()
                .orElse(0.0);

        double avgPrice2 = cars.stream()
                .filter(c -> c.getModel().equals(modelToFind2))
                .mapToLong(Car::getPrice)
                .average()
                .orElse(0.0);

        System.out.printf("\nСредняя стоимость модели %s: %.2f%n", modelToFind1, avgPrice1);
        System.out.printf("Средняя стоимость модели %s: %.2f%n", modelToFind2, avgPrice2);
    }
}