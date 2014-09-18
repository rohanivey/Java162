import java.util.Random;

public class MemoryService {
	
	
	
	char[][] gameBoard;
	char[][] displayedGameBoard;
	char[] gameSymbols = {'!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '='};
	int matchesNeededToWin;
	
	MemoryService(int inputBoardSize)
	{
		gameBoard = new char[inputBoardSize][inputBoardSize];
		RandomizeBoard();
		displayedGameBoard = new char[inputBoardSize][inputBoardSize];
		displayedGameBoard = ObscureBoard(displayedGameBoard);
		matchesNeededToWin = inputBoardSize;
		
	}
	
	
	//This is the method to randomize the board. I have it set to print out the exact character and location
	//at time of assigning the character
	public void RandomizeBoard()
	{
		Random random = new Random();
		char randomChar = 'e';
		int [] hasBeenUsed = new int[gameSymbols.length * 2];
		int randomNumber;
		Boolean addedNumber = false;

		for(int i=0; i < gameBoard.length; i++)
		{
			for(int j=0; j < gameBoard[i].length; j++)
			{
				addedNumber = false;
				while(!addedNumber)
				{
					randomNumber = random.nextInt(gameBoard.length * 2);
					if(hasBeenUsed[randomNumber] < 2)
					{
						//System.out.println(randomNumber);
						randomChar = gameSymbols[randomNumber];
						hasBeenUsed[randomNumber]++;
						addedNumber = true;
					}
				}
				System.out.print("[" + i + "]");
				System.out.print("[" + j + "] : ");
				System.out.println(randomChar);
				gameBoard[i][j]= randomChar;
			}
		}
	}
	
	public char[][] ObscureBoard(char[][] boardToObscure)
	{
		char[][] tempObscureBoard = new char[boardToObscure.length][boardToObscure.length];
		for(int i = 0; i < boardToObscure.length; i++)
		{
			for(int j = 0; j < boardToObscure[i].length; j++)
			{
				tempObscureBoard[i][j] = '?';
			}
		}
		return tempObscureBoard;
	}
	
	//My toString override here is supposed to return the object in a nice preformatted grid setting
	//I used string builder, because when you do a String with multiple +, it tends to convert it to that anyway.
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(" ");
		for(int i = 0; i < displayedGameBoard.length; i++)
		{
			int printI = i + 1;
			sb.append(" " + printI);
			
		}
		
		
		for(int i = 0; i < displayedGameBoard.length; i++)
		{
			int printI = i + 1;
			sb.append("\n" + printI + " ");
			for(int j = 0; j < displayedGameBoard[i].length; j++)
			{
				sb.append(displayedGameBoard[i][j] + " ");	
			}
			sb.append("\n");
		}
		sb.append("\n\n");
		return sb.toString();
		
	}
	
	public void Match(int positionOneX,int positionOneY,int positionTwoX,int positionTwoY)
	{
		if(gameBoard[positionOneX][positionOneY] == gameBoard[positionTwoX][positionTwoY])
		{
			displayedGameBoard[positionOneX][positionOneY] = gameBoard[positionOneX][positionOneY];
			displayedGameBoard[positionTwoX][positionTwoY] = gameBoard[positionOneX][positionOneY];
			System.out.println("It's a match!\n");
			matchesNeededToWin -= 1;
			Draw();
			CheckWin();

		}
		else
		{
			System.out.println("Sorry, no match.\n");
			Draw();
		}
    }
	public void Draw()
	{
		System.out.println(this);
	}
	
	public void CheckWin()
	{
		if(matchesNeededToWin == 0)
		{
			System.out.println("YOU WON!");
			
		}
	}
	
	
	//This is just temporary for testing purposes.
	public static void main(String args[])
	{
		//Here is the object in question. If the arg passed is greater than 2, java loses its mind.
		//Before that, it works beautifully
		MemoryService ms = new MemoryService(2);
		System.out.println("\n\n\n" + ms);
		ms.Match(1, 0, 1, 1);
		ms.Match(0, 0, 0, 1);
		
	}

}
