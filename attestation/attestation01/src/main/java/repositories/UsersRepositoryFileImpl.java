package repositories;

import model.User;
import exceptions.UserNotFoundException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UsersRepositoryFileImpl implements UsersRepository {
    private static final String FILE_PATH = "src/main/resources/users.txt";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    private final List<User> users = new ArrayList<>();

    public UsersRepositoryFileImpl() {
        loadUsersFromFile();
    }

    private void loadUsersFromFile() {
        try {
            Path path = Paths.get(FILE_PATH);
            if (Files.exists(path)) {
                List<String> lines = Files.readAllLines(path);
                for (String line : lines) {
                    if (!line.trim().isEmpty()) {
                        users.add(parseUser(line));
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load users from file", e);
        }
    }

    private User parseUser(String line) {
        String[] parts = line.split("\\|");
        if (parts.length != 10) {
            throw new IllegalArgumentException("Invalid user data format");
        }

        User user = new User(
                parts[2], parts[3], parts[4],
                parts[5], parts[6], parts[7],
                parts[8].isEmpty() ? null : Integer.parseInt(parts[8]),
                Boolean.parseBoolean(parts[9])
        );

        user.setId(parts[0]);
        user.setRegistrationDate(LocalDateTime.parse(parts[1], FORMATTER));

        return user;
    }

    private void saveUsersToFile() {
        try {
            Path path = Paths.get(FILE_PATH);
            Files.createDirectories(path.getParent());

            try (PrintWriter writer = new PrintWriter(FILE_PATH)) {
                for (User user : users) {
                    writer.println(user.toString());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to save users to file", e);
        }
    }

    @Override
    public void create(User user) {
        users.add(user);
        saveUsersToFile();
    }

    @Override
    public User findById(String id) throws UserNotFoundException {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found"));
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    @Override
    public void update(User user) throws UserNotFoundException {
        User existingUser = findById(user.getId());
        int index = users.indexOf(existingUser);
        users.set(index, user);
        saveUsersToFile();
    }

    @Override
    public void deleteById(String id) throws UserNotFoundException {
        User user = findById(id);
        users.remove(user);
        saveUsersToFile();
    }

    @Override
    public void deleteAll() {
        users.clear();
        saveUsersToFile();
    }

    @Override
    public List<User> findByAge(int age) {
        return users.stream()
                .filter(user -> user.getAge() != null && user.getAge() == age)
                .collect(Collectors.toList());
    }

    @Override
    public List<User> findByIsWorker(boolean isWorker) {
        return users.stream()
                .filter(user -> user.isWorker() == isWorker)
                .collect(Collectors.toList());
    }
}