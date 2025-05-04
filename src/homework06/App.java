package homework06;

import java.util.*;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Создаем список покупателей
        List<Person> people = createEntities(scanner, "покупателей",
                "Введите покупателей в формате: Имя=Сумма (END для завершения)",
                (name, value) -> new Person(name, Double.parseDouble(value)));

        // Создаем список продуктов
        List<Product> products = createEntities(scanner, "продуктов",
                "Введите продукты в формате: Название=Цена (END для завершения)",
                (name, value) -> new Product(name, Double.parseDouble(value)));

        // Процесс покупок
        processPurchases(scanner, people, products);

        // Вывод результатов
        printResults(people);
    }

    private static <T> List<T> createEntities(Scanner scanner, String entityType,
                                              String prompt, EntityCreator<T> creator) {
        List<T> entities = new ArrayList<>();
        System.out.println(prompt);

        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("END")) break;

            try {
                // Разделяем по первому знаку =
                String[] parts = splitByFirstEquals(input);
                T entity = creator.create(parts[0].trim(), parts[1].trim());
                entities.add(entity);
            } catch (Exception e) {
                System.out.println("Ошибка при создании " + entityType + ": " + e.getMessage());
            }
        }
        return entities;
    }

    private static void processPurchases(Scanner scanner, List<Person> people, List<Product> products) {
        System.out.println("Начните покупки (Формат: Имя Покупателя Название Продукта, END для завершения)");

        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("END")) break;

            try {
                // Ищем последнее вхождение пробела между именем и продуктом
                int lastSpace = findLastSpaceBetweenEntities(input, people, products);

                String personName = input.substring(0, lastSpace).trim();
                String productName = input.substring(lastSpace + 1).trim();

                Person person = findPerson(people, personName);
                Product product = findProduct(products, productName);

                if (person.canAfford(product)) {
                    person.buyProduct(product);
                    System.out.printf("%s купил(а) %s%n", personName, productName);
                } else {
                    System.out.printf("%s не может позволить себе %s%n", personName, productName);
                }
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }

    private static int findLastSpaceBetweenEntities(String input, List<Person> people, List<Product> products) {
        // Пробуем найти разделитель, который лучше всего соответствует именам и продуктам
        for (int i = input.length() - 1; i > 0; i--) {
            if (input.charAt(i) == ' ') {
                String possiblePerson = input.substring(0, i).trim();
                String possibleProduct = input.substring(i + 1).trim();

                boolean personExists = people.stream().anyMatch(p -> p.getName().equals(possiblePerson));
                boolean productExists = products.stream().anyMatch(p -> p.getName().equals(possibleProduct));

                if (personExists && productExists) {
                    return i;
                }
            }
        }
        throw new IllegalArgumentException("Не удалось определить разделитель между именем и продуктом");
    }

    private static String[] splitByFirstEquals(String input) {
        int eqIndex = input.indexOf('=');
        if (eqIndex == -1) {
            throw new IllegalArgumentException("Отсутствует знак =");
        }
        return new String[]{input.substring(0, eqIndex), input.substring(eqIndex + 1)};
    }

    private static Person findPerson(List<Person> people, String name) {
        return people.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Покупатель не найден: " + name));
    }

    private static Product findProduct(List<Product> products, String name) {
        return products.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Продукт не найден: " + name));
    }

    private static void printResults(List<Person> people) {
        System.out.println("\n=== Итоги покупок ===");
        people.forEach(person -> {
            System.out.print(person.getName() + " - ");
            if (person.getBag().isEmpty()) {
                System.out.println("Ничего не куплено");
            } else {
                System.out.println(String.join(", ",
                        person.getBag().stream()
                                .map(Product::getName)
                                .toArray(String[]::new)));
            }
        });
    }

    @FunctionalInterface
    private interface EntityCreator<T> {
        T create(String name, String value) throws Exception;
    }
}