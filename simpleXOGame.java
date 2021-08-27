import java.util.Arrays;
import java.util.Scanner;
import java.util.*;

public class simpleXOGame {
    public static int n;
    public static String[][] boardGame;
    public static int count = 0;

    public static void main(String[] agrs) {
        sizeBoard();
        Scanner in = new Scanner(System.in);
        while (true) {
            Scanner input1 = new Scanner(input(in, boardGame, 1));
            boardGame[input1.nextInt() - 1][input1.nextInt() - 1] = "X";
            input1.close();
            count++;
            showBoard();

            if (count == 9 && !checkWinner(boardGame)) {
                System.out.println("Draw!!");
                break;
            }
            if (checkWinner(boardGame)) {
                System.out.println("Player 1 win!");
                break;
            }
            Scanner input2 = new Scanner(input(in, boardGame, 2));
            boardGame[input2.nextInt() - 1][input2.nextInt() - 1] = "O";
            input2.close();
            count++;
            showBoard();

            if (checkWinner(boardGame)) {
                System.out.println("Player 2 win!");
                break;
            }
        }
        in.close();
    }

    public static boolean checkWinner(String[][] boardGame) {
        for (int n = 0; n < boardGame.length; n++) {
            if ((boardGame[n][n] == "X" && boardGame[n][1] == "X" && boardGame[n][2] == "X")
                    || (boardGame[n][0] == "O" && boardGame[n][1] == "O" && boardGame[n][2] == "O"))
                return true;
        }
        for (int n = 0; n < boardGame.length; n++) {
            if ((boardGame[0][n] == "X" && boardGame[1][n] == "X" && boardGame[2][n] == "X")
                    || (boardGame[0][n] == "O" && boardGame[1][n] == "O" && boardGame[2][n] == "O"))
                return true;
        }
    }

    public static String input(Scanner in, String[][] boardGame, int player) {
        boolean bool = true;
        int posRow = 0, posColumn = 0;
        showBoard();
        while (bool) {
            System.out.print("Player" + player + " input row and column : ");
            posRow = in.nextInt();
            while (true) {
                if (posRow > 3 || posRow < 1) {
                    System.out.println("Invalid, Try Agin!!");
                    in.nextLine();
                    posRow = in.nextInt();
                } else
                    break;
            }
            posColumn = in.nextInt();
            while (true) {
                if (posColumn > 3 || posColumn < 1) {
                    System.out.println("Invalid, Try Agin!!");
                    in.nextLine();
                    posColumn = in.nextInt();
                } else
                    break;
            }
            if (boardGame[posRow - 1][posColumn - 1] == " ")
                bool = false;
        }
        return posRow + " " + posColumn;
    }

    public static void sizeBoard() {
        Scanner inputN = new Scanner(System.in);
        System.out.print("input n (n*n): ");
        n = inputN.nextInt();
        boardGame = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boardGame[i][j] = String.valueOf(i) + String.valueOf(j);
            }
        }
    }

    public static void showBoard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("|" + boardGame[i][j] + "" + "|");
            }
            System.out.println("\n");
        }
    }
}
