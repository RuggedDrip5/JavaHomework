package homework09;

public class ShowCar extends Car {
    private int stars;

    public ShowCar() {
        super();
        this.stars = 0;
    }

    public ShowCar(String brand, String model, int year, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, year, horsepower, acceleration, suspension, durability);
        this.stars = 0;
    }

    public void increaseStars(int value) {
        this.stars += value;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%nStars: %d", stars);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ShowCar showCar = (ShowCar) o;
        return stars == showCar.stars;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), stars);
    }

    // Геттеры и сеттеры
    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}