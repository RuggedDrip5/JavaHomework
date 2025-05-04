package homework05;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Television[] tvs = new Television[10];

        // Заполнение массива 10 телевизорами
        String[] brands = {"Samsung", "LG", "Sony", "Panasonic", "Philips",
                "Xiaomi", "Toshiba", "Sharp", "Hisense", "TCL"};

        for (int i = 0; i < tvs.length; i++) {
            tvs[i] = new Television(
                    brands[i],
                    32.0 + random.nextDouble() * 40,  // диагональ 32-72 дюйма
                    random.nextBoolean() ? 1080 : 2160, // разрешение
                    random.nextBoolean(),              // Smart TV
                    15000 + random.nextDouble() * 85000, // цена 15000-100000
                    random.nextInt(100) + 1,          // канал 1-100
                    random.nextInt(101),               // громкость 0-100
                    random.nextBoolean()               // включен/выключен
            );
        }

        // Вывод всех телевизоров
        System.out.println("Все телевизоры:");
        Arrays.stream(tvs).forEach(System.out::println);

        // Ввод максимальной громкости
        System.out.print("\nВведите максимальную громкость (50-70): ");
        int maxVolume = scanner.nextInt();

        // Фильтрация и сортировка
        System.out.println("\nВключенные телевизоры с громкостью <= " + maxVolume + ":");
        Arrays.stream(tvs)
                .filter(tv -> tv.isOn() && tv.getVolume() <= maxVolume)
                .sorted((tv1, tv2) -> Integer.compare(tv1.getCurrentChannel(), tv2.getCurrentChannel()))
                .forEach(System.out::println);

        // Демонстрация работы методов
        System.out.println("\nДемонстрация работы методов:");
        Television demoTV = tvs[0];
        demoTV.turnOn();
        demoTV.changeChannel(5);
        demoTV.setVolume(60);
        demoTV.turnOff();
        demoTV.changeChannel(10);
    }
}