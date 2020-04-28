import java.util.ArrayList;
import java.util.List;

public class Test {

    public static String runQuickTest() {
        StringBuilder testResults = new StringBuilder();

        //GameState Tests
        testResults.append("<<<<GameState Tests>>>>\n");
        testResults.append("    It Selects a random user move from the moves enum\n");
        testResults.append("    ------> " + it_selects_a_random_user_move_from_the_moves_enum() + "\n");
        testResults.append("    It Selects a random computer move from the moves enum\n");
        testResults.append("    ------> " + it_selects_a_random_comp_move_from_the_moves_enum() + "\n");
        testResults.append("    The points are adjusted properly for a user win\n");
        testResults.append("    ------> " + points_adjusted_for_user_win() + "\n");
        testResults.append("    The points are adjusted properly for a user lose\n");
        testResults.append("    ------> " + points_adjusted_for_user_lose() + "\n");
        testResults.append("    The points are adjusted properly for a user tie\n");
        testResults.append("    ------> " + points_adjusted_for_user_tie() + "\n");
        testResults.append("<<<<Move Tests>>>>\n");
        testResults.append("    Compare works for Rock move\n");
        testResults.append("    ------> " + rock_win_lose_tie() + "\n");
        testResults.append("    Compare works for Paper move\n");
        testResults.append("    ------> " + paper_win_lose_tie() + "\n");
        testResults.append("    Compare works for Scissors move\n");
        testResults.append("    ------> " + scissors_win_lose_tie() + "\n");
        testResults.append("<<<<MoveSelector Tests>>>>\n");
        testResults.append("    It doesnt create the same moves in order\n");
        testResults.append("    ------> " + it_doesnt_create_the_same_moves_in_order() + "\n");

        return testResults.toString();
    }

    private static String it_selects_a_random_user_move_from_the_moves_enum() {
        String result = "FAILED";
        for (int i = 0; i < 10; i++) {
            GameState gameState = new GameState();
            try {
                gameState.selectUserMove();
            } catch (NullPointerException message){
            }
            catch (NumberFormatException message){
            }
            catch (GameStateException message){
            }
            catch (Exception message){
            }

            for (MoveSelector.Moves move : MoveSelector.Moves.values()) {
                if (move.name().equals(gameState.getUserMove().getMoveName())) {
                    result = "PASSED";
                }
            }
        }
        return result;
    }

    private static String it_selects_a_random_comp_move_from_the_moves_enum() {
        String result = "FAILED";
        for (int i = 0; i < 10; i++) {
            GameState gameState = new GameState();
            try {
                gameState.selectCompMove();
            } catch (NullPointerException message){
            }
            catch (NumberFormatException message){
            }
            catch (GameStateException message){
            }
            catch (Exception message){
            }

            for (MoveSelector.Moves move : MoveSelector.Moves.values()) {
                if (move.name().equals(gameState.getCompMove().getMoveName())) {
                    result = "PASSED";
                }
            }
        }
        return result;
    }

    private static String rock_win_lose_tie() {
        try {
            Move userMove = new Move(MoveSelector.Moves.ROCK);
            Move compMove = new Move(MoveSelector.Moves.SCISSORS);
            int outcome = userMove.compare(compMove);

            if (outcome != 1) {
                return "FAILED @ win";
            }
            compMove = new Move(MoveSelector.Moves.PAPER);
            outcome = userMove.compare(compMove);
            if (outcome != -1) {
                return "FAILED @ lose";
            }
            compMove = new Move(MoveSelector.Moves.ROCK);
            outcome = userMove.compare(compMove);
            if (outcome != 0) {
                return "FAILED @ tie";
            }
            return "PASSED";
            
        } catch (NullPointerException message){
            return message.toString();
        }
        catch (NumberFormatException message){
            return message.toString();
        }
        catch (MoveException message){
            return message.toString();
        }
        catch (Exception message){
            return message.toString();
        }
    }

    private static String scissors_win_lose_tie() {
        try {
            Move userMove = new Move(MoveSelector.Moves.SCISSORS);
            Move compMove = new Move(MoveSelector.Moves.PAPER);
            int outcome = userMove.compare(compMove);

            if (outcome != 1) {
                return "FAILED @ win";
            }
            compMove = new Move(MoveSelector.Moves.ROCK);
            outcome = userMove.compare(compMove);
            if (outcome != -1) {
                return "FAILED @ lose";
            }
            compMove = new Move(MoveSelector.Moves.SCISSORS);
            outcome = userMove.compare(compMove);
            if (outcome != 0) {
                return "FAILED @ tie";
            }
            return "PASSED";
            
        } catch (NullPointerException message){
            return message.toString();
        }
        catch (NumberFormatException message){
            return message.toString();
        }
        catch (MoveException message){
            return message.toString();
        }
        catch (Exception message){
            return message.toString();
        }        
    }

    private static String paper_win_lose_tie() {
        try {
            Move userMove = new Move(MoveSelector.Moves.PAPER);
            Move compMove = new Move(MoveSelector.Moves.ROCK);
            int outcome = userMove.compare(compMove);

            if (outcome != 1) {
                return "FAILED @ win";
            }
            compMove = new Move(MoveSelector.Moves.SCISSORS);
            outcome = userMove.compare(compMove);
            if (outcome != -1) {
                return "FAILED @ lose";
            }
            compMove = new Move(MoveSelector.Moves.PAPER);
            outcome = userMove.compare(compMove);
            if (outcome != 0) {
                return "FAILED @ tie";
            }
            return "PASSED";
            
        } catch (NullPointerException message){
            return message.toString();
        }
        catch (NumberFormatException message){
            return message.toString();
        }
        catch (MoveException message){
            return message.toString();
        }
        catch (Exception message){
            return message.toString();
        } 
        
    }

    private static String points_adjusted_for_user_win() {
        GameState gameState = new GameState();

        try {
            gameState.setUserMove(new Move(MoveSelector.Moves.ROCK));
            gameState.setCompMove(new Move(MoveSelector.Moves.SCISSORS));
            gameState.compareMoves();

            if (gameState.getUserScore() == 1 && gameState.getCompScore() == -1) {
                return "PASSED";
            }
            return "FAILED";
        } catch (NullPointerException message){
            return message.toString();
        }
        catch (NumberFormatException message){
            return message.toString();
        }
        catch (GameStateException message){
            return message.toString();
        }
        catch (MoveException message){
            return message.toString();
        }
        catch (Exception message){
            return message.toString();
        }
    }

    private static String points_adjusted_for_user_lose() {
        GameState gameState = new GameState();

        try {
            gameState.setUserMove(new Move(MoveSelector.Moves.ROCK));
            gameState.setCompMove(new Move(MoveSelector.Moves.PAPER));
            gameState.compareMoves();

            if (gameState.getUserScore() == -1 && gameState.getCompScore() == 1) {
                return "PASSED";
            }
            return "FAILED";
        } catch (NullPointerException message){
            return message.toString();
        }
        catch (NumberFormatException message){
            return message.toString();
        }
        catch (GameStateException message){
            return message.toString();
        }
        catch (MoveException message){
            return message.toString();
        }
        catch (Exception message){
            return message.toString();
        }
    }

    private static String points_adjusted_for_user_tie() {
        GameState gameState = new GameState();

        try {
            gameState.setUserMove(new Move(MoveSelector.Moves.ROCK));
            gameState.setCompMove(new Move(MoveSelector.Moves.ROCK));
            gameState.compareMoves();

            if (gameState.getUserScore() == 0 && gameState.getCompScore() == 0) {
                return "PASSED";
            }
            return "FAILED";
        } catch (NullPointerException message){
            return message.toString();
        }
        catch (NumberFormatException message){
            return message.toString();
        }
        catch (GameStateException message){
            return message.toString();
        }
        catch (MoveException message){
            return message.toString();
        }
        catch (Exception message){
            return message.toString();
        }
    }

    private static String it_doesnt_create_the_same_moves_in_order() {
        List<MoveSelector.Moves> tableOne = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            tableOne.add(MoveSelector.selectMove());
        }
        List<MoveSelector.Moves> tableTwo = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            tableTwo.add(MoveSelector.selectMove());
        }

        if (!tableOne.equals(tableTwo)) {
            return "PASSED";
        }
        return "FAILED";
    }
}