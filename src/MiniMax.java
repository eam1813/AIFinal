import java.util.ArrayList;

/**
 * Created by matt on 12/8/2014.
 */
public class MiniMax {

    private LineGame game;

    public MiniMax(LineGame game) {
        this.game = game;
    }

    public int staticEvaluator() {
        return 0;
    }

    public ArrayList<int[]> getValidMoves(int row) {
        return game.getValidMovesPerRow(row);
    }

    public void play() {
        
    }

}
