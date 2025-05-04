package homework06;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    void testCanAfford() {
        Person person = new Person("Test", 1000);
        Product product = new Product("Test", 500);
        assertTrue(App.canAfford(person, product));
    }
}