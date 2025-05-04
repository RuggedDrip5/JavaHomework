import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Person {
    private final String lastName;
    private final String firstName;
    private final String middleName;
    private final LocalDate birthDate;
    private final long phoneNumber;
    private final char gender;

    public Person(String lastName, String firstName, String middleName,
                  LocalDate birthDate, long phoneNumber, char gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
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