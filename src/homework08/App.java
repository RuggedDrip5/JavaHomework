package homework08;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class App {
    private static final String INPUT_FILE = "/Users/ruggeddrip5/Documents/Data/input.txt";
    private static final String OUTPUT_FILE = "/Users/ruggeddrip5/Documents/Data/output.txt";

    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        List<String> purchaseHistory = new ArrayList<>();

        try {
            // 1. Чтение данных из файла
            readDataFromFile(INPUT_FILE, customers, products);

            // 2. Обработка покупок
            processPurchases(INPUT_FILE, customers, products, purchaseHistory);

            // 3. Запись результатов в файл
            writeResultsToFile(OUTPUT_FILE, customers, purchaseHistory);

            System.out.println("Программа успешно завершена. Результаты в файле " + OUTPUT_FILE);

        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    private static void writeResultsToFile(String outputFile, List<Customer> customers, List<String> purchaseHistory) {
    }

    private static void readDataFromFile(String filename,
                                         List<Customer> customers,
                                         List<Product> products) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            String currentSection = null;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                if (line.equalsIgnoreCase("CUSTOMERS")) {
                    currentSection = "CUSTOMERS";
                    continue;
                } else if (line.equalsIgnoreCase("PRODUCTS")) {
                    currentSection = "PRODUCTS";
                    continue;
                } else if (line.equalsIgnoreCase("PURCHASES")) {
                    currentSection = "PURCHASES";
                    continue;
                } else if (line.equalsIgnoreCase("END")) {
                    break;
                }

                try {
                    if ("CUSTOMERS".equals(currentSection)) {
                        String[] parts = line.split("=", 2);
                        if (parts.length == 2) {
                            String name = parts[0].trim();
                            String money = parts[1].trim();
                            customers.add(new Customer(name, Double.parseDouble(money)));
                        }
                    } else if ("PRODUCTS".equals(currentSection)) {
                        String[] parts = line.split("=", 2);
                        if (parts.length == 2) {
                            String name = parts[0].trim();
                            String price = parts[1].trim();
                            products.add(new Product(name, Double.parseDouble(price)));
                        }
                    }
                } catch (Exception e) {
                    System.err.println("Ошибка обработки строки: " + line + " - " + e.getMessage());
                }
            }
        }
    }

    private static void processPurchases(String filename,
                                         List<Customer> customers,
                                         List<Product> products,
                                         List<String> purchaseHistory) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            boolean inPurchasesSection = false;
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.equalsIgnoreCase("PURCHASES")) {
                    inPurchasesSection = true;
                    continue;
                }
                if (line.equalsIgnoreCase("END")) {
                    break;
                }
                if (!inPurchasesSection || line.isEmpty()) {
                    continue;
                }

                processPurchaseLine(line, customers, products, purchaseHistory);
            }
        }
    }

    private static void processPurchaseLine(String line,
                                            List<Customer> customers,
                                            List<Product> products,
                                            List<String> purchaseHistory) {
        // Находим первый пробел, чтобы отделить имя покупателя
        int firstSpaceIndex = line.indexOf(' ');
        if (firstSpaceIndex <= 0) {
            System.err.println("Некорректный формат покупки: " + line);
            return;
        }

        String customerName = line.substring(0, firstSpaceIndex).trim();
        String productName = line.substring(firstSpaceIndex + 1).trim();

        try {
            Customer customer = findCustomerByName(customers, customerName);
            Product product = findProductByName(products, productName);

            if (customer.canAfford(product)) {
                customer.buyProduct(product);
                String genderSuffix = customerName.endsWith("а") ? "а" : "";
                purchaseHistory.add(customerName + " купил" + genderSuffix + " " + productName);
            } else {
                purchaseHistory.add(customerName + " не может позволить себе " + productName);
            }
        } catch (Exception e) {
            System.err.println("Ошибка обработки покупки: " + line + " - " + e.getMessage());
        }
    }

    private static Customer findCustomerByName(List<Customer> customers, String name) {
        return customers.stream()
                .filter(c -> c.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Покупатель не найден: " + name));
    }

    private static Product findProductByName(List<Product> products, String name) {
        return products.stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Продукт не найден: " + name));
    }

    private static Product findProduct(List<Product> products, String name) {
        return products.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Продукт не найден: " + name));
    }
}