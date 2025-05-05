package homework09;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.ArrayList;
import java.util.List;

@ToString
@EqualsAndHashCode
public class Garage {
    private final List<Car> parkedCars;

    public Garage() {
        this.parkedCars = new ArrayList<>();
    }

    public void parkCar(Car car) {
        parkedCars.add(car);
    }

    public void tuneCar(int index, String addOn) {
        if (index >= 0 && index < parkedCars.size()) {
            Car car = parkedCars.get(index);
            if (car instanceof PerformanceCar) {
                ((PerformanceCar) car).addAddOn(addOn);
            } else if (car instanceof ShowCar) {
                ((ShowCar) car).increaseStars(Integer.parseInt(addOn));
            }
        }
    }
}