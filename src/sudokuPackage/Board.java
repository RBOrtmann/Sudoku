package sudokuPackage;

import java.util.Scanner;

public class Board {
	private  int[][] cells;
	private static final int NUM_ROWS = 9;
	private static final int NUM_COLS = 9;
	
	/* Initializes the array for a new board*/
	public Board(String s) {
		this.cells = new int[NUM_ROWS][NUM_COLS];
		populateInitialCells(s);
	}
	
	/* Populates the initial cells based on the file that was read
	 in SudokuMain*/
	public void populateInitialCells(String s) {
		Scanner scn = new Scanner(s);
		String line;
		int row = 0;
		while(scn.hasNext()) {
			line = scn.nextLine();
			for(int i = 0; i < NUM_COLS; i++) {
				cells[row][i] = Character.getNumericValue(line.charAt(i));
			}
			row++;
		}
		scn.close();
	}
	
	/* Gets a specific cell from the board array*/
	public int getCell(int row, int col) {		
		return (cells[row][col]);
	}
	
	/* Get all cells from board */
	public int[][] getCells(){
		return(cells);
	}
	
	/* Changes a specific cell in the board array*/
	public void changeCell(int row, int col, int num) {
		cells[row][col] = num;
	}
	
	/* Prints a formatted version of the current board to the console
	 (will later be supplanted with the GUI)*/
	public void printBoard() {
		
		for(int i = 0; i < cells.length; i++) {
			System.out.print("| ");			
			for(int j = 0; j < cells.length; j++) {
				System.out.print(cells[i][j]);
				if((j+1)%3==0) {
					System.out.print(" | ");
				}
			}
			System.out.println();
			if((i+1)%3 == 0 && i != 8) {
				System.out.println(" -----------------"); 
			}
		}
	}
	
	/* Compares two boards */
	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		} else if(!(o instanceof Board)) {
			return false;
		}
		
		Board other = (Board)o;
		return (cells == other.cells);
	}
	
	/* Returns the current board as a string */
	@Override
	public String toString() {
		String b = "";
		for(int i = 0; i < cells.length; i++) {
			for(int j = 0; j < cells.length; j++) {
				b = b + (cells[i][j]);
			}
			b = b + "\n";
		}
		return b;
	}
}
