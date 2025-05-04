package homework09;

import java.util.ArrayList;
import java.util.List;

public class Garage {
    private List<Car> parkedCars;

    public Garage() {
        this.parkedCars = new ArrayList<>();
    }

    public void parkCar(Car car) {
        parkedCars.add(car);
    }

    public void unparkCar(Car car) {
        parkedCars.remove(car);
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Garage:\n");
        if (parkedCars.isEmpty()) {
            sb.append("No cars parked");
        } else {
            for (Car car : parkedCars) {
                sb.append(car.toString()).append("\n");
            }
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Garage garage = (Garage) o;
        return Objects.equals(parkedCars, garage.parkedCars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parkedCars);
    }

    // Геттеры и сеттеры
    public List<Car> getParkedCars() {
        return parkedCars;
    }

    public void setParkedCars(List<Car> parkedCars) {
        this.parkedCars = parkedCars;
    }
}
