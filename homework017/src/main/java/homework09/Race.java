package homework09;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Race {
    private int length;
    private String route;
    private int prizePool;
    private final List<Car> participants;

    public Race() {
        this.participants = new ArrayList<>();
    }

    public Race(int length, String route, int prizePool) {
        this();
        this.length = length;
        this.route = route;
        this.prizePool = prizePool;
    }

    public void addParticipant(Car car) {
        participants.add(car);
    }

    @Override
    public String toString() {
        return String.format("%s - %d%n" +
                        "Route: %s%n" +
                        "Prize Pool: %d",
                this.getClass().getSimpleName(), length, route, prizePool);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Race race = (Race) o;
        return length == race.length && prizePool == race.prizePool
                && Objects.equals(route, race.route)
                && Objects.equals(participants, race.participants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, route, prizePool, participants);
    }

    // Геттеры и сеттеры
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public List<Car> getParticipants() {
        return participants;
    }

}