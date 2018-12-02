package sudokuPackage;


import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Game {
	private Board initialBoard;
	private Board answerBoard;
	
	/* Constructs SudokuGame with initial board and answer board */
	public Game(Board init, Board ans) {
		initialBoard = init; // do i need to do a deep copy here?
		answerBoard = ans;		
	}
	
	/* Compares current board to answer board and returns
	 the total number of cells that are wrong. This will eventually
	 be expanded to specify which specific cells are wrong.*/
	public void howAmIDoing() {
		int different = 0;
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(initialBoard.getCell(i, j) != answerBoard.getCell(i, j)) {
					different++;
				}
			}
		}
		
		System.out.println(different + " of your cells are wrong.");
	}
	
	/* Populate random empty cell with the correct corresponding value
	 from the answer board (5 total hints?) */
	public void hint() {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(initialBoard.getCell(i, j) == 0) {
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
		String save = initialBoard.toString();
		FileWriter fw = new FileWriter("load.txt");
		fw.write(save);
		System.out.println("Game saved, exiting...");
		
		fw.flush();
		fw.close();
		System.exit(0);
	}
	
	/*Loops the game until it's over */
	public void gameLoop() throws IOException {
		Scanner move = new Scanner(System.in);
		while(!hasWon()) {
			initialBoard.printBoard();
			System.out.println("Pick your row, or -1 for help, -2 for hint, -3 for save: ");
			
			int r = move.nextInt();
			
			switch(r) {
			case -1:
				howAmIDoing();
				break;
			case -2:
				hint();
				gameLoop();
				break;
			case -3:
				saveGame();
				break;
			}
			
			System.out.println("Pick your column: ");
			int c = move.nextInt();
			
			System.out.println("Enter value (1-9): ");
			int n = move.nextInt();
			
			// move if move action requested
			initialBoard.changeCell(r-1, c-1, n);
		}
		move.close();
	}
}
