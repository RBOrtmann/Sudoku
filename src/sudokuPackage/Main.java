package sudokuPackage;

import java.io.*;
import java.util.Scanner;

public class Main {
	
	/* Starts the game by getting file contents, reading them into strings,
	 and creating the initial board and its answer key. Then it sends
	 the boards to SudokuGame which handles the logic of the game. */
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		Board initBoard;
		Board ansBoard;
		Game newGame;
		String diff;
		System.out.println("Choose your difficulty (or load your saved game): \n"
				+ "1. Easy\n"
				+ "2. Medium\n"
				+ "3. Hard\n"
				+ "4. Saved Game");
		
		do {
			try {
				diff = scn.nextLine();
				int i = (int)diff;
			} catch(Exception e) {
				
			}
		} while(!scn.hasNextInt());
		
		scn.close();
	}
	
	/* Reads comments from a board file */
	public static String readFile(String filename) throws FileNotFoundException{
		Scanner scn = new Scanner(new File(filename));
		String filecontents = scn.useDelimiter("\\A").next();
		scn.close();
		return filecontents;
	}

}
