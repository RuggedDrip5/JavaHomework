package repositories;

import exceptions.UserNotFoundException;
import model.User;

import java.util.List;

public interface UsersRepository {
    void create(User user);

    User findById(String id) throws UserNotFoundException;

    List<User> findAll();

    void update(User user) throws UserNotFoundException;

    void deleteById(String id) throws UserNotFoundException;

    void deleteAll();

    // Дополнительные методы
    List<User> findByAge(int age);

    List<User> findByIsWorker(boolean isWorker);
}