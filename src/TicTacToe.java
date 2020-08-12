import java.util.*;

public class TicTacToe extends Methods{

	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
	
	public static void main(String[] args) 
	{
		System.out.println("This is the board");
		char [][] gameBoard = 
			{
			{' ','|',' ','|',' '},
			{'-','+','-','+','-'},
			{' ','|',' ','|',' '},
			{'-','+','-','+','-'},
			{' ','|',' ','|',' '}
			};
		
		printBoard(gameBoard);
		Scanner input = new Scanner(System.in);
		
		while (true)
		{
			System.out.println("Enter your spot on the board from 1 - 9, Human player: ");
		
			int position = input.nextInt();
			System.out.println("This position was picked on the board by the player: "+ position);
			
			while(playerPositions.contains(position) || cpuPositions.contains(position))
			{
				System.out.println("Position taken, try again");
				position = input.nextInt();
			}
			String PlayerWinYet = checkForWinner(playerPositions, cpuPositions);
			System.out.println(PlayerWinYet);
		
			pickASpotNext(gameBoard, position, "Player", playerPositions, cpuPositions); // player turn
			cpuPickASpotNext(gameBoard, playerPositions, cpuPositions); // CPU turn
			//String cpuWinYet = checkForWinner(playerPositions, cpuPositions);
			//System.out.println(cpuWinYet);
		}
		
	}
	
}
