package homework03;

import java.util.Scanner;
import java.util.Random;

/**
 * Класс для тестирования работы класса Television
 */
public class App {
    public static void main(String[] args) {
        // Создание телевизора через конструктор с параметрами
        Television tv1 = new Television("Samsung", 55.0, 3840, true, 89999.99);
        System.out.println("Телевизор 1:");
        System.out.println(tv1);
        tv1.turnOn();
        tv1.changeChannel(5);
        System.out.println();

        // Создание телевизора через пустой конструктор и сеттеры
        Television tv2 = new Television();
        tv2.setBrand("LG");
        tv2.setDiagonal(43.5);
        tv2.setResolution(2160);
        tv2.setSmart(true);
        tv2.setPrice(54999.90);
        System.out.println("Телевизор 2:");
        System.out.println(tv2);
        System.out.println();

        // Создание телевизора с вводом параметров с клавиатуры
        Scanner scanner = new Scanner(System.in);
        Television tv3 = new Television();

        System.out.println("Введите параметры телевизора:");
        System.out.print("Бренд: ");
        tv3.setBrand(scanner.nextLine());

        System.out.print("Диагональ (дюймы): ");
        tv3.setDiagonal(scanner.nextDouble());

        System.out.print("Разрешение (например, 1080, 2160): ");
        tv3.setResolution(scanner.nextInt());

        System.out.print("Smart TV (true/false): ");
        tv3.setSmart(scanner.nextBoolean());

        System.out.print("Цена: ");
        tv3.setPrice(scanner.nextDouble());

        System.out.println("\nТелевизор 3 (введен с клавиатуры):");
        System.out.println(tv3);
        System.out.println();

        // Создание телевизора со случайными параметрами
        Random random = new Random();
        String[] brands = {"Sony", "Philips", "Toshiba", "Panasonic", "Xiaomi"};
        Television tv4 = new Television(
                brands[random.nextInt(brands.length)],
                30 + random.nextDouble() * 70,
                random.nextBoolean() ? 1080 : 2160,
                random.nextBoolean(),
                10000 + random.nextDouble() * 190000
        );
        System.out.println("Телевизор 4 (случайные параметры):");
        System.out.println(tv4);
    }
}