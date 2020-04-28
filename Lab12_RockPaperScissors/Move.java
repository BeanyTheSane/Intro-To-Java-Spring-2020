public class Move {
    private String moveName;
    private int moveValue;

    public Move(MoveSelector.Moves move) throws MoveException {
        this.moveName = move.toString();
        this.moveValue = move.getValue();
    }

    public String getMoveName() {
        return this.moveName;
    }

    public int getMoveValue() {
        return this.moveValue;
    }

    // returns a 1 if this move wins
    // returns a 0 if this move ties
    // returns a -1 if this move loses
    public int compare(Move comparedMove) throws MoveException {
        switch (moveName) {
            case "ROCK":
                return comparedMove.getMoveName().equalsIgnoreCase("PAPER")
                    ? -1
                    : comparedMove.getMoveName().equalsIgnoreCase("SCISSORS")
                    ? 1
                    : 0;
            case "PAPER":
            return comparedMove.getMoveName().equalsIgnoreCase("SCISSORS")
                ? -1
                : comparedMove.getMoveName().equalsIgnoreCase("ROCK")
                ? 1
                : 0;
            case "SCISSORS":
            return comparedMove.getMoveName().equalsIgnoreCase("ROCK")
                ? -1
                : comparedMove.getMoveName().equalsIgnoreCase("PAPER")
                ? 1
                : 0;
        
            default:
                break;
        }
        return 0;
    }
}