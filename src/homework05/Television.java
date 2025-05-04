package homework05;

import java.util.Objects;

public class Television {
    private String brand;
    private double diagonal;
    private int resolution;
    private boolean isSmart;
    private double price;
    private int currentChannel;
    private int volume;
    private boolean isOn;

    public Television() {
        this("Unknown", 32.0, 1080, false, 0.0, 1, 50, false);
    }

    public Television(String brand, double diagonal, int resolution,
                      boolean isSmart, double price, int currentChannel,
                      int volume, boolean isOn) {
        this.brand = brand;
        this.diagonal = diagonal;
        this.resolution = resolution;
        this.isSmart = isSmart;
        this.price = price;
        setCurrentChannel(currentChannel);
        setVolume(volume);
        this.isOn = isOn;
    }

    // Геттеры и сеттеры
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public double getDiagonal() { return diagonal; }
    public void setDiagonal(double diagonal) { this.diagonal = diagonal; }

    public int getResolution() { return resolution; }
    public void setResolution(int resolution) { this.resolution = resolution; }

    public boolean isSmart() { return isSmart; }
    public void setSmart(boolean smart) { isSmart = smart; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getCurrentChannel() { return currentChannel; }
    public void setCurrentChannel(int channel) {
        if (channel > 0) this.currentChannel = channel;
    }

    public int getVolume() { return volume; }
    public void setVolume(int volume) {
        if (volume >= 0 && volume <= 100) this.volume = volume;
    }

    public boolean isOn() { return isOn; }
    public void setOn(boolean on) { isOn = on; }

    // Методы
    public void turnOn() {
        isOn = true;
        System.out.println(brand + ": Телевизор включен");
    }

    public void turnOff() {
        isOn = false;
        System.out.println(brand + ": Телевизор выключен");
    }

    public void changeChannel(int channel) {
        if (isOn) {
            setCurrentChannel(channel);
            System.out.println(brand + ": Переключение на канал " + channel);
        } else {
            System.out.println(brand + ": Телевизор выключен!");
        }
    }

    @Override
    public String toString() {
        return String.format(
                "Television [brand=%s, diagonal=%.1f\", resolution=%dp, smart=%s, " +
                        "price=%.2f руб., channel=%d, volume=%d, power=%s]",
                brand, diagonal, resolution, isSmart ? "yes" : "no",
                price, currentChannel, volume, isOn ? "on" : "off"
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Television tv = (Television) o;
        return Double.compare(tv.diagonal, diagonal) == 0 &&
                resolution == tv.resolution &&
                isSmart == tv.isSmart &&
                Double.compare(tv.price, price) == 0 &&
                currentChannel == tv.currentChannel &&
                volume == tv.volume &&
                isOn == tv.isOn &&
                Objects.equals(brand, tv.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, diagonal, resolution, isSmart, price,
                currentChannel, volume, isOn);
    }
}