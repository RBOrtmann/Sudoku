package sudokuPackage;

import java.util.Random;
import java.util.Scanner;

public class Game {
	private Board initialBoard;
	private Board answerBoard;
	private boolean gameOver;
	private long startTime;
	//private int mistakesCounter;
	
	/* Constructs SudokuGame with initial board and answer board */
	public Game(Board init, Board ans) {
		initialBoard = init; // do i need to do a deep copy here?
		answerBoard = ans;
		gameOver = false;
		startTime = System.currentTimeMillis();
		//mistakesCounter = 0;		
	}
	
	/* Compares current board to answer board and returns
	 the total number of cells that are wrong. This will eventually
	 be expanded to specify which specific cells are wrong.*/
	public void howAmIDoing() {
		
	}
	
	/* Populate random empty cell with the correct corresponding value
	 from the answer board (5 total hints?) */
	public void hint() {
		
	}
	
	/* Handles what happens once the game is won
	  (For now just prints a string with some statistics) */
	public String hasWon() {
		//s
	}
	
	/* Keeps track of how long it takes to solve puzzle */
		
	/* Gets user input (changes cells, calls howAmIDoing, etc.) */
	public void getUserInput(Scanner scn) {
		System.out.println("Choose a command: \n" + "\t1. Change a cell\n\t2. How am I doing?\n\t3. Hint");
		int cmd = scn.nextInt();
		if(cmd == 1) {
			System.out.println("Enter value (row column value)");
			int row = scn.nextInt();
			int col = scn.nextInt();
			int val = scn.nextInt();
			initialBoard.changeCell(row, col, val);
		} else if(cmd == 2) {
			howAmIDoing();
		} else if(cmd == 3) {
			hint();
		}
	}

	/* Saves current board to text file */
	public void saveGame() {
		public void saveGame() throws IOException {
			String Save = initialBoard.toString();
			FileWriter fw = new FileWriter("SavedGame",false);
			fw.write(Save);
			//writes the time
			
			fw.close();
			}	
		
	}
	
	public boolean isOver() {
		return gameOver;
	}
}
