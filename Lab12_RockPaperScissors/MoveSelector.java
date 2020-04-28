import java.util.Random;

public class MoveSelector {

    public static enum Moves {
        ROCK(1),
        PAPER(2),
        SCISSORS(3);
        private int value;

        private Moves(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    } 

    public static Moves selectMove() {
        int rnd = new Random().nextInt(Moves.values().length);
        return Moves.values()[rnd];
    }
}