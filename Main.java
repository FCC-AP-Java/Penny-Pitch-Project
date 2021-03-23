import java.util.Scanner;

class Main {
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);
    Square[][] gameBoard = new Square[5][5];
    // For loop to create game board with specific values
    for (int i = 0; i < gameBoard.length; i++)
    {
      for (int j = 0; j < gameBoard[0].length; j++)
      {
        if (i == 0 || i == 4 || j == 0 || j == 4)
        {
          gameBoard[i][j] = new Square(1);
        }
        else if (i == 1 || i == 3 || j == 1 || j == 3)
        {
          gameBoard[i][j] = new Square(2);
        }
        else if (i == 2 && j == 2)
        {
          gameBoard[i][j] = new Square(3);
        }
      }
    }
    
    boolean continueGame = true;
    while (continueGame)
    {
      int sum = 0;
      System.out.println("How many pennies would you like to throw? (1-25)");
      int numPennies = input.nextInt();
      boolean checkBounds = (numPennies >= 1 && numPennies <= 25)
      while (!checkBounds)
      {
        System.out.println("You entered an out of bounds number. Please try again.");
        numPennies = input.nextInt();
      }
      for (int i = 0; i < numPennies; i++)
      {
        int hitValue = gameBoard[(int)(Math.random() * 5)][(int)(Math.random() * 5)].hit();
        if (hitValue != 0)
        {
          sum += hitValue;
        }
        else
        {
          numPennies++;
        }
        // Prints out board, replaces hit values with "P"
        for (int k = 0; k < gameBoard.length; k++)
        {
          for (int l = 0; l < gameBoard[0].length; l++)
          {
            if (gameBoard[k][l].getValue() == 0)
            {
              System.out.print("P ");
            }
            else
            {
              System.out.print(gameBoard[k][l].getValue() + " ");
            }
          }
          System.out.println("");
        }
        System.out.println("The current board has been displayed. Your current score is " + sum + ". Please press enter to continue.");
        input.nextLine();
      }
      System.out.println("Your final score was " + sum + ".");
      System.out.println("Would you like to play again? (YES/NO)");
      continueGame = (input.nextLine().toLowerCase().equals("yes"));
    }
  }
}