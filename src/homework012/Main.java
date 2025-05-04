package homework012;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Введите данные (Фамилия Имя Отчество датарождения номертелефона пол возраст):");
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("exit")) {
                    break;
                }

                String[] data = input.split(" ");
                Person person = new Person(data);
                saveToFile(person);

                System.out.println("Данные успешно сохранены!");

            } catch (IllegalArgumentException e) {
                System.err.println("Ошибка ввода данных: " + e.getMessage());
            } catch (DateTimeParseException e) {
                System.err.println("Ошибка формата даты. Используйте формат dd.mm.yyyy");
            } catch (NumberFormatException e) {
                System.err.println("Ошибка формата номера телефона: " + e.getMessage());
            } catch (IOException e) {
                System.err.println("Ошибка при работе с файлом:");
                e.printStackTrace();
            } catch (Exception e) {
                System.err.println("Неизвестная ошибка:");
                e.printStackTrace();
            }
        }

        scanner.close();
    }

    private static void saveToFile(Person person) throws IOException {
        String fileName = person.getLastName() + ".txt";
        Path path = Paths.get(fileName);

        String personData = person.toString() + System.lineSeparator();

        if (Files.exists(path)) {
            Files.write(path, personData.getBytes(), StandardOpenOption.APPEND);
        } else {
            Files.write(path, personData.getBytes(), StandardOpenOption.CREATE);
        }
    }
}