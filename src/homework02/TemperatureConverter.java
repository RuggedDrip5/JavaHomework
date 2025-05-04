package homework02;

/**
 * Задача 1. Конвертер температур
 * Напишите Java-программу для преобразования температуры из Фаренгейта в градусы Цельсия.
 * Тестовые данные:
 * Введите степень в градусах Фаренгейта: 212
 * Ожидаемый результат:
 * 212.0 градусов по Фаренгейту равна 100.0 по Цельсию
 */
import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите градусы по Фаренгейту: ");
        double fahrenheit = scanner.nextDouble();

        double celsius = (fahrenheit - 32) * 5 / 9;
        System.out.printf("%.1f°F = %.1f°C%n", fahrenheit, celsius);
    }
}