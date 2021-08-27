import java.util.*;
    public class simpleXOGame {
        public static void main(String args[]) {
            Scanner in = new Scanner(System.in);
            String[][] boardGame = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
            int count = 0;
            while(true) {
                Scanner input1 = new Scanner(input(in, boardGame, 1));
                boardGame[input1.nextInt() - 1][input1.nextInt() - 1] = "X";
                input1.close();
                count++;
                
                showBoard(boardGame);
                
                if(count == 9 && !checkWinner(boardGame)) {
                    System.out.println("Draw!!");
                    break;
                }
                if(checkWinner(boardGame)) {
                    System.out.println("Player 1 win!");
                    break;
                }
                                        
                Scanner input2 = new Scanner(input(in, boardGame, 2));
                boardGame[input2.nextInt() - 1][input2.nextInt() - 1] = "O";
                input2.close();
                count++;
                
                showBoard(boardGame);
                        
                
                if(checkWinner(boardGame)) {
                    System.out.println("Player 2 win!");
                    break;
                }
                
            }
            in.close();
        }

        public static boolean checkWinner(String[][] boardGame) {
            for(int n = 0; n < boardGame.length; n++) {
                if((boardGame[n][0] == "X" && boardGame[n][1] == "X" && boardGame[n][2] == "X") || 
                (boardGame[n][0] == "O" && boardGame[n][1] == "O" && boardGame[n][2] == "O"))
                    return true;				
            }
            for(int n = 0; n < boardGame.length; n++) {
                if((boardGame[0][n] == "X" && boardGame[1][n] == "X" && boardGame[2][n] == "X") || 
                (boardGame[0][n] == "O" && boardGame[1][n] == "O" && boardGame[2][n] == "O"))
                    return true		;		
            }
                if((boardGame[0][0] == "X" && boardGame[1][1] == "X" && boardGame[2][2] == "X") || 
                (boardGame[0][0] == "O" && boardGame[1][1] == "O" && boardGame[2][2] == "O"))
                    return true;
                if((boardGame[0][2] == "X" && boardGame[1][1] == "X" && boardGame[2][0] == "X") || 
                (boardGame[0][2] == "O" && boardGame[1][1] == "O" && boardGame[2][0] == "O"))
                    return true;
                return false;
        }

        public static String input(Scanner in, String[][] boardGame, int player) {
            boolean bool = true;
            int posRow = 0, posColumn = 0;
            showBoard(boardGame);
            while(bool) {
                System.out.print("Player" + player + " input row and column : ");
                posRow = in.nextInt();
                while(true) {
                    if(posRow > 3 || posRow < 1) {
                        System.out.println("Invalid, Try Agin!!");
                        in.nextLine();
                        posRow = in.nextInt();
                    } else 
                        break;			
                }
                posColumn = in.nextInt();
                while(true) {
                    if(posColumn > 3 || posColumn < 1) {
                        System.out.println("Invalid, Try Agin!!");
                        in.nextLine();
                        posColumn = in.nextInt();
                    } else 
                        break;			
                }
                if(boardGame[posRow - 1][posColumn - 1] == " ")
                    bool = false;
            }	
            return posRow +" " + posColumn;
        }
        public static void showBoard(String[][] boardGame) {
            System.out.println(boardGame[0][0] + "|" + boardGame[0][1] + "|" + boardGame[0][2]);
            System.out.println("-+-+-");
            System.out.println(boardGame[1][0] + "|" + boardGame[1][1] + "|" + boardGame[1][2]);
            System.out.println("-+-+-");
            System.out.println(boardGame[2][0] + "|" + boardGame[2][1] + "|" + boardGame[2][2]);
        }
    }