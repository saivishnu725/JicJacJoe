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

    public static void main(String[] args) throws IOException {
        // input bs
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader read = new BufferedReader(reader);
        // ask for clear screen or continue
        boolean clearScreen = false;
        // current player: X or Y
        String current = "X";
        // input var
        String input = "";
        // score for p1 and p2
        int score[] = { 0, 0 };
        // visuals of the board on screen
        // store separately for easy checking
        int values[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        

    public static void clearScreen() {
        System.out.println("\033[H\033[2J");
    }

    public static void printBoard() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}