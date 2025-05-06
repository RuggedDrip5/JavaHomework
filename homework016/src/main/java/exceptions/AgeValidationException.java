package exceptions;

/**
 * Исключение выбрасывается при невалидном возрасте
 */
public class AgeValidationException extends IllegalArgumentException {
    public AgeValidationException(Integer age) {
        super("Некорректный возраст: " + age +
                ". Возраст должен быть положительным числом");
    }
}