package homework010;

public class Sequence {
    public static int[] filter(int[] array, ByCondition condition) {
        // Сначала считаем количество подходящих элементов
        int count = 0;
        for (int num : array) {
            if (condition.isOk(num)) {
                count++;
            }
        }

        // Создаем массив нужного размера и заполняем его
        int[] result = new int[count];
        int index = 0;
        for (int num : array) {
            if (condition.isOk(num)) {
                result[index++] = num;
            }
        }

        return result;
    }

    // Вспомогательный метод для вычисления суммы цифр числа
    public static int sumOfDigits(int number) {
        int sum = 0;
        number = Math.abs(number); // Работаем с положительными числами
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}