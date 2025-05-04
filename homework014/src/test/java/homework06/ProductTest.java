package homework06;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    // Позитивные тесты
    @Test
    void testProductCreation() {
        Product product = new Product("Test", 100);
        assertNotNull(product);
        assertEquals("Test", product.getName());
        assertEquals(100, product.getPrice(), 0.001);
    }

    @ParameterizedTest
    @CsvSource({"Bread, 50", "Milk, 70", "Coffee, 100"})
    void testProductCreationWithParameters(String name, double price) {
        Product product = new Product(name, price);
        assertEquals(name, product.getName());
        assertEquals(price, product.getPrice(), 0.001);
    }

    // Негативные тесты
    @Test
    void testProductWithEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> new Product("", 100));
    }

    @Test
    void testProductWithNegativePrice() {
        assertThrows(IllegalArgumentException.class, () -> new Product("Test", -100));
    }
}