package sudokuPackage;

import java.io.*;
import java.util.Scanner;

public class Main {
	
	/* Starts the game by getting file contents, reading them into strings,
	 and creating the initial board and its answer key. Then it sends
	 the boards to SudokuGame which handles the logic of the game. */
	public static void main(String[] args){
		Scanner scnIn = new Scanner(System.in);
		System.out.println("Enter initial board filename (or type 'load' to load your game): ");
		String board =  scnIn.nextLine();
		Board initBoard;
		Board ansBoard;
		Game newGame;
		
		try {
			initBoard = new Board(readFile(board + ".txt"));
			ansBoard = new Board(readFile(board + "ans.txt"));
			newGame = new Game(initBoard, ansBoard);
			
			long startTime = System.currentTimeMillis();
			newGame.gameLoop();	
			System.out.println("Time: " + ((System.currentTimeMillis()-startTime)/1000)/60 + " Minutes.");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage() + "\nRestart the program to continue.");
			
			
		}
		
		scnIn.close();
	}
	
	/* Reads comments from a board file */
	public static String readFile(String filename) throws FileNotFoundException{
		Scanner scn = new Scanner(new File(filename));
		String filecontents = scn.useDelimiter("\\A").next();
		scn.close();
		return filecontents;
	}

}
