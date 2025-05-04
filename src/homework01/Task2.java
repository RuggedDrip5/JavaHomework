package homework01;

import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        Random rand = new Random();
        int vasya = rand.nextInt(3); // 0-камень, 1-ножницы, 2-бумага
        int petya = rand.nextInt(3);

        System.out.println("Вася: " + vasya);
        System.out.println("Петя: " + petya);

        if (vasya == petya) {
            System.out.println("Ничья!");
        } else if ((vasya == 0 && petya == 1) ||
                (vasya == 1 && petya == 2) ||
                (vasya == 2 && petya == 0)) {
            System.out.println("Вася выиграл!");
        } else {
            System.out.println("Петя выиграл!");
        }
    }
}