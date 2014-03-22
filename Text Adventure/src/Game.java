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
	
	public static boolean play;
	public static String RESET = "";
	public static String BLACK = "";
	public static String RED = "";
	public static String GREEN = "";
	public static String YELLOW = "";
	public static String BLUE = "";
	public static String PURPLE = "";
	public static String CYAN = "";
	public static String WHITE = "";
	public static String CLEAN = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
	public static String HIDDEN= "";
	
	public static void main(String[] args) throws InterruptedException {
		
		//if user is not running windows the colour take effect
			//(ANSI colour codes do not work in command prompt)
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
		
		play = true;
		
		if(keyboard.nextLine().length() > -1) {	//Unconditionally is true as text will never be less than 0
			
			//creates the map
			Map map = new Map();
			
			//clears the console for a visually blank start
			System.out.print(CLEAN);
			System.out.println();
			
			//First email
			printMessage(makeRed("*** ALERT ***\n"));
			printMessage(makeRed("New E-mail Recieved!\n"));
			printMessage("From: odin@valhalla.no\n");
			printMessage("Subject: Hello Warrior\n");
			System.out.println();
			printMessage("Hello Warrior.\n");
			printMessage("I am "+makeRed("Odin")+", The All-Father. You have been in cryostasis since the "+makePurple("Information Age")+".\n");
			printMessage("It is the year "+makePurple("20XX PA (Post-Armageddon)")+", and you are drifting aboard the "+makeCyan("NS Fjord VValkyrie")+".\n");
			printMessage("Your vessel and crew have succumb to a "+makeYellow("terrible fate")+".\n");
			System.out.println();
			printMessage("Your crew was returning home from a raid on "+makeGreen("Neo-Dublin")+"\n");
			printMessage("when an unexpected nuclear fish-salting accident occurred and the main core overheated and caused\n");
			printMessage("a great explosion.\n");
			System.out.println();
			printMessage("Every member of your crew was either mutated or killed in the explosion\n");
			printMessage("and are now roaming the halls of this vessel, and may prove "+makeRed("dangerous")+".\n");
			System.out.println();
			
			//user's character inputs
			printMessage("What would you like me to "+makeCyan("call")+" you, Warrior?\n");
			System.out.println();
			printMessage(makeGreen("*** DRAFTING ***\n"));
			printMessage("To: odin@valhalla.no\n");
			printMessage("Subject: Re: Hello Warrior\n");
			String name = keyboard.nextLine();
			printMessage("\nSending");
			printMessage("..........", 125);
			printMessage(" Sent!\n");
			System.out.println();
			
			//Next email
			printMessage(makeRed("*** ALERT ***\n"));
			printMessage(makeRed("New E-mail Recieved!\n"));
			printMessage("From: odin@valhalla.no\n");
			printMessage("Subject: Re:Re: Hello Warrior\n\n");
			printMessage(name+". An interesting name indeed.\nWhat is your "+makeCyan("profession")+"?\n");
			System.out.println();

			printMessage(makeGreen("*** DRAFTING ***\n"));
			
			//User's second input field
			printMessage("To: odin@valhalla.no\n");
			printMessage("Subject: Re:Re:Re: Hello Warrior\n");
			String profession = keyboard.nextLine();
			printMessage("\nSending");
			printMessage("..........", 125);
			printMessage(" Sent!\n");
			System.out.println();

			//Third email
			printMessage(makeRed("*** ALERT ***\n"));
			printMessage(makeRed("New E-mail Recieved!\n"));
			printMessage("From: odin@valhalla.no\n");
			printMessage("Subject: Re:Re:Re:Re: Hello Warrior\n\n");
			printMessage("Ah, "+makeCyan(name)+" the "+makeCyan(profession)+". Yes, I remember you.\n");
			System.out.println();
			printMessage("I call upon you now "+makeCyan(name)+", to go and rid this universe of your mutating vessel.\n");
			printMessage("You must reach the core and destroy it for good and finish this.\n");
			System.out.println();
			
			//prints the entire map
				//when map is viewed during the actual game only previously visited rooms
				//and adjacent rooms will show
			printMessage("Here on the wall is a map of the "+makeCyan("NSFVV")+", I have marked your position with a pre-age symbol: *\n");
			printMessage("It should look familiar to your time, it is called an asterisk.\n");
			System.out.println();
			System.out.println(map.fullMap());
			System.out.println();
			printMessage("This map will not be available to you after you leave this room, you will have\n");
			printMessage("to mark each room after you've visited them. ");
			printMessage("This is what your map will normally look like:\n");
			System.out.println();
			System.out.println(map);
			System.out.println();
			

			//receive first weapon
			printMessage("Now Go Warrior.\nYou will die in the process, but in doing so you will save the universe.\n");
			printMessage("And here take "+makeBlue("this")+", you may find it useful on your quest.\n");
			Item soedekilling = new Item("Soedekilling", "A lyn-gladius", 1, "Weapon", 2, true);
			printMessage("Finally, remember that your keen "+profession+"'s instinct allows you to seek for \"help\" at any time.");
			
			System.out.println(CLEAN);
			
			//new player created with the inputed name and profession
				//health: 10
				//strength: 1
				//defense: 1
			Player player = new Player(name, profession, 10, 1, 1, soedekilling, null);			
			player.pickupItem(soedekilling); //adds starter weapon to inventory arraylist
						
			while(play)
			{	
				
				printMessage("What will you do, "+player.getName()+"?\n");
				String entry = keyboard.nextLine();
				entry.toLowerCase();
				
				if(entry.equals("help") || entry.equals("?"))	
					help();
				
				if(map.getCurrentRoom().getEnemy()!=null)
				{
					Person enemy=map.getCurrentRoom().getEnemy();
					printMessage("You have encountered a "+makePurple(enemy.getName())+"\n");
					boolean fight=true;

					while(fight)
					{
						printMessage("What will you do?\n");
						String input=keyboard.nextLine();
						input.toLowerCase();
						
						if(input.equals("run")||input.equals("run away")||input.equals("flee"))
							printMessage("Oh I'm sorry. Clearly we've been mistaken and are "
									+"narrating the deeds of a perpetually"+makeYellow("SNIVELING COWARD")+", as opposed to a powerful "
										+profession+" embarking on a"+makeRed("VIKING") +"related journey in the cold and unforgiving "
											+makeCyan("VOID OF SPACE.")+" Would you also like a spiced latte and a foot massage on your way out?"
												+"Hm? No, I thought not. Now go back and fight.\n");
						
						if(input.equals("fight")||input.equals("attack"))
						{
							double damageDealt = player.dealDamage();
							enemy.takeDamage(damageDealt);
							printMessage("You dealt "+damageDealt+" damage to your opponent.\n");
							double damageTaken = enemy.dealDamage();
							player.takeDamage(damageTaken);
							printMessage("Your opponent dealt "+damageTaken+"damage to you");
						}
						
						if(enemy.getHealth()<=0)
						{
							printMessage("You defeated the "+makePurple(enemy.getName())+"\n");
							fight=false;
						}
						
						if(player.getHealth()<=0)
						{
							printMessage("You were defeated by the "+makePurple(enemy.getName())+"\n");
							fight=false;
						}
					}
				}
					
			}
			
		}
		
	}
	
	public static void help() throws InterruptedException {
		printMessage("'map' or 'm' : open your map (shows only previously visited and adjacent rooms)", 15);
		printMessage("'inventory' or 'i' : open inventory", 15);
		printMessage("'equip' or 'eq' : equips an item in your inventory at the specified index", 15);
		printMessage("'look' or 'l' : look at your surroundings\n", 15);
		printMessage("'pick up' or 'p' : pick up an item\n", 15);
		printMessage("'move north' or 'n' : move to the northern adjacent room (if valid)\n", 15);
		printMessage("'move east' or 'e' : move to the eastern adjacent room (if valid)\n", 15);
		printMessage("'move west' or 'w' : move to the western adjacent room (if valid)\n", 15);
		printMessage("'move south' or 's' : move to the southern adjacent room (if valid)\n", 15);
		printMessage("'unlock' or 'u' : unlocks an adjacent locked room\n", 15);
		printMessage("'attack' or 'a' : attacks an enemy while in battle\n", 15);
		printMessage("\n", 15);
	}
	
	//prints strings letter by letter to create a typing effect
	public static void printMessage(String n) throws InterruptedException {
		
		for (int i = 0; i < n.length(); i++){
			System.out.print(n.substring(i, i+1));
			Thread.sleep(50);
		}
	}
	
	public static void printMessage(String n, int time) throws InterruptedException {
		
		for (int i = 0; i < n.length(); i++){
			System.out.print(n.substring(i, i+1));
			Thread.sleep(time);
		}
	}
	
	//methods to change colours of strings in terminal
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
