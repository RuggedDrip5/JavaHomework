package homework07;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> products = new ArrayList<>();

        System.out.println("Введите продукты (формат: Название = Цена [, Скидка%]):");
     //   System.out.println("Примеры:");
     //   System.out.println("Хлеб = 40");
     //   System.out.println("Торт = 800, 15%");
     //   System.out.println("Введите END для завершения");

        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("END")) break;

            try {
                Product product = createProduct(input);
                products.add(product);
                System.out.println("Добавлен продукт: " + product);
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }

        System.out.println("\n=== Итоговый список продуктов ===");
        products.forEach(System.out::println);
    }

    private static Product createProduct(String input) {
        String[] parts = input.split("=");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Неверный формат ввода");
        }

        String name = parts[0].trim();
        String pricePart = parts[1].trim();

        if (pricePart.contains(",")) {
            String[] priceDiscount = pricePart.split(",");
            double price = Double.parseDouble(priceDiscount[0].trim());
            double discount = Double.parseDouble(priceDiscount[1].replace("%", "").trim());
            LocalDate endDate = LocalDate.now().plusDays(7); // Скидка на 7 дней

            return new DiscountProduct(name, price, discount, endDate);
        } else {
            double price = Double.parseDouble(pricePart);
            return new Product(name, price);
        }
    }
}