package homework017;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
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
}