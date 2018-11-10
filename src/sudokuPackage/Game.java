package sudokuPackage;

public class Game {
	private Board initialBoard;
	private Board answerBoard;
	private boolean gameOver;
	//private int mistakesCounter;
	
	/* Constructs SudokuGame with initial board and answer board */
	public Game(Board init, Board ans) {
		initialBoard = init;
		answerBoard = ans;
		gameOver = false;
		//mistakesCounter = 0;		
	}
	
	/* Compares current board to answer board and returns
	 the total number of cells that are wrong. This will eventually
	 be expanded to specify which specific cells are wrong.*/
	public int howAmIDoing(Board current) {
		return 0;
	}
	
	/* Populate random empty cell with the correct corresponding value
	 from the answer board (5 total hints?) */
	public void hint(Board current) {
		
	}
	
	/* Handles what happens once the game is won
	  (For now just prints a string with some statistics) */
	public String hasWon() {
		return null;
	}
	
	/* Keeps track of how long it takes to solve puzzle */
	public long timer() {
		return 0;
	}
	
	/* Gets user input (changes cells, calls howAmIDoing, etc.) */
	public void getUserInput() {
		
	}

	/* Saves current board to text file */
	public void saveGame() {
		
	}
	
	public boolean isOver() {
		return gameOver;
	}
}
