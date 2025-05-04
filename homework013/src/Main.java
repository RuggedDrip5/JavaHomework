import utils.NumberParser;

public class Main {
    public static void main(String[] args) {
        // Тестирование parseCount
        testParseCount("123");     // Валидное
        testParseCount("12.3");    // Невалидное
        testParseCount("abc");     // Невалидное

        // Тестирование validateCount
        testValidateCount("456");  // Валидное
        testValidateCount("45.6"); // Невалидное
        testValidateCount("def");  // Невалидное

        // Тестирование parseNumber
        testParseNumber("789.12"); // Валидное
        testParseNumber("789");    // Валидное
        testParseNumber("ghi");    // Невалидное

        // Тестирование validateNumber
        testValidateNumber("123.45"); // Валидное
        testValidateNumber("123");    // Валидное
        testValidateNumber("jkl");    // Невалидное
    }

    private static void testParseCount(String input) {
        System.out.println("\nТестируем parseCount с вводом: " + input);
        try {
            Integer result = NumberParser.parseCount(input);
            System.out.println("Успех: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static void testValidateCount(String input) {
        System.out.println("\nТестируем validateCount с вводом: " + input);
        Integer result = NumberParser.validateCount(input);
        if (result != null) {
            System.out.println("Успех: " + result);
        }
    }

    private static void testParseNumber(String input) {
        System.out.println("\nТестируем parseNumber с вводом: " + input);
        try {
            Double result = NumberParser.parseNumber(input);
            System.out.println("Успех: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static void testValidateNumber(String input) {
        System.out.println("\nТестируем validateNumber с вводом: " + input);
        Double result = NumberParser.validateNumber(input);
        if (result != null) {
            System.out.println("Успех: " + result);
        }
    }
}