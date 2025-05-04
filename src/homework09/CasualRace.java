package homework09;

public class CasualRace extends Race {
    public CasualRace() {
    }

    public CasualRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\nParticipants:\n");
        for (Car participant : getParticipants()) {
            sb.append(participant.toString()).append("\n");
        }
        return sb.toString();
    }
}