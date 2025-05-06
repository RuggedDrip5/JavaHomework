package homework08;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private double money;
    private final List<Product> bag;

    public Customer(String name, double money) {
        setName(name);
        setMoney(money);
        this.bag = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.name = name;
    }

    public void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Деньги не могут быть отрицательными");
        }
        this.money = money;
    }

    public boolean canAfford(Product product) {
        return money >= product.getPrice();
    }

    public void buyProduct(Product product) {
        if (canAfford(product)) {
            bag.add(product);
            money -= product.getPrice();
        } else {
            throw new IllegalArgumentException(String.format(
                    "%s не может позволить себе %s", name, product.getName()));
        }
    }

    @Override
    public String toString() {
        if (!bag.isEmpty()) {
            var sb = new StringBuilder(name).append(" - ");
            for (int i = 0; i < bag.size(); i++) {
                if (i > 0) sb.append(", ");
                sb.append(bag.get(i).getName());
            }
            return sb.toString();
        } else {
            return String.format("%s - Ничего не куплено", name);
        }
    }
}