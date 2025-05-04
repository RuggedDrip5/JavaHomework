package homework04;

/*
  Задача 2. Подсчет стрелок в последовательности
  Условие:
  Дана последовательность из символов '>', '<' и '-'.
  Нужно найти количество стрелок - подстрок вида:
  - '>>-->'
  - '<--<<'*
  Входные данные: строка длиной до 10^6 символов
  Выходные данные: количество найденных стрелок
 */

import java.util.Scanner;

public class ArrowCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите последовательность символов: ");
        String input = scanner.nextLine();

        int count = 0;
        for (int i = 0; i <= input.length() - 5; i++) {
            String substring = input.substring(i, i + 5);
            if (substring.equals(">>-->") || substring.equals("<--<<")) {
                count++;
            }
        }

        System.out.println("Количество стрелок: " + count);
    }
}