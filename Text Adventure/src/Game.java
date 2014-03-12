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
		
//		printMessage("The "+ makeYellow("mutated Viking ")+ "swung his blade hitting for "+ makeRed("65 ")+ "Damage \n");
//		printMessage("You have "+ makeGreen("105 ")+ "health remaining\n");
//		printMessage("This text is "+ makeHidden("hidden ")+ " (hidden)\n");
//		System.out.print(BLINK+ "> "+ RESET);
		
		Map map = new Map();
		System.out.println(map);
		
	}
	public static void printMessage(String n) throws InterruptedException{
		
		for (int i = 0; i < n.length(); i++){
			System.out.print(n.substring(i, i+1));
			Thread.sleep(50);
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
	public static final String HIDDEN= "\u001B[8m";
	
	
	public static String makeBlack(String s) {
		return BLACK+ s+ RESET;
	}
	public static String makeRed(String s) {
		return RED+ s+ RESET;
	}
	public static String makeGreen(String s) {
		return GREEN+ s+ RESET;
	}
	public static String makeYellow(String s) {
		return YELLOW+ s+ RESET;
	}
	public static String makeBlue(String s) {
		return BLUE+ s+ RESET;
	}
	public static String makePurple(String s) {
		return PURPLE+ s+ RESET;
	}
	public static String makeCyan(String s) {
		return CYAN+ s+ RESET;
	}
	public static String makeWhite(String s) {
		return WHITE+ s+ RESET;
	}
	public static String makeHidden(String s) {
		return HIDDEN+ s+ RESET;
	}
}
