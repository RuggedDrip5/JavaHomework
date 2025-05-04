import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Person {
    private String lastName;
    private String firstName;
    private String middleName;
    private LocalDate birthDate;
    private long phoneNumber;
    private char gender;

    public Person(String[] data) throws IllegalArgumentException, DateTimeParseException, NumberFormatException {
        if (data.length != 6) {
            throw new IllegalArgumentException("Неверное количество данных. Ожидается 6 параметров, получено " + data.length);
        }

        this.lastName = validateName(data[0], "Фамилия");
        this.firstName = validateName(data[1], "Имя");
        this.middleName = validateName(data[2], "Отчество");
        this.birthDate = parseBirthDate(data[3]);
        this.phoneNumber = parsePhoneNumber(data[4]);
        this.gender = parseGender(data[5]);
    }

    private String validateName(String name, String fieldName) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " не может быть пустым");
        }
        if (!name.matches("[а-яА-ЯёЁa-zA-Z-]+")) {
            throw new IllegalArgumentException(fieldName + " содержит недопустимые символы: " + name);
        }
        return name;
    }

    private LocalDate parseBirthDate(String dateStr) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return LocalDate.parse(dateStr, formatter);
    }

    private long parsePhoneNumber(String phoneStr) throws NumberFormatException {
        try {
            return Long.parseLong(phoneStr);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Номер телефона должен быть целым числом: " + phoneStr);
        }
    }

    private char parseGender(String genderStr) throws IllegalArgumentException {
        if (genderStr.length() != 1 || (!genderStr.equalsIgnoreCase("m") && !genderStr.equalsIgnoreCase("f"))) {
            throw new IllegalArgumentException("Пол должен быть 'm' или 'f': " + genderStr);
        }
        return genderStr.toLowerCase().charAt(0);
    }

    @Override
    public String toString() {
        return String.format("<%s><%s><%s><%s> <%d><%c>",
                lastName, firstName, middleName,
                birthDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                phoneNumber, gender);
    }

    public String getLastName() {
        return lastName;
    }
}