package homework09;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PerformanceCar extends Car {
    private final List<String> addOns;

    public PerformanceCar(String brand, String model, int year, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, year, (int)(horsepower * 1.5), acceleration, (int)(suspension * 0.75), durability);
        this.addOns = new ArrayList<>();
    }

    public void addAddOn(String addOn) {
        this.addOns.add(addOn);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\nAdd-ons: ");
        if (addOns.isEmpty()) {
            sb.append("None");
        } else {
            sb.append(String.join(", ", addOns));
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PerformanceCar that = (PerformanceCar) o;
        return Objects.equals(addOns, that.addOns);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), addOns);
    }

}