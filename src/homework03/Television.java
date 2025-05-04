package homework03;

/**
 * Домашнее задание 3
 * Класс Телевизор с полями, свойствами и методами
 * Требования:
 * 1. Поля должны быть private
 * 2. Доступ к полям через getters/setters
 * 3. Переопределение метода toString()
 * 4. Возможность задания параметров через конструктор и сеттеры
 */
public class Television {
    // Поля класса
    private String brand;
    private double diagonal;
    private int resolution;
    private boolean isSmart;
    private double price;

    // Конструкторы
    public Television() {
        this.brand = "Unknown";
        this.diagonal = 32.0;
        this.resolution = 1080;
        this.isSmart = false;
        this.price = 0.0;
    }

    public Television(String brand, double diagonal, int resolution, boolean isSmart, double price) {
        this.brand = brand;
        this.diagonal = diagonal;
        this.resolution = resolution;
        this.isSmart = isSmart;
        this.price = price;
    }

    // Геттеры и сеттеры
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(double diagonal) {
        this.diagonal = diagonal;
    }

    public int getResolution() {
        return resolution;
    }

    public void setResolution(int resolution) {
        this.resolution = resolution;
    }

    public boolean isSmart() {
        return isSmart;
    }

    public void setSmart(boolean smart) {
        isSmart = smart;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Методы
    public void turnOn() {
        System.out.println("Телевизор " + brand + " включен");
    }

    public void changeChannel(int channel) {
        System.out.println("Переключение на канал " + channel);
    }

    // Переопределение toString
    @Override
    public String toString() {
        return "Телевизор {" +
                "бренд='" + brand + '\'' +
                ", диагональ=" + diagonal + "\"" +
                ", разрешение=" + resolution + "p" +
                ", Smart TV=" + (isSmart ? "Да" : "Нет") +
                ", цена=" + price + " руб." +
                '}';
    }
}