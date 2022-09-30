package codewars.oop.RPSKnockoutTournamentWinner;

import java.util.Random;

public class Player implements RockPaperScissorsPlayer {
    private Random random;

    public Player() {
        random = new Random();
    }

    @Override
    public String getName() {
        return "MyPlayer";
    }

    @Override
    public void setNewMatch(String opponentName) {
    }

    @Override
    public String getShape() {
        switch (random.nextInt(3)) {
            case 1:
                return "P";
            case 2:
                return "R";
            default:
                return "S";
        }
    }

    @Override
    public void setOpponentShape(String shape) {
    }
}
