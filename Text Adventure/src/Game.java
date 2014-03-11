/**
 * Map.java
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
		
		printMessage("The "+ YELLOW+ "mutated Viking "+ RESET+ "swung his blade hitting for "+ RED+ "65 "+ RESET+ "Damage \n");
		printMessage("You have "+ GREEN+ " 105 "+ RESET + "health remaining\n");
		
		
	}
	
	public static void printMessage(String n){
		
		for (int i = 0; i < n.length(); i++){
			System.out.print(n.substring(i, i+1));
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
	
	public static final String RESET = "\u001B[0m";
	public static final String BLACK = "\u001B[30m";
	public static final String RED = "\u001B[31m";
	public static final String GREEN = "\u001B[32m";
	public static final String YELLOW = "\u001B[33m";
	public static final String BLUE = "\u001B[34m";
	public static final String PURPLE = "\u001B[35m";
	public static final String CYAN = "\u001B[36m";
	public static final String WHITE = "\u001B[37m";
	public static final String CLEAN = "\033[H\033[2J";
}
