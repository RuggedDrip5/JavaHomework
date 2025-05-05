package repositories;

import model.User;
import exceptions.UserNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsersRepositoryFileImplmTest {
    private UsersRepository repository;

    @BeforeEach
    void setUp() {
        repository = new UsersRepositoryFileImpl();
        repository.deleteAll();
    }

    @Test
    void createAndFindUser_Success() {
        User user = new User("test1", "pass1", "pass1", "Smith", "John", null, 25, false);
        repository.create(user);

        try {
            User found = repository.findById(user.getId());
            assertEquals(user.getId(), found.getId());
            assertEquals(user.getLogin(), found.getLogin());
        } catch (UserNotFoundException e) {
            fail("User should be found but wasn't: " + e.getMessage());
        }
    }

    @Test
    void findById_UserNotFound_ThrowsException() {
        assertThrows(UserNotFoundException.class, () -> {
            repository.findById("nonexistent");
        });
    }

    @Test
    void updateUser_Success() {
        User user = new User("test2", "pass2", "pass2", "Doe", "Jane", null, 30, true);
        repository.create(user);

        user.setAge(31);
        try {
            repository.update(user);
            User updated = repository.findById(user.getId());
            assertEquals(31, updated.getAge());
        } catch (UserNotFoundException e) {
            fail("User should be found but wasn't: " + e.getMessage());
        }
    }

    @Test
    void deleteUser_Success() {
        User user = new User("test3", "pass3", "pass3", "Brown", "Bob", "Lee", 40, false);
        repository.create(user);

        try {
            repository.deleteById(user.getId());
            assertThrows(UserNotFoundException.class, () -> repository.findById(user.getId()));
        } catch (UserNotFoundException e) {
            fail("User should be found before deletion: " + e.getMessage());
        }
    }

    @Test
    void findAll_ReturnsAllUsers() {
        User user1 = new User("test4", "pass4", "pass4", "Green", "Alice", null, 25, false);
        User user2 = new User("test5", "pass5", "pass5", "Black", "Eve", null, 30, true);
        repository.create(user1);
        repository.create(user2);

        List<User> allUsers = repository.findAll();
        assertEquals(2, allUsers.size());
    }

    @Test
    void findByAge_ReturnsCorrectUsers() {
        User user1 = new User("test6", "pass6", "pass6", "White", "Mike", null, 25, false);
        User user2 = new User("test7", "pass7", "pass7", "Gray", "Ann", null, 25, true);
        repository.create(user1);
        repository.create(user2);

        List<User> users25 = repository.findByAge(25);
        assertEquals(2, users25.size());
    }

    @Test
    void findByIsWorker_ReturnsCorrectUsers() {
        User user1 = new User("test8", "pass8", "pass8", "Blue", "Tom", null, 35, true);
        User user2 = new User("test9", "pass9", "pass9", "Red", "Lisa", null, 40, false);
        repository.create(user1);
        repository.create(user2);

        List<User> workers = repository.findByIsWorker(true);
        assertEquals(1, workers.size());
        assertTrue(workers.get(0).isWorker());
    }
}