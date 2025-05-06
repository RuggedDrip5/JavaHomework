package exceptions;

/**
 * Исключение выбрасывается при ошибках работы с файлом
 */
public class FileOperationException extends RuntimeException {
    public FileOperationException(String message) {
        super("Ошибка работы с файлом: " + message);
    }

    public FileOperationException(String message, Throwable cause) {
        super("Ошибка работы с файлом: " + message, cause);
    }
}