package homework017;

public class DragRace extends Race {

    public DragRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\nParticipants by engine performance:\n");
        getParticipants().sort((c1, c2) -> Integer.compare(c2.getHorsepower(), c1.getHorsepower()));
        for (Car participant : getParticipants()) {
            sb.append(participant.toString()).append("\n");
            sb.append("Engine Performance: ").append(participant.getHorsepower()).append("\n");
        }
        return sb.toString();
    }
}