import java.util.Random;

public class MemoryService {
	
	
	
	char[][] gameBoard;
	char[][] displayedGameBoard;
	char[] gameSymbols = {'!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '='};
	
	MemoryService(int inputBoardSize)
	{
		gameBoard = new char[inputBoardSize][inputBoardSize];
		RandomizeBoard();
		
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
				
				//This was my first go-through of switch/case before I realized the code I wrote was repetitive
				//so I just shortened it above. I'm not 100% certain if I'll need it yet, so I'm keeping it here
				//until final build
				/*
				switch(gameBoard.length)
				{
					case 2:
						addedNumber = false;
						while(!addedNumber)
						{
							randomNumber = random.nextInt(gameBoard.length);
							if(hasBeenUsed[randomNumber] < 2)
							{
								//System.out.println(randomNumber);
								randomChar = gameSymbols[randomNumber];
								hasBeenUsed[randomNumber]++;
								addedNumber = true;
							}
						}
						break;
					case 4:
						addedNumber = false;
						while(!addedNumber)
						{
							randomNumber = random.nextInt(gameBoard.length);
							if(hasBeenUsed[randomNumber] < 2)
							{
								randomChar = gameSymbols[randomNumber];
								hasBeenUsed[randomNumber]++;
								addedNumber = true;
							}
						}
						break;
					case 6:
						addedNumber = false;
						while(!addedNumber)
						{
							randomNumber = random.nextInt(gameBoard.length);
							if(hasBeenUsed[randomNumber] < 2)
							{
								randomChar = gameSymbols[randomNumber];
								hasBeenUsed[randomNumber]++;
								addedNumber = true;
							}
						}
						break;
				}*/
				System.out.print("[" + i + "]");
				System.out.print("[" + j + "] : ");
				System.out.println(randomChar);
				gameBoard[i][j]= randomChar;
			}
		}
	}
	
	//My toString override here is supposed to return the object in a nice preformatted grid setting
	//I used string builder, because when you do a String with multiple +, it tends to convert it to that anyway.
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(" ");
		for(int i = 0; i < gameBoard.length; i++)
		{
			int printI = i + 1;
			sb.append(" " + printI);
			
		}
		
		
		for(int i = 0; i < gameBoard.length; i++)
		{
			int printI = i + 1;
			sb.append("\n" + printI + " ");
			for(int j = 0; j < gameBoard[i].length; j++)
			{
				sb.append(gameBoard[i][j] + " ");	
			}
			sb.append("\n");
		}
		sb.append("\n\n");
		return sb.toString();
		
	}
	
	public void Reveal(int positionOne, int positionTwo)
	{
		
	}
	
	public void Hide(int positionOne, int positionTwo)
	{
		
	}
	
	public void Match(int positionOneX,int positionOneY,int positionTwoX,int positionTwoY)
	{
	
    }
	
	//This is just temporary for testing purposes.
	public static void main(String args[])
	{
		//Here is the object in question. If the arg passed is greater than 2, java loses its mind.
		//Before that, it works beautifully
		MemoryService ms = new MemoryService(4);
		System.out.println("\n\n\n" + ms);
		//System.out.println(ms.gameBoard[1][1]);
		
	}

}
