package sudokuPackage;


import java.io.FileWriter;
import java.io.IOException;
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
		
		//mistakesCounter = 0;;	
		
		
		
		
	}
	
	/* Compares current board to answer board and returns
	 the total number of cells that are wrong. This will eventually
	 be expanded to specify which specific cells are wrong.*/
	public void howAmIDoing() {
		//Scanner first = new Scanner(initialBoard);
		//Scanner second = new Scanner(answerBoard);
		
		
	}
	
	/* Populate random empty cell with the correct corresponding value
	 from the answer board (5 total hints?) */
	public void hint() {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(j == 0) {
					initialBoard.changeCell(i, j, answerBoard.getCell(i, j));
					return;
				}
			}
		}
	}

	
	
	/* Handles what happens once the game is won
	  (For now just prints a string with some statistics) */
	public boolean hasWon() {
		if(initialBoard.equals(answerBoard)) {
			return true;
		}
		return false;
	}	

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
     public void saveGame() throws IOException {
			String Save = initialBoard.toSavedFile();
			FileWriter fw = new FileWriter("SavedGame.txt",false);
			fw.write(Save);
			System.out.println("Game Saved, you may exit now");
			//writes the time


		fw.close();
	}
	
	
	/* Returns game state */
	public boolean isOver() {
		return gameOver;
	}
	
	/*Loops the game until it's over */
	public void gameLoop() throws IOException {
		Scanner move = new Scanner(System.in);
		while(!hasWon()) {
			initialBoard.printBoard();
			System.out.println("Pick your row, or -1 for help, -2 for hint, -3 for save");
			
			int r = move.nextInt();
			
			// help if help req
			if(r == -1) {
				howAmIDoing();
				break;
			}
			// 
			if(r == -2) {
				hint();
				break;
			}
			//
			if(r == -3) {
				saveGame();
				break;
			}
			
			System.out.println("Pick your col");
			int c = move.nextInt();
			
			System.out.println("What would you like to put there?\n(1-9)");
			int n = move.nextInt();
			
			// move if move action requested
			initialBoard.changeCell(r,c,n);
		}
		move.close();
	}
}
