package homework06;

import java.util.*;
import java.util.stream.Collectors;

public class App {
    private static final Map<String, Person> people = new HashMap<>();
    private static final Map<String, Product> products = new HashMap<>();
    private static final List<String> purchaseHistory = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // 1. Ввод покупателей
            System.out.println("Введите покупателей в формате: Имя=Сумма (END для завершения)");
            readEntities(scanner, "покупателей", (name, money) -> {
                Person p = new Person(name, Double.parseDouble(money));
                people.put(name.toLowerCase(), p);
                return p;
            });

            // 2. Ввод продуктов
            System.out.println("Введите продукты в формате: Название=Цена (END для завершения)");
            readEntities(scanner, "продуктов", (name, price) -> {
                Product p = new Product(name, Double.parseDouble(price));
                products.put(name.toLowerCase(), p);
                return p;
            });

            // 3. Обработка покупок
            System.out.println("Начните покупки (Формат: Имя Покупателя Название Продукта, END для завершения)");
            processPurchases(scanner);

            // 4. Вывод результатов
            printResults();

        } finally {
            scanner.close();
        }
    }

    private static void readEntities(Scanner scanner, String entityType, EntityCreator creator) {
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("END")) break;

            try {
                String[] parts = input.split("=");
                if (parts.length != 2) {
                    System.out.println("Ошибка: Неправильный формат");
                    continue;
                }

                String name = parts[0].trim();
                String value = parts[1].trim();

                if (name.isEmpty()) {
                    System.out.println("Ошибка: Имя не может быть пустым");
                    continue;
                }

                creator.create(name, value);

            } catch (Exception e) {
                System.out.println("Ошибка при создании " + entityType + ": " + e.getMessage());
            }
        }
    }

    private static void processPurchases(Scanner scanner) {
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("END")) break;

            try {
                String[] parts = input.split(" ", 2);
                if (parts.length != 2) {
                    System.out.println("Ошибка: Неправильный формат");
                    continue;
                }

                String personName = parts[0].trim();
                String productName = parts[1].trim();

                Person person = people.get(personName.toLowerCase());
                Product product = products.get(productName.toLowerCase());

                if (person == null) {
                    System.out.println("Ошибка: Покупатель '" + personName + "' не найден");
                    System.out.println("Доступные покупатели: " +
                            people.keySet().stream().collect(Collectors.joining(", ")));
                    continue;
                }
                if (product == null) {
                    System.out.println("Ошибка: Продукт '" + productName + "' не найден");
                    System.out.println("Доступные продукты: " +
                            products.keySet().stream().collect(Collectors.joining(", ")));
                    continue;
                }

                if (person.canAfford(product)) {
                    person.buyProduct(product);
                    String genderSuffix = personName.toLowerCase().endsWith("а") ? "а" : "";
                    purchaseHistory.add(personName + " купил" + genderSuffix + " " + productName);
                    System.out.println("Успешно: " + personName + " купил" + genderSuffix + " " + productName);
                } else {
                    purchaseHistory.add(personName + " не может позволить себе " + productName);
                    System.out.println("Отказ: " + personName + " не может позволить себе " + productName);
                }

            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private static void printResults() {
        System.out.println("\n=== ИТОГИ ПОКУПОК ===");
        purchaseHistory.forEach(System.out::println);

        System.out.println("\n=== ИТОГОВОЕ СОСТОЯНИЕ ===");
        people.values().forEach(person -> {
            if (person != null && person.getName() != null) {
                System.out.print(person.getName() + " - ");
                if (person.getBag().isEmpty()) {
                    System.out.println("Ничего не куплено");
                } else {
                    System.out.println(person.getBag().stream()
                            .filter(Objects::nonNull)
                            .map(Product::getName)
                            .filter(Objects::nonNull)
                            .collect(Collectors.joining(", ")));
                }
            }
        });
    }

    public static Person createPerson(String test, int i) {
        return null;
    }

    public static Product createProduct(String testProduct, int i) {
        return null;
    }

    public static boolean canPersonAffordProduct(Person person, Product product) {
        return false;
    }

    public static boolean canAfford(Person person, Product product) {
        return false;
    }

    @FunctionalInterface
    private interface EntityCreator {
        Object create(String name, String value) throws Exception;
    }
}