package homework06;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    private Person person;

    @BeforeEach
    void setUp() {
        person = new Person("Test", 1000);
    }

    // Позитивные тесты
    @Test
    void testPersonCreation() {
        assertNotNull(person);
        assertEquals("Test", person.getName());
        assertEquals(1000, person.getMoney(), 0.001);
    }

    @ParameterizedTest
    @CsvSource({"500, true", "1000, true", "1500, false"})
    void testCanAffordWithDifferentPrices(double price, boolean expected) {
        Product product = new Product("Test", price);
        assertEquals(expected, person.canAfford(product));
    }

    // Негативные тесты
    @Test
    void testPersonWithEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> new Person("", 1000));
    }

    @Test
    void testPersonWithNegativeMoney() {
        assertThrows(IllegalArgumentException.class, () -> new Person("Test", -1000));
    }

    @Disabled("Пример игнорируемого теста")
    @Test
    void testIgnored() {
        fail("Этот тест не должен выполняться");
    }
}