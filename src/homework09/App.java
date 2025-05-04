package homework09;

public class App {
    public static void main(String[] args) {
        // Создаем автомобили
        PerformanceCar performanceCar1 = new PerformanceCar("Ferrari", "488 GTB", 2020, 670, 3, 300, 500);
        PerformanceCar performanceCar2 = new PerformanceCar("Lamborghini", "Huracan", 2021, 640, 3, 320, 550);

        ShowCar showCar1 = new ShowCar("Porsche", "911 Turbo S", 2022, 650, 3, 350, 600);
        ShowCar showCar2 = new ShowCar("McLaren", "720S", 2021, 710, 3, 340, 580);

        // Создаем гонки
        CasualRace casualRace = new CasualRace(10, "Monaco Street Circuit", 100000);
        DragRace dragRace = new DragRace(5, "Drag Strip", 50000);
        DriftRace driftRace = new DriftRace(8, "Mountain Pass", 75000);

        // Добавляем участников в гонки
        casualRace.addParticipant(performanceCar1);
        casualRace.addParticipant(showCar1);

        dragRace.addParticipant(performanceCar1);
        dragRace.addParticipant(performanceCar2);

        driftRace.addParticipant(showCar1);
        driftRace.addParticipant(showCar2);

        // Создаем гараж
        Garage garage = new Garage();
        garage.parkCar(performanceCar1);
        garage.parkCar(showCar2);

        // Модифицируем автомобили в гараже
        garage.tuneCar(0, "Turbo Boost");
        garage.tuneCar(1, "50");

        // Выводим информацию
        System.out.println("=== Casual Race ===");
        System.out.println(casualRace);

        System.out.println("\n=== Drag Race ===");
        System.out.println(dragRace);

        System.out.println("\n=== Drift Race ===");
        System.out.println(driftRace);

        System.out.println("\n=== Garage ===");
        System.out.println(garage);
    }
}
