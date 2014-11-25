import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by matt on 11/20/2014.
 * implementation of the line game
 * prints out everything to std out.
 */
public class LineGame {

    private ArrayList<char[]> rows;
    private int player;

    public LineGame(int sizeOfGame) {
        rows = new ArrayList<char[]>();
        int rowSize = 1;
        for(int i = 1; i <= sizeOfGame; i++) {
            char[] temp = new char[rowSize];
            for(int k = 0; k < temp.length; k++) {
                temp[k] = '|';
            }
            rows.add(temp);
            rowSize += 2;
        }
        this.player = 1;
    }

    /**
     * returns arraylist of char arrays containing the lines
     * @return array list of char arrays
     */
    public ArrayList<char[]> getRows() {
        return rows;
    }


    /**
     * checks if the move is valid
     * @param row the row to cross off
     * @param start the first one to start crossing at
     * @param stop the last one to cross off
     * @return
     */
    public boolean isValidMove(int row, int start, int stop) {
        for(int k = start; k < stop; k++) {
            if(rows.get(row)[k] == '+') {
                System.out.println("Invalid Move!");
                return false;
            }
        }
        return true;
    }

    /**
     * cross off the lines you want. can't cross lines in different rows
     * or cross lines that have already been crossed.
     * @param row the row to cross lines from
     * @param start the first one to cross off
     * @param stop the last one to cross off
     */
    public boolean crossLine(int row, int start, int stop) {
        if(this.isValidMove(row, start, stop)) {
            for (int i = start; i <= stop; i++) {
                rows.get(row)[i] = '+';
            }
            if (this.player == 1) {
                this.player = 2;
            } else {
                this.player = 1;
            }
            return true;
        } else {
            System.out.println("Invalid move");
            return false;
        }
    }

    /**
     * prints game out to standard out
     */
    public void printGame() {
        for(int i = 0; i < rows.size(); i++) {
            System.out.print(rows.get(i));
            System.out.println();
        }
    }

    /**
     * Checks if all lines are crossed off
     * @return true if the game is not over false otherwise
     */
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

    /**
     * makes sure all the rows and the start and stop are valid indexes
     * @param key scanner to get input from standard in
     * @param gameSize size of the game or number of rows
     */
    public void play(Scanner key, int gameSize) {
        System.out.println();
        boolean isValid = true;
        int row = 0;
        int start = 0;
        int stop = 0;
        while(isValid) {
            System.out.println("Enter the row you want to cross off");
            row = key.nextInt() - 1;
            if (!(row >= 0 && row < gameSize)) {
                System.out.println("That is not a valid row! Try Again!");
            } else {
                isValid = false;
            }
        }

        isValid = true;
        while(isValid) {
            System.out.println("Enter were you want to start crossing");
            start = key.nextInt() - 1;
            if (!(start >= 0 && start < rows.get(row).length)) {
                System.out.println("That is not a valid start! Try Again!");
            } else {
                isValid = false;
            }
        }

        isValid = true;
        while(isValid) {
            System.out.println("Enter were you want to stop crossing");
            stop = key.nextInt() - 1;
            if (!(stop >= 0 && row < rows.get(row).length)) {
                System.out.println("That is not a valid stop! Try Again!");
            } else {
                isValid = false;
            }
        }
        if(this.crossLine(row, start, stop)) {
            this.play(key, gameSize);
        }

    }

    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        System.out.println("Enter size of game. Standard is 4.");
        int gameSize = key.nextInt();
        System.out.println();
        LineGame temp = new LineGame(gameSize);
        boolean gameNotOver = true;
        while(gameNotOver) {
            temp.printGame();
            temp.play(key, gameSize);
            gameNotOver = temp.gameOver();
        }
        System.out.println();
        temp.printGame();
        System.out.println("Game OVER!!!");
        key.close();
    }
}
