/**
 * Game.java
 * @author Alex Dunn
 * B00636250
 * Mar 9, 2014
 * Dalhousie University
 * Faculty of Computer Science
 */


import java.util.Scanner;

public class Game {
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		final String RESET = "\u001B[0m";
		final String BLACK = "\u001B[30m";
		final String RED = "\u001B[31m";
		final String GREEN = "\u001B[32m";
		final String YELLOW = "\u001B[33m";
		final String BLUE = "\u001B[34m";
		final String PURPLE = "\u001B[35m";
		final String CYAN = "\u001B[36m";
		final String WHITE = "\u001B[37m";

		clearConsole();

		System.out.println();
		System.out.println("      |   __     __ __ __ __ __    __  __     __  |                         ");
		System.out.println(" _  --|--|__)|  |_ (_ (_ |_ |  \\  |__)/  \\\\_/(_ --|-- _  _ _  _|    _|_. _  _  ");
		System.out.println("(_|   |  |__)|__|____)__)|__|__/  |__)\\__/ | __)  |  |_)| (_)(_||_|(_|_|(_)| ) ");
		System.out.println("      |                                           |  |                         ");
		System.out.println();
		System.out.println();

		System.out.println(CYAN+ "Cyan"+ RESET);
		System.out.println(PURPLE+ "Purple"+ RESET);
		System.out.println(RED+ "Red"+ RESET);
		System.out.println(GREEN+ "Green"+ RESET);
		System.out.println(BLUE+ "Blue"+ RESET);
		System.out.println(YELLOW+ "Yellow"+ RESET);
		System.out.println(WHITE+ "White"+ RESET);
		System.out.println(BLACK+ "Black"+ RESET);

	}

	public static void clearConsole() {
		for(int i=0; i<50; i++)
			System.out.println(" ");
	}		
}

