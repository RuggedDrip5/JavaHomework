package homework011;

public record Car(String number, String model, String color, long mileage, long price) {

    @Override
    public String toString() {
        return String.format("%-7s %-8s %-6s %-7d %d",
                number, model, color, mileage, price);
    }

}