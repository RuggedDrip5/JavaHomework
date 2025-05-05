package exceptions;

/**
 * Исключение выбрасывается при попытке создать пользователя с существующим логином
 */
public class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(String login) {
        super("Пользователь с логином " + login + " уже существует");
    }
}