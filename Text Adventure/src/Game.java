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
	
	public static String RESET = "";
	public static String BLACK = "";
	public static String RED = "";
	public static String GREEN = "";
	public static String YELLOW = "";
	public static String BLUE = "";
	public static String PURPLE = "";
	public static String CYAN = "";
	public static String WHITE = "";
	public static String CLEAN = "";
	public static String HIDDEN= "";
	
	public static void main(String[] args) throws InterruptedException {
		
		if (!System.getProperty("os.name").contains("Windows")){
			 RESET = "\u001B[0m";
			 BLACK = "\u001B[30m";
			 RED = "\u001B[31m";
			 GREEN = "\u001B[32m";
			 YELLOW = "\u001B[33m";
			 BLUE = "\u001B[34m";
			 PURPLE = "\u001B[35m";
			 CYAN = "\u001B[36m";
			 WHITE = "\u001B[37m";
			 CLEAN = "\033[H\033[2J";
			 HIDDEN= "\u001B[8m";
		}
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println(CLEAN);
		
		printMessage("A Blessed Boys production:\n");
		System.out.println();
		System.out.println();
		System.out.println("   _____ ____  ___   ____________   _    ________ __ _____   ________");
		System.out.println("  / ___// __ \\/   | / ____/ ____/  | |  / /  _/ //_//  _/ | / / ____/");
		System.out.println("  \\__ \\/ /_/ / /| |/ /   / __/     | | / // // . /  / //  |/ / / __  ");
		System.out.println(" ___/ / ____/ ___ / /___/ /___     | |/ // // /| |_/ // /|  / /_/ /  ");
		System.out.println("/____/_/   /_/  |_\\____/_____/     |___/___/_/ |_/___/_/ |_/\\____/   ");
		System.out.println();
		System.out.print("                     ");
		printMessage("Press Enter to Continue.");
		
		if(keyboard.nextLine().length() <= 0) {
			
			Map map = new Map();
			
			System.out.print(CLEAN); //clears the console for a visually blank start
			System.out.println();
			
			//back story intro
			printMessage("Hello Warrior.\n");
			printMessage("I am "+makeRed("Odin")+", God of war. You have been in cryostasis since the Information Age.\n");
			printMessage("It is the year 20XX PA (Post-Armageddon), and you are drifting aboard the NS Fjord VValkyrie.\n");
			printMessage("Your vessel and crew have succumb to a terrible fate.\n");
			System.out.println();
			printMessage("Your crew was returning home from a raid on "+makeGreen("Neo-Dublin")+"\n");
			printMessage("when a freak nuclear fish-salting accident occurred and the main core overheated and caused\n");
			printMessage("a great explosion.\n");
			System.out.println();
			printMessage("Every member of your crew was either mutated or killed in the explosion\n");
			printMessage("and are now roaming the halls of this vessel.\n");
			System.out.println();
			
			//user's character inputs
			printMessage("What would you like me to call you, Warrior?\n");
			String name = keyboard.nextLine();
			printMessage(name+". An interesting name indeed.\nWhat is your profession?\n");
			String profession = keyboard.nextLine();
			printMessage("Ah, "+name+" the "+profession+". Yes, I remember you.\n");
			
			
			
			printMessage("I call upon you now warrior, to go and rid this universe of your mutating vessel.\n");
			printMessage("You must reach the core and destroy it for good and finish this.\n");
			System.out.println();
			
			//prints the entire map
				//when map is viewed during the actual game only previously visited rooms
				//and adjacent rooms will show
			printMessage("Here is a map of the NSFVV, I have marked your position with a pre-age symbol: *\n");
			printMessage("It should look familiar to your time, it is called an asterisk.\n");
			
			System.out.println();
			System.out.println(map);
			System.out.println();
			
			//receive first weapon
			printMessage("Now Go Warrior.\nYou will die in the process, but in doing so you will save the universe.\n");
			printMessage("And here take this, you may find it useful in your journey.");
			Item soedekilling = new Item("Soedekilling", "A lyn-gladius", 1, "Weapon", 2, true);
			
			//new player created with the inputed name and profession
				//health: 10
				//strength: 1
				//defense: 1
			Player user = new Player(name, profession, 10, 1, 1, soedekilling, null);			
			user.pickupItem(soedekilling);
			
		}
		
	}
	
	public static void printMessage(String n) throws InterruptedException {
		
		for (int i = 0; i < n.length(); i++){
			System.out.print(n.substring(i, i+1));
			Thread.sleep(50);
		}
	}
	
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
