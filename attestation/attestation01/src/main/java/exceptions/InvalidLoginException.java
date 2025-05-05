package exceptions;

/**
 * Исключение выбрасывается при невалидном логине пользователя
 */
public class InvalidLoginException extends IllegalArgumentException {
    public InvalidLoginException(String login) {
        super("Некорректный логин: " + login +
                ". Логин должен содержать только буквы, цифры и подчеркивание, " +
                "не может состоять только из цифр и должен быть короче 20 символов");
    }
}