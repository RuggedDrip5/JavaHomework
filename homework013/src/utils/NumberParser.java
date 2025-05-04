package utils;

public class NumberParser {

    /**
     * Парсит строку в целое число (Integer)
     * @param input Входная строка
     * @return Результат парсинга
     * @throws IllegalArgumentException Если ввод невалидный
     */

    public static Integer parseCount(String input) throws IllegalArgumentException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Невалидное значение");
        }
    }

    /**
     * Валидирует и парсит строку в целое число
     * @param input Входная строка
     * @return Результат парсинга или null при ошибке
     */
    public static Integer validateCount(String input) {
        try {
            return parseCount(input);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
            return null;
        }
    }

    /**
     * Парсит строку в число с плавающей точкой (Double)
     * @param input Входная строка
     * @return Результат парсинга
     * @throws IllegalArgumentException Если ввод невалидный
     */
    public static Double parseNumber(String input) throws IllegalArgumentException {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Невалидное значение");
        }
    }

    /**
     * Валидирует и парсит строку в число с плавающей точкой
     * @param input Входная строка
     * @return Результат парсинга или null при ошибке
     */
    public static Double validateNumber(String input) {
        try {
            return parseNumber(input);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
            return null;
        }
    }
}
