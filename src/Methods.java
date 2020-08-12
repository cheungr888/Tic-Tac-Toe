import java.util.*;

public class Methods {
	public static void printBoard(char[][] gameBoard)
	{
		for(char[] row: gameBoard)
		{
			for(char column : row)
			{
				System.out.print(column);
			}
			System.out.println(); //make next column be printed below
		}
	}
	
	public static void pickASpotNext(char[][] gameBoard, int pos, String player, ArrayList<Integer> playerPositions, ArrayList<Integer> cpuPositions)
	{
		char symbol = 'X';
		
		if(player.equals("Player"))
		{
			symbol = 'X';
			playerPositions.add(pos);
		}
		else if (player.equals("CPU"))
		{
			symbol = 'O';
			cpuPositions.add(pos);
		}
		
		switch(pos)
		{
			case 1: 
				gameBoard[0][0] = symbol;
				break;
			case 2: 
				gameBoard[0][2] = symbol;
				break;
			case 3: 
				gameBoard[0][4] = symbol;
				break;
			case 4: 
				gameBoard[2][0] = symbol;
				break;
			case 5: 
				gameBoard[2][2] = symbol;
				break;
			case 6: 
				gameBoard[2][4] = symbol;
				break;
			case 7: 
				gameBoard[4][0] = symbol;
				break;
			case 8: 
				gameBoard[4][2] = symbol;
				break;
			case 9: 
				gameBoard[4][4] = symbol;
				break;
			default:
				break;
		}
		printBoard(gameBoard);
	}
	
	public static void cpuPickASpotNext(char[][] gameBoard, ArrayList<Integer> playerPositions, ArrayList<Integer> cpuPositions)
	{
		Random rndmMove = new Random();
		int rndmPickedPos = rndmMove.nextInt(9) + 1;
		System.out.println("This position was picked on the board by the CPU: "+ rndmPickedPos);
		pickASpotNext(gameBoard, rndmPickedPos, "CPU", playerPositions, cpuPositions);
		
		while(playerPositions.contains(rndmPickedPos) || cpuPositions.contains(rndmPickedPos))
		{
			System.out.println("Position taken, try again CPU");
			rndmPickedPos = rndmMove.nextInt(9) + 1;
		}
		printBoard(gameBoard);
		checkForWinner(playerPositions, cpuPositions);
	}
	
	public static String checkForWinner(ArrayList<Integer> playerPositions, ArrayList<Integer> cpuPositions)
	{
		List topRow = Arrays.asList(1,2,3);
		List midRow = Arrays.asList(4,5,6);
		List botRow = Arrays.asList(7,8,9);
		
		List leftCol = Arrays.asList(1,4,7);
		List midCol = Arrays.asList(2,5,8);
		List rightCol = Arrays.asList(3,7,9);
		
		List diagLeft = Arrays.asList(1,5,9);
		List diagRight = Arrays.asList(3,5,7);
		
		List<List> winningPossibilities = new ArrayList<List>();
		winningPossibilities.add(topRow);
		winningPossibilities.add(midRow);
		winningPossibilities.add(botRow);
		winningPossibilities.add(leftCol);
		winningPossibilities.add(midCol);
		winningPossibilities.add(rightCol);
		winningPossibilities.add(diagLeft);
		winningPossibilities.add(diagRight);
		
		for(List l: winningPossibilities)
		{
			if(playerPositions.containsAll(l))
			{
				System.out.println("Congrats, you won!!!");
			}

			else if(cpuPositions.containsAll(l))
			{
				System.out.println("The CPU won!!!");
			}
			else if(playerPositions.size() + cpuPositions.size() == 9)
			{
				System.out.println("Its a Tie!!!");
			}
		}
		return " ";
	}
}
