package sudokuPackage;

import java.io.*;
import java.util.Scanner;

public class Main {
	
	/* Starts the game by getting file contents, reading them into strings,
	 and creating the initial board and its answer key. Then it sends
	 the boards to SudokuGame which handles the logic of the game. */
	public static void main(String[] args) throws IOException{
		Scanner scnIn = new Scanner(System.in);
		System.out.println("Enter initial board filename (or type 'load' to load your game): ");
		//String board = scnIn.nextLine(); //This will eventually fetch user input
		String board =  scnIn.nextLine();
		Board initBoard;
		if (board == "load") {
			initBoard = new Board(readFile("SavedGame.txt"));
		} else {
			initBoard = new Board(readFile(board+".txt"));
		}
		
		//String board = "testboard";		
		//	Board initBoard = new Board(readFile(board+".txt"));
		// File name for answer board is just file name with "ans" on the end
		Board ansBoard = new Board(readFile(board+"ans.txt"));
		
		Game newGame = new Game(initBoard, ansBoard);
		
		long startTime = System.currentTimeMillis();
		newGame.gameLoop();	
		System.out.println("Time: " + (System.currentTimeMillis()-startTime)/1000);
		
		scnIn.close();
	}
	
	/* Reads comments from a board file */
	public static String readFile(String filename) throws FileNotFoundException{
		Scanner scn = new Scanner(new File(filename));
		String filecontents = scn.useDelimiter("\\A").next();
		//System.out.println("here" + filecontents.length());
		//System.out.println(filecontents);
		scn.close();
		return filecontents;
	}
	
	/* Loads in-progress board from file */
	//load the board//
		/*
		 * public Board loadBoard(String filename) throws IOException {
		 * FileReader fr = new FileReader("SavedGame");
			fr.read();
			loadBoard.
			
		 */
}
