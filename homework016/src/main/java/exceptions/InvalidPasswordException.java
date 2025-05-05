package exceptions;

/**
 * Исключение выбрасывается при невалидном пароле пользователя
 */
public class InvalidPasswordException extends IllegalArgumentException {
    public InvalidPasswordException() {
        super("Пароль должен содержать буквы и цифры, " +
                "может содержать подчеркивание, " +
                "должен быть короче 20 символов " +
                "и совпадать с подтверждением");
    }

    public InvalidPasswordException(String message) {
        super(message);
    }
}