package homework04;

/*
  Задача 1. Поиск соседней буквы на клавиатуре
  Условие:
  Для введенной с клавиатуры буквы английского алфавита нужно вывести
  слева стоящую букву на стандартной клавиатуре. Клавиатура замкнута:
  - справа от 'p' стоит 'a'
  - слева от 'a' стоит 'p'
  - соседние пары: 'l'-'z' и 'm'-'q'
  Входные данные: один символ - маленькая буква английского алфавита
  Выходные данные: буква слева от заданной с учетом замкнутости
 */
import java.util.Scanner;

public class KeyboardLetterFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите букву английского алфавита: ");
        char input = scanner.next().charAt(0);

        if (!Character.isLetter(input)) {
            System.out.println("Ошибка: введен не буквенный символ");
            return;
        }

        char lowerInput = Character.toLowerCase(input);
        String keyboard = "qwertyuiopasdfghjklzxcvbnm";
        int index = keyboard.indexOf(lowerInput);

        if (index == -1) {
            System.out.println("Ошибка: буква не найдена на клавиатуре");
        } else {
            int leftIndex = (index - 1 + keyboard.length()) % keyboard.length();
            System.out.println("Слева от " + input + " находится: " + keyboard.charAt(leftIndex));
        }
    }
}