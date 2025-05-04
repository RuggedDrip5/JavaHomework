package homework09;

public class DriftRace extends Race {
    public DriftRace() {
    }

    public DriftRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\nParticipants by suspension performance:\n");
        getParticipants().sort((c1, c2) -> Integer.compare(c2.getSuspension(), c1.getSuspension()));
        for (Car participant : getParticipants()) {
            sb.append(participant.toString()).append("\n");
            sb.append("Suspension Performance: ").append(participant.getSuspension()).append("\n");
        }
        return sb.toString();
    }
}