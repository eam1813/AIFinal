import java.util.ArrayList;
import java.util.Random;

/**
 * Created by matt on 12/8/2014.
 */
public class RandomPlayer {

    private Random rnd;
    private LineGame game;

    public RandomPlayer(LineGame game) {
        this.game = game;
        this.rnd = new Random(System.nanoTime());
    }

    public ArrayList<int[]> getValidMoves(int row) {
        return game.getValidMovesPerRow(row);
    }

    public void play() {
        int row = rnd.nextInt(this.game.getRows().size());
        ArrayList<int[]> temp = this.getValidMoves(row);
        int number = rnd.nextInt(temp.size());
        int[] startStop = temp.get(number);
        game.crossLine(row ,startStop[0]+1, startStop[1]+1);
    }
}
