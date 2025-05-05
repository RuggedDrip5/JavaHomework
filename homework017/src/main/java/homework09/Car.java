package homework09;

import java.util.Objects;

public class Car {
    private final String brand;
    private final String model;
    private final int year;
    private final int horsepower;
    private final int acceleration;
    private final int suspension;
    private final int durability;

    public Car(String brand, String model, int year, int horsepower, int acceleration, int suspension, int durability) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.horsepower = horsepower;
        this.acceleration = acceleration;
        this.suspension = suspension;
        this.durability = durability;
    }

    @Override
    public String toString() {
        return String.format("%s %s (%d)%n" +
                        "Horsepower: %d%n" +
                        "Acceleration: %d%n" +
                        "Suspension: %d%n" +
                        "Durability: %d",
                brand, model, year, horsepower, acceleration, suspension, durability);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year && horsepower == car.horsepower && acceleration == car.acceleration
                && suspension == car.suspension && durability == car.durability
                && Objects.equals(brand, car.brand) && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, year, horsepower, acceleration, suspension, durability);
    }

    public int getHorsepower() {
        return horsepower;
    }

    public int getSuspension() {
        return suspension;
    }

}