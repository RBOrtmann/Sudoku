package sudokuPackage;

import java.io.*;
import java.util.Scanner;

public class Main {
	
	/* Starts the game by getting file contents, reading them into strings,
	 and creating the initial board and its answer key. Then it sends
	 the boards to SudokuGame which handles the logic of the game. */
	public static void main(String[] args){
		Scanner scnIn = new Scanner(System.in);
		System.out.println("Choose your difficulty (or load your saved game): \n"
				+ "1. Easy\n"
				+ "2. Medium\n"
				+ "3. Hard\n"
				+ "4. Saved Game (any key)");
		Board initBoard;
		Board ansBoard;
		Game newGame;
		
		try {
			int diff =  scnIn.nextInt();
			
			if(diff == 1) {
				initBoard = new Board(readFile("Easy.txt"));
				ansBoard = new Board(readFile("Easyans.txt"));
			} else if(diff == 2) {
				initBoard = new Board(readFile("Medium.txt"));
				ansBoard = new Board(readFile("Mediumans.txt"));
			} else if(diff == 3) {
				initBoard = new Board(readFile("Hard.txt"));
				ansBoard = new Board(readFile("Hardans.txt"));
			} else {
				initBoard = new Board(readFile("load.txt"));
				ansBoard = new Board(readFile("loadans.txt"));
			}
			
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
