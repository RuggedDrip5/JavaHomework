package homework010;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        int[] numbers = {12, 45, 68, 23, 44, 91, 10, 37, 52};

        // 1. Фильтрация четных чисел
        int[] evenNumbers = Sequence.filter(numbers, n -> n % 2 == 0);
        System.out.println("Четные числа: " + Arrays.toString(evenNumbers));

        // 2. Фильтрация чисел с четной суммой цифр
        int[] numbersWithEvenDigitSum = Sequence.filter(numbers,
                n -> Sequence.sumOfDigits(n) % 2 == 0);
        System.out.println("Числа с четной суммой цифр: " +
                Arrays.toString(numbersWithEvenDigitSum));
    }
}