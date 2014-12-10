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
        int row = 0;
        ArrayList<int[]> temp = new ArrayList<int[]>();
        while(temp.size() == 0) {
            row = rnd.nextInt(this.game.getRows().size());
            temp = this.getValidMoves(row);
        }
        int number = rnd.nextInt(temp.size());
        int[] startStop = temp.get(number);
        game.crossLine(row, startStop[0], startStop[1]);
    }
}
