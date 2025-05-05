package homework017;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ShowCar extends Car {
    private int stars;

    public ShowCar(String brand, String model, int year, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, year, horsepower, acceleration, suspension, durability);
        this.stars = 0;
    }

    public void increaseStars(int value) {
        this.stars += value;
    }
}