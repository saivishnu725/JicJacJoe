import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JicJacJoe {
    static String[][] board = {
            { "|", "-", "-", "-", "-", "-", "|" },
            { "|", "1", "|", "2", "|", "3", "|" },
            { "|", "-", "|", "-", "|", "-", "|" },
            { "|", "4", "|", "5", "|", "6", "|" },
            { "|", "-", "|", "-", "|", "-", "|" },
            { "|", "7", "|", "8", "|", "9", "|" },
            { "|", "-", "-", "-", "-", "-", "|" },
    };

    // current player: X or Y
    static String current = "X";

    // visuals of the board on screen
    // store separately for easy checking
    static int[] values = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

    // as for clear screen
    static boolean clear = false;

    // invalid input
    static boolean invalidInput = false;

    // score for p1 and p2
    static int[] score = { 0, 0 };

    static boolean won = false;

    public static void main(String[] args) throws IOException {

        // input bs
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader read = new BufferedReader(reader);

        // input var
        String input = "";

        // ask for clearing screen
        System.out.print("Do yo want to clear screen every attempt?(Y/N): ");
        if (read.readLine().equalsIgnoreCase("y"))
            clear = true;

        // first time
        printBoard();
        input = read.readLine();

        while (true) {

            switch (input) {
                case "1":
                    switching("1", 1, 1);
                    break;
                case "2":
                    switching("2", 1, 3);
                    break;
                case "3":
                    switching("3", 1, 5);
                    break;
                case "4":
                    switching("4", 3, 1);
                    break;
                case "5":
                    switching("5", 3, 3);
                    break;
                case "6":
                    switching("6", 3, 5);
                    break;
                case "7":
                    switching("7", 5, 1);
                    break;
                case "8":
                    switching("8", 5, 3);
                    break;
                case "9":
                    switching("9", 5, 5);
                    break;
                case "Q":
                case "q":
                    // showScore();
                    return;
                default:
                    System.out.println(" Invalid input. Try again! ");

            }

            if (logic()) {
                System.out.println("Exiting...");
                break;
            }
            printBoard();
            input = read.readLine();

        }
    }

    private static void switching(String input, int row, int col) {
        if (board[row][col].equals(input)) {
            board[row][col] = current;
            if (current.equals("X")) {
                values[Integer.parseInt(input)] = 1;
                current = "O";
            } else {
                values[Integer.parseInt(input)] = 2;
                current = "X";
            }
            invalidInput = false;
        } else {
            invalidInput = true;
        }
    }

    private static boolean logic() {
        for (int i = 1; i < 10; i++) {
            System.out.print(values[i] + " ");
        }

        // int[][] possibilities = {
        // { 1, 5, 9 },
        // { 7, 5, 3 },
        // { 1, 2, 3 },
        // { 4, 5, 6 },
        // { 7, 8, 9 },
        // { 1, 4, 7 },
        // { 2, 5, 8 },
        // { 3, 6, 9 }
        // };

        // for (int i = 0; i < 8; i++) {

        // int curr = current.equals("X") ? 1 : 2;
        // int pos1 = values[possibilities[i][0]];
        // int pos2 = values[possibilities[i][1]];
        // int pos3 = values[possibilities[i][2]];
        // if (pos1 == curr &&
        // pos2 == curr &&
        // pos3 == curr)
        // System.out.println("hello");

        // score[0]++;
        // win
        // }

        // diagonal
        if ((values[0] == values[5] && values[0] == values[9]) || (values[3] == values[5] && values[3] == values[7])) {
            won = true;
        } else {
            // horizontal
            for (int i = 1; i < 9; i += 3) {
                if ((values[i] == values[i + 1] && values[i] == values[i + 2])){
                    System.out.println("True 1");
                    return true;
                    
                }
            }
            // vertical
            for (int i = 1; i < 3; i++) {
                if ((values[i] == values[i + 3] && values[i] == values[i + 6])){
                    System.out.println("true 2");
                    return true;
                }
            }
        }
        return false;
    }

    private static void clearScreen() {
        System.out.println("\033[H\033[2J");
    }

    private static void printBoard() {
        if (clear)
            clearScreen();

        System.out.println("\t\t Score");
        System.out.println("Player 1: " + score[0] + "\t\t\t Player 2:" + score[1] + "\n\n");
        System.out.println("Player " + current + " turn!!");

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        if (invalidInput)
            System.out.println("Box already filled. Choose a different box.");
        System.out.print(" Choose a position(1-9 | Q/q to exit):  ");
    }
}