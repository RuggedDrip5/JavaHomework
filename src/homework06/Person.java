package homework06;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person {
    private String name;
    private double money;
    private List<Product> bag;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.bag = new ArrayList<>();
    }

    public Person() {

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

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Деньги не могут быть отрицательными");
        }
        this.money = money;
    }

    public List<Product> getBag() {
        return new ArrayList<>(bag);
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
        if (bag.isEmpty()) {
            return String.format("%s - Ничего не куплено", name);
        }
        StringBuilder sb = new StringBuilder(name).append(" - ");
        for (int i = 0; i < bag.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(bag.get(i).getName());
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Double.compare(person.money, money) == 0 &&
                Objects.equals(name, person.name) &&
                Objects.equals(bag, person.bag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, money, bag);
    }
}