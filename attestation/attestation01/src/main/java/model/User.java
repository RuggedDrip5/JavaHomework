package model;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;
import java.util.regex.Pattern;

public class User {
    private String id;
    private LocalDateTime registrationDate;
    private String login;
    private String password;
    private String confirmPassword;
    private String lastName;
    private String firstName;
    private String middleName;
    private Integer age;
    private boolean isWorker;

    public User(String login, String password, String confirmPassword,
                String lastName, String firstName, String middleName,
                Integer age, boolean isWorker) {
        this.id = UUID.randomUUID().toString();
        this.registrationDate = LocalDateTime.now();
        setLogin(login);
        setPassword(password, confirmPassword);
        setLastName(lastName);
        setFirstName(firstName);
        setMiddleName(middleName);
        setAge(age);
        this.isWorker = isWorker;
    }

    // Геттеры
    public String getId() {
        return id;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Integer getAge() {
        return age;
    }

    public boolean isWorker() {
        return isWorker;
    }

    // Сеттеры с валидацией
    public void setId(String id) {
        this.id = id;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setLogin(String login) {
        if (login == null || login.length() >= 20) {
            throw new IllegalArgumentException("Login must be less than 20 characters");
        }
        if (Pattern.matches("^\\d+$", login)) {
            throw new IllegalArgumentException("Login cannot consist of only digits");
        }
        if (!Pattern.matches("^[a-zA-Z0-9_]+$", login)) {
            throw new IllegalArgumentException("Login can only contain letters, digits and underscore");
        }
        this.login = login;
    }

    public void setPassword(String password, String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            throw new IllegalArgumentException("Password and confirm password must match");
        }
        if (Pattern.matches("^[a-zA-Z_]+$", password)) {
            throw new IllegalArgumentException("Password cannot consist of only letters");
        }
        if (!Pattern.matches("^[a-zA-Z0-9_]+$", password)) {
            throw new IllegalArgumentException("Password can only contain letters, digits and underscore");
        }
        if (password.length() >= 20) {
            throw new IllegalArgumentException("Password must be less than 20 characters");
        }
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public void setLastName(String lastName) {
        if (lastName == null || !lastName.matches("^[a-zA-Zа-яА-Я]+$")) {
            throw new IllegalArgumentException("Last name must contain only letters");
        }
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || !firstName.matches("^[a-zA-Zа-яА-Я]+$")) {
            throw new IllegalArgumentException("First name must contain only letters");
        }
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        if (middleName != null && !middleName.matches("^[a-zA-Zа-яА-Я]*$")) {
            throw new IllegalArgumentException("Middle name must contain only letters or be null");
        }
        this.middleName = middleName;
    }

    public void setAge(Integer age) {
        if (age != null && age <= 0) {
            throw new IllegalArgumentException("Age must be positive");
        }
        this.age = age;
    }

    public void setWorker(boolean worker) {
        isWorker = worker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.format("%s|%s|%s|%s|%s|%s|%s|%s|%d|%b",
                id, registrationDate, login, password, confirmPassword,
                lastName, firstName, middleName != null ? middleName : "",
                age != null ? age : "", isWorker);
    }
}