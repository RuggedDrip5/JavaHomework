package homework07;

import java.util.Objects;
import java.util.regex.Pattern;

public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        setName(name);
        setPrice(price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя продукта не может быть пустым");
        }
        if (name.trim().length() < 3) {
            throw new IllegalArgumentException("Название продукта должно содержать минимум 3 символа");
        }
        if (Pattern.matches("^\\d+$", name.trim())) {
            throw new IllegalArgumentException("Название продукта не может состоять только из цифр");
        }
        this.name = name.trim();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Цена продукта должна быть положительной");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s (%.2f руб.)", name, price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}