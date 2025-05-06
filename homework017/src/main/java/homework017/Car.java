package homework017;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
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
}