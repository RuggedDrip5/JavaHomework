package homework017;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.ArrayList;
import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class PerformanceCar extends Car {
    private final List<String> addOns;

    public PerformanceCar(String brand, String model, int year, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, year, (int)(horsepower * 1.5), acceleration, (int)(suspension * 0.75), durability);
        this.addOns = new ArrayList<>();
    }

    public void addAddOn(String addOn) {
        this.addOns.add(addOn);
    }
}