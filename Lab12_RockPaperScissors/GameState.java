
public class GameState {
    private int userScore;
    private int compScore;
    private Move userMove;
    private Move compMove;    

    public int getUserScore() {
        return this.userScore;
    }

    public void setUserScore(int userScore) throws GameStateException {
        this.userScore = userScore;
    }

    public int getCompScore() {
        return this.compScore;
    }

    public void setCompScore(int compScore) throws GameStateException {
        this.compScore = compScore;
    }

    public Move getUserMove() {
        return this.userMove;
    }

    public void setUserMove(Move userMove) throws GameStateException {
        this.userMove = userMove;
    }

    public Move getCompMove() {
        return this.compMove;
    }

    public void setCompMove(Move compMove) throws GameStateException {
        this.compMove = compMove;
    }

    public void selectUserMove() throws GameStateException {
        try {
            setUserMove(new Move(MoveSelector.selectMove()));
        } catch (NullPointerException message){
        }
        catch (NumberFormatException message){
        }
        catch (MoveException message){
        }
        catch (Exception message){
        }
    }

    public void selectCompMove() throws GameStateException {
        try {
            setCompMove(new Move(MoveSelector.selectMove()));
        } catch (NullPointerException message){
        }
        catch (NumberFormatException message){
        }
        catch (MoveException message){
        }
        catch (Exception message){
        }
    }

    public void compareMoves() throws GameStateException {
        try {
            int point = userMove.compare(compMove);
            setUserScore(point);
            setCompScore(point * -1);

        } catch (NullPointerException message){
        }
        catch (NumberFormatException message){
        }
        catch (MoveException message){
        }
        catch (Exception message){
        }
    }
}