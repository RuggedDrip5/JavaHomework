package homework012;

import java.io.IOException;
import java.nio.file.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\nВведите данные в следующем порядке:");
                System.out.println("Фамилия Имя Отчество дата_рождения(dd.mm.yyyy) номер_телефона(целое число) пол(m/f)");
                System.out.println("Пример: Иванов Петр Сидорович 12.05.1990 79123456789 m");
                System.out.println("Для выхода введите 'exit'");

                String input = scanner.nextLine().trim();

                if (input.equalsIgnoreCase("exit")) {
                    break;
                }

                // Разбираем ввод
                String[] parts = parseInput(input);

                // Создаем и сохраняем персону
                Person person = createPerson(parts);
                saveToFile(person);

                System.out.println("Данные успешно сохранены в файл " + person.getLastName() + ".txt");

            } catch (NumberFormatException e) {
                System.err.println("Ошибка формата телефона: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.err.println("Ошибка ввода: " + e.getMessage());
            } catch (DateTimeParseException e) {
                System.err.println("Ошибка формата даты. Используйте dd.mm.yyyy");
            } catch (IOException e) {
                System.err.println("Ошибка записи в файл:");
                e.printStackTrace();
            } catch (Exception e) {
                System.err.println("Неизвестная ошибка:");
                e.printStackTrace();
            }
        }

        scanner.close();
    }

    private static String[] parseInput(String input) {
        // Разбиваем строку на части, сохраняя ФИО вместе
        String[] parts = input.split("\\s+");

        // Нужно минимум 6 частей (Ф+И+О+дата+телефон+пол)
        if (parts.length < 6) {
            throw new IllegalArgumentException("Недостаточно данных. Нужно 6 параметров");
        }

        // Собираем ФИО (первые 3 элемента)
        String[] result = new String[6];
        result[0] = parts[0]; // Фамилия
        result[1] = parts[1]; // Имя
        result[2] = parts[2]; // Отчество

        // Остальные параметры
        result[3] = parts[3]; // Дата
        result[4] = parts[4]; // Телефон
        result[5] = parts[5]; // Пол

        // Проверяем, что дата на своем месте (должна содержать точки)
        if (!result[3].contains(".")) {
            // Возможно, ФИО содержит больше частей (двойные имена)
            if (parts.length > 6) {
                // Объединяем отчество с возможным вторым именем
                result[2] = parts[2] + " " + parts[3];
                result[3] = parts[4]; // Дата
                result[4] = parts[5]; // Телефон
                result[5] = parts[6]; // Пол
            }
        }

        return result;
    }

    private static Person createPerson(String[] data) {
        // Проверяем обязательные поля
        if (data[0].isEmpty()) throw new IllegalArgumentException("Фамилия не может быть пустой");
        if (data[1].isEmpty()) throw new IllegalArgumentException("Имя не может быть пустым");
        if (data[2].isEmpty()) throw new IllegalArgumentException("Отчество не может быть пустым");

        // Парсим дату
        LocalDate birthDate = LocalDate.parse(data[3], DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        // Парсим телефон
        long phone = Long.parseLong(data[4]);

        // Проверяем пол
        char gender = data[5].toLowerCase().charAt(0);
        if (gender != 'm' && gender != 'f') {
            throw new IllegalArgumentException("Пол должен быть 'm' или 'f'");
        }

        return new Person(data[0], data[1], data[2], birthDate, phone, gender);
    }

    private static void saveToFile(Person person) throws IOException {
        String fileName = person.getLastName() + ".txt";
        String content = person.toString() + System.lineSeparator();

        Files.write(Paths.get(fileName), content.getBytes(),
                Files.exists(Paths.get(fileName)) ? StandardOpenOption.APPEND : StandardOpenOption.CREATE);
    }
}