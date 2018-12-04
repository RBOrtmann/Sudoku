package sudokuPackage;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;


//set of text files


public class Game {
	private Board initialBoard;
	private Board answerBoard;
	private Stack<Move> moves;
	private int hint;
	
	
	class Move {
		public int row;
		public int col;
		public int value;
	}
	
	/* Constructs SudokuGame with initial board and answer board */
	public Game(Board init, Board ans) {
		initialBoard = init; // do i need to do a deep copy here?
		answerBoard = ans;		
		moves = new Stack<>();	
		hint = 5;
	
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
		ArrayList<Move> empty = new ArrayList<>();
		if(hint > 0) {
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					if(initialBoard.getCell(i, j) == 0) {
						//initialBoard.changeCell(i, j, answerBoard.getCell(i, j));
						Move m = new Move();
						m.row = i;
						m.col = j;
						m.value = 0;
						empty.add(m);
					}
				}
			}
			Random rand = new Random();
			Move n = empty.get(rand.nextInt(empty.size()));
			initialBoard.changeCell(n.row, n.col, answerBoard.getCell(n.row, n.col));
			hint--;
			
		} else {
			System.out.println("You've used too many hints!");
		}
	}
	/* Handles what happens once the game is won
	  (For now just prints a string with some statistics) */
	public boolean hasWon() {
		if(initialBoard.equals(answerBoard)) {
			System.out.println("Game over!");
			return true;
		}
		return false;
	}
	
	
	 

	/* Gets user input (changes cells, calls howAmIDoing, etc.) */
	public void getUserInput(Scanner scn) throws Exception{
		System.out.println("Choose a command: \n" + "1. Change a cell\n"+ "2. How am I doing?\n3. Hint\n4. Save (this will overwrite your previous save)");
		
		int cmd = scn.nextInt();
		
		if(cmd == 1) {
			System.out.println("Enter row: ");
			int row = scn.nextInt();
			System.out.println("Enter column: ");
			int col = scn.nextInt();
			System.out.println("Enter value: ");
			int val = scn.nextInt();
			initialBoard.changeCell(row-1, col-1, val);
			Move counter = new Move();
			counter.row = row;
			counter.col = col;
			counter.value = val;
			moves.add(counter);
		} else if(cmd == 2) {
			howAmIDoing();
		} else if(cmd == 3) {
			hint();
		} else if(cmd == 4) {
			saveGame(initialBoard, false);
			saveGame(answerBoard, true);
			System.out.println("Game saved.");
		}else if(cmd == 5) {
			System.exit(0);;
		}
	}


	/* Saves current board to text file */
     public void saveGame(Board b, boolean ans) throws IOException {
		String save = b.toString();
		FileWriter fw;
		if(ans) {
			fw = new FileWriter("loadans.txt");
		} else {
			fw = new FileWriter("load.txt");
		}
		fw.write(save);
		
		fw.flush();
		fw.close();
	}
	
	/*Loops the game until it's over */
	public void gameLoop() {
		Scanner move = new Scanner(System.in);
		while(!hasWon()) {
			initialBoard.printBoard();
			try {
				getUserInput(move);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("To see moves, enter 'm'. Enter any other character to end the game: ");
		if(move.next().equals("m")) {
			while(!moves.isEmpty()) {
				Move m = moves.pop();
				System.out.println("Row = " + m.row + " Column = " + m.col + " Number = " + m.value);
			}
			
		}
		initialBoard.printBoard();
		move.close();
	}
}
