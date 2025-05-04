package homework02;

/**
 * Задача 2. Математические операции
 * Напишите программу на Java, которая принимает два целых числа от пользователя,
 * а затем печатает сумму, разницу, произведение, среднее значение, расстояние
 * (разница между целыми числами), максимум (большее из двух целых чисел),
 * минимум (меньшее из двух целых чисел)
 * Тестовые данные:
 * Введите 1-е целое число: 25
 * Введите второе целое число: 5
 * Ожидаемый результат:
 * Сумма двух целых чисел: 30
 * Разница двух целых чисел: 20
 * Произведение из двух целых чисел: 125
 * Среднее из двух целых чисел: 15,00
 * Расстояние двух целых чисел: 20
 * Максимальное целое число: 25
 * Минимальное целое число: 5
 */
import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        int a = scanner.nextInt();
        System.out.print("Введите второе число: ");
        int b = scanner.nextInt();

        System.out.println("Сумма: " + (a + b));
        System.out.println("Разница: " + (a - b));
        System.out.println("Произведение: " + (a * b));
        System.out.printf("Среднее: %.2f%n", (a + b) / 2.0);
        System.out.println("Расстояние: " + Math.abs(a - b));
        System.out.println("Максимум: " + Math.max(a, b));
        System.out.println("Минимум: " + Math.min(a, b));
    }
}