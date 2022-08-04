import java.util.Scanner;

public class

Main
{
    private static String winner = "Nobody";
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board[][] = new String [ROW][COL];

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int rowMove = 0;
        int colMove = 0;
        String player = "X";
        boolean validMove = false;
        int tie = 0;

        do{
            clearBoard();
            tie = 0;
            display();
            do
            {
                do{
                    System.out.println(player + "'s turn!");
                    rowMove = SafeInput.getRangedInt(in, "Enter the row you would like to move in", 1, 3);
                    rowMove = rowMove - 1;
                    colMove = SafeInput.getRangedInt(in, "Enter the column you would like to move in", 1, 3);
                    colMove = colMove - 1;
                    validMove = isValidMove(rowMove,colMove);
                }while(!validMove);

                board[rowMove][colMove] = player;
                tie++;
                display();

                if(tie == 9)
                {
                    break;
                }

                if(player.equals("X"))
                {
                    player = "O";
                }
                else
                {
                    player = "X";
                }
            } while(!isWin() /*&& !isTie()*/);
            if(winner.equalsIgnoreCase("Nobody"))
            {
                System.out.println("It's a tie!");
            }
            System.out.println(winner + " Wins!");
        }while(playAgain());

        System.out.println("Thanks for Playing!");

    }

    private static void clearBoard()
    {
        for(int row = 0; row < ROW; row++)
        {
            for(int col = 0; col < COL; col++)
            {
                board[row][col] = " ";
            }
        }
    }

    private static void display()
    {
        System.out.println(" -------------");
        for(int row = 0; row < ROW; row++)
        {
            System.out.print(" | ");
            for(int col = 0; col < COL; col++)
            {
                System.out.print(board[row][col]);
                System.out.print(" | ");
            }
            System.out.println("\n -------------");
        }
    }

    private static boolean isValidMove(int row, int col)
    {
        if(board[row][col].equalsIgnoreCase("X") || board[row][col].equalsIgnoreCase("O"))
        {
            System.out.println("This space has already been taken! \nPlease select a new space.");
            return false;
        }
        return true;
    }

    private static boolean isWin()
    {
        if(isColWin() || isRowWin() || isDiagWin())
        {
            return true;
        }
        return false;
    }

    private static boolean isColWin()
    {
        for(int col = 0; col < COL; col++)
        {
            if(board[0][col].equals("X") && board[1][col].equals("X") && board[2][col].equals("X"))
            {
                winner = "X";
                return true;
            }
            else if(board[0][col].equals("O") && board[1][col].equals("O") && board[2][col].equals("O"))
            {
                winner = "O";
                return true;
            }
        }
        return false;
    }

    private static boolean isRowWin()
    {
        for(int row = 0; row < ROW; row++)
        {
            if(board[row][0].equals("X") && board[row][1].equals("X") && board[row][2].equals("X"))
            {
                winner = "X";
                return true;
            }
            else if(board[row][0].equals("O") && board[row][1].equals("O") && board[row][2].equals("O"))
            {
                winner = "O";
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagWin()
    {
        if(board[0][0].equals("X") && board[1][1].equals("X") && board[2][2].equals("X"))
        {
            winner = "X";
            return true;
        }
        else if(board[0][2].equals("X") && board[1][1].equals("X") && board[2][0].equals("X"))
        {
            winner = "X";
            return true;
        }
        else if(board[0][0].equals("O") && board[1][1].equals("O") && board[2][2].equals("O"))
        {
            winner = "O";
            return true;
        }
        else if(board[0][2].equals("O") && board[1][1].equals("O") && board[2][0].equals("O"))
        {
            winner = "O";
            return true;
        }
        else
        {
            return false;
        }
    }

    private static boolean isTie()
    {
        if(winner.equalsIgnoreCase("nobody"))
        {
            return true;
        }
        return false;
    }

    private static boolean playAgain()
    {
        Scanner in = new Scanner(System.in);
        boolean playAgain = SafeInput.getYNConfirm(in, "Would you like to play again?");
        return playAgain;
    }

}

