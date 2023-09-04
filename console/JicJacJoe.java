import java.io.*;

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

    public static void main(String[] args) throws IOException {
        // input bs
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader read = new BufferedReader(reader);
        // ask for clear screen or continue
        boolean clearScreen = false;

        // input var
        String input = "";
        // score for p1 and p2
        int score[] = { 0, 0 };
        // visuals of the board on screen
        // store separately for easy checking
        int values[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

        clearScreen();
        printBoard();
        System.out.print(" Choose a position(1-9, Q/q to exit):  ");
        input = read.readLine();

        while (true) {

            switch (input) {
                case "1":
                    if (board[1][1].equals("1"))
                        board[1][1] = current;
                    if (current.equals("X"))
                        values[1] = 1;
                    else
                        values[1] = 2;
                    break;
                case "2":
                    if (board[1][3].equals("2"))
                        board[1][3] = current;
                    if (current.equals("X"))
                        values[2] = 1;
                    else
                        values[2] = 2;
                    break;
                case "3":
                    if (board[1][5].equals("3"))
                        board[1][5] = current;
                    if (current.equals("X"))
                        values[3] = 1;
                    else
                        values[3] = 2;
                    break;
                case "4":
                    if (board[3][1].equals("4"))
                        board[3][1] = current;
                    if (current.equals("X"))
                        values[4] = 1;
                    else
                        values[4] = 2;
                    break;
                case "5":
                    if (board[3][3].equals("5"))
                        board[3][3] = current;
                    if (current.equals("X"))
                        values[5] = 1;
                    else
                        values[5] = 2;
                    break;
                case "6":
                    if (board[3][5].equals("6"))
                        board[3][5] = current;
                    if (current.equals("X"))
                        values[6] = 1;
                    else
                        values[6] = 2;
                    break;
                case "7":
                    if (board[5][1].equals("7"))
                        board[5][1] = current;
                    if (current.equals("X"))
                        values[7] = 1;
                    else
                        values[7] = 2;
                    break;
                case "8":
                    if (board[5][3].equals("8"))
                        board[5][3] = current;
                    if (current.equals("X"))
                        values[8] = 1;
                    else
                        values[8] = 2;
                    break;
                case "9":
                    if (board[5][5].equals("9"))
                        board[5][5] = current;
                    if (current.equals("X"))
                        values[9] = 1;
                    else
                        values[9] = 2;
                    break;
                case "Q":
                case "q":
                    // showScore();
                    return;
                default:
                    System.out.println(" Invalid input. Try again! ");

            }

            clearScreen();
            printBoard();
            System.out.print(" Choose a position(1-9, Q/q to exit):  ");
            input = read.readLine();

        }
    }

    public static void clearScreen() {
        System.out.println("\033[H\033[2J");
    }

    public static void printBoard() {
        clearScreen();

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}