package exceptions;

/**
 * Исключение выбрасывается при невалидном имени, фамилии или отчестве
 */
public class NameValidationException extends IllegalArgumentException {
    public NameValidationException(String fieldName, String value) {
        super("Некорректное значение поля " + fieldName + ": " + value +
                ". Должно содержать только буквы");
    }
}