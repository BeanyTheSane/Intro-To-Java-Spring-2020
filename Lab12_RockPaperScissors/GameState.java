
public class GameState {
    private Integer userScore = 0;
    private Integer compScore = 0;
    private Move userMove;
    private Move compMove;    

    public Integer getUserScore() {
        return this.userScore;
    }

    public void setUserScore(int userScore) throws GameStateException {
        this.userScore = userScore;
    }

    public Integer getCompScore() {
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

    public int selectUserMove() throws GameStateException {
        try {
            setUserMove(new Move(MoveSelector.selectMove()));
            return userMove.getMoveValue();
        } catch (NullPointerException message){
        }
        catch (NumberFormatException message){
        }
        catch (MoveException message){
        }
        catch (Exception message){
        }
        return -2;
    }

    public int selectCompMove() throws GameStateException {
        try {
            setCompMove(new Move(MoveSelector.selectMove()));
            return compMove.getMoveValue();
        } catch (NullPointerException message){
        }
        catch (NumberFormatException message){
        }
        catch (MoveException message){
        }
        catch (Exception message){
        }
        return -2;
    }

    public int compareMoves() throws GameStateException {
        try {
            int point = userMove.compare(compMove);
            if (point == 1) {
                setUserScore(getUserScore() + 1);
            } else if (point == -1) {
                setCompScore(getCompScore() + 1);
            }
            return point;

        } catch (NullPointerException message){
        }
        catch (NumberFormatException message){
        }
        catch (MoveException message){
        }
        catch (Exception message){
        }
        return -2;
    }
}