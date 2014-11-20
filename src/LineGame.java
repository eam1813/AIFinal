import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by matt on 11/20/2014.
 */
public class LineGame {

    private ArrayList<char[]> rows;

    public LineGame(int sizeOfGame) {
        rows = new ArrayList<char[]>();
        for(int i = 1; i <= sizeOfGame; i++) {
            char[] temp = new char[i];
            for(int k = 0; k < temp.length; k++) {
                temp[k] = '|';
            }
            rows.add(temp);
        }
    }

    public ArrayList<char[]> getRows() {
        return rows;
    }

    /**
     * cross off the lines you want. can't cross lines in different rows
     * or cross lines that have already been crossed.
     * @param row the row to cross lines from
     * @param start the first one to cross off
     * @param stop the last one to cross off
     */
    public void crossLine(int row, int start, int stop) {
        for(int i = start; i <= stop ; i++) {
            rows.get(row)[i] = '+';
        }
    }

    public void printGame() {
        for(int i = 0; i < rows.size(); i++) {
            System.out.print(rows.get(i));
            System.out.println();
        }
    }

    public boolean gameOver() {
        for(int i = 0; i < rows.size(); i++) {
            for(int l = 0; l < rows.get(i).length; l++) {
                if(rows.get(i)[l] == '|') {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LineGame temp = new LineGame(4);
        boolean gameNotOver = true;
        Scanner key = new Scanner(System.in);
        while(gameNotOver) {
            int row;
            int start;
            int stop;
            temp.printGame();
            System.out.println();
            System.out.println("Enter The Row you want to cross off");
            row = key.nextInt();
            System.out.println();;
            System.out.println("Enter the line you want to start at");
            start = key.nextInt();
            System.out.println();
            System.out.println("Enter the Line you want to stop at");
            stop = key.nextInt();
            System.out.println();
            temp.crossLine(row, start , stop);
            gameNotOver = temp.gameOver();
        }
    }
}
