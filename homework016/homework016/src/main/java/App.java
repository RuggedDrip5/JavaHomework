import model.User;
import repositories.UsersRepository;
import repositories.UsersRepositoryFileImpl;

public class App {
    public static void main(String[] args) {
        UsersRepository repository = new UsersRepositoryFileImpl();

        // Тестирование функционала
        try {
            // Создание пользователя
            User newUser = new User(
                    "test_user",
                    "password123",
                    "password123",
                    "Иванов",
                    "Иван",
                    "Иванович",
                    30,
                    false
            );
            repository.create(newUser);
            System.out.println("User created: " + newUser);

            // Поиск по ID
            String userId = newUser.getId();
            User foundUser = repository.findById(userId);
            System.out.println("Found user: " + foundUser);

            // Обновление пользователя
            foundUser.setAge(31);
            repository.update(foundUser);
            System.out.println("User updated");

            // Поиск по возрасту
            System.out.println("Users with age 31: " + repository.findByAge(31));

            // Удаление пользователя
            repository.deleteById(userId);
            System.out.println("User deleted");

            // Вывод всех пользователей
            System.out.println("All users: " + repository.findAll());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}