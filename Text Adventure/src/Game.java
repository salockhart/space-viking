/**
 * Game.java
 * @author Alex Dunn
 * B00636250
 * @author Geoffrey Caven
 * B00629837
 * @author Matthew Trask
 * B00639252
 * @author Niclas Skaalum
 * B00634842
 * @author Stanford Lockhart
 * B00636250
 * Mar 9, 2014
 * Dalhousie University
 * Faculty of Computer Science
 */

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import java.util.Random;
import java.util.Scanner;

public class Game {
	
	public static boolean play;
	public static boolean fight;
	public static boolean inventory;
	public static boolean boss = false;
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
		
		//Instance variables
		String entry;
		
		//if user is not running windows the colour take effect
			//(ANSI colour codes do not work in command prompt)
		if (!System.getProperty("os.name").contains("Windows")){
			 RESET = "\u001B[0m";
			 BLACK = "\u001B[30m";
			 RED = "\u001B[91m";
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
			
			loadUp();
			playSound("load");
			
			//First email
			printMessage(makeRed("*** ALERT ***\n"),25);
			printMessage(makeRed("New E-mail Recieved!\n"),25);
			printMessage("From: odin@valhalla.no\n",25);
			printMessage("Subject: Hello Warrior\n",25);
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
			printMessage("What would you like me to "+makeYellow("call")+" you, Warrior?\n");
			System.out.println();
			printMessage(makeGreen("*** DRAFTING ***\n"),25);
			printMessage("To: odin@valhalla.no\n",25);
			printMessage("Subject: Re: Hello Warrior\n",25);
			String name = keyboard.nextLine();
			printMessage("\nSending");
			playSound("send");
			printMessage("..........", 125);
			printMessage(" Sent!\n");
			Thread.sleep(1000);
			System.out.print(CLEAN);
			
			//Next email
			printMessage(makeRed("*** ALERT ***\n"),25);
			printMessage(makeRed("New E-mail Recieved!\n"),25);
			printMessage("From: odin@valhalla.no\n",25);
			printMessage("Subject: Re:Re: Hello Warrior\n\n",25);
			printMessage(makeYellow(name)+". An interesting name indeed. What is your "+makeYellow("title")+"?\n");
			System.out.println();

			printMessage(makeGreen("*** DRAFTING ***\n"),25);
			
			//User's second input field
			printMessage("To: odin@valhalla.no\n",25);
			printMessage("Subject: Re:Re:Re: Hello Warrior\n",25);
			String profession = keyboard.nextLine();
			printMessage("\nSending");
			playSound("send");
			printMessage("..........", 125);
			printMessage(" Sent!\n");
			Thread.sleep(1000);
			System.out.print(CLEAN);

			//Third email
			printMessage(makeRed("*** ALERT ***\n"));
			printMessage(makeRed("New E-mail Recieved!\n"));
			printMessage("From: odin@valhalla.no\n");
			printMessage("Subject: Re:Re:Re:Re: Hello Warrior\n\n");
			printMessage("Ah, "+makeYellow(name)+" the "+makeYellow(profession)+". Yes, I remember you.\n");
			System.out.println();
			printMessage("I call upon you now "+makeYellow(name)+", to go and rid this universe of your mutating vessel.\n");
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
				//palm pilot joke
			
			printMessage("And here take "+makeBlue("these")+", you may find them useful on your quest.\n");
			Item soedekilling = new Item("Soedekilling", "A lyn-gladius", 8, "Weapon", 20, true);

			playSound("equip");
			printMessage(makeRed("Odin has bestowed upon thee, Soedekilling. \nA lyn-gladius that is given to novice warriors.\n"));
			printMessage(makeRed("Odin has also bestowed upon thee a ")+makeCyan("Palm Pilot")+makeRed(",\na relic from the ")+makePurple("Information Age")+makeRed(".\nYou can use this to update your map as you venture further.\n"));
			printMessage("Now careful, although your Palm Pilot will not effect you,\nanything you pick up on your journey will slow you down, and ruin your effectiveness in battle.\n");
			printMessage("Finally, remember that your keen "+ makeYellow(profession) +" instinct allows you to seek for \"help\" at any time.\n");

			printMessage("Now Go Warrior.\nYou will die in the process, but in doing so you will save the universe.\n");
			
			Thread.sleep(1000);
			System.out.println(CLEAN);
			
			//new player created with the inputed name and profession
				//health: 400
				//strength: 25
				//defense: 25
			Player player = new Player(name, profession, 400, 25, 25, soedekilling, null);			
			
			//Game loop
			while(play)
			{ 
				if(map.getCurrentRoom().equals(map.getRooms()[0][5]))
				{
					boss = true;
					map.look();
				}

				if(map.getCurrentRoom().getEnemy()!=null)
				{
					Person enemy=map.getCurrentRoom().getEnemy();
					printMessage("You have encountered "+makePurple(enemy.getName()) + " " + makePurple(enemy.getProfession()) +"\n");
					fight=true;

					while(fight)
					{	
						//get player input (for battle sequences)
						printMessage("\nWhat will you do, "+makeYellow(player.getName())+"?\n", 30);
						System.out.print(RED+ "> ");
						String input=keyboard.nextLine();
						System.out.print(RESET);
						input.toLowerCase();
						System.out.println("\n");
						
						if(input.contains("help")||input.equals("?")) {
							printMessage("'attack' or 'fight' : attacks the perilous foe.\n", 15);
							printMessage("'run' or 'flee' : abandon your viking virtues and run from battle.\n", 15);
							printMessage("'stats' or 'health' : view your's and your enemy's current condition.\n", 15);
						}
						
						else if(input.contains("run")||input.contains("flee"))
							printMessage("Oh I'm sorry. Clearly we've been mistaken and are "
									+"narrating the deeds of a perpetually "+makeYellow("SNIVELING COWARD")+", \nas opposed to a powerful "
									+ makeYellow(profession) +" embarking on a "+makeRed("VIKING") +" related journey \nin the cold and unforgiving "
									+makeCyan("VOID OF SPACE.")+" Would you also like a spiced latte \nand a foot massage on your way out?"
									+" Hm? No, I thought not. \nNow go back and fight.\n");
						
						else if(input.contains("fight")||input.contains("attack"))
						{
							int damageDealt = enemy.takeDamage(player.dealDamage());
							playSound("damage");
							printMessage("You dealt "+damageDealt+" damage to your opponent.\n");
							
							if(enemy.getHealth()>0) {
								int damageTaken = player.takeDamage(enemy.dealDamage());
								playSound("damage");
								printMessage("Your opponent dealt "+damageTaken+" damage to you\n");
							}
						} else if(input.contains("stats") || input.contains("health")) {
							printMessage("Player:\nHealth: " + player.getHealth()+ "/"+ player.getMaxHealth()+ "\nStrength: " + player.getStrength() + "\nDefense: " + player.getDefense()+ "\nInventory weight: "+ player.getInventoryWeight()+"/"+ player.getDefense()+ "\nEquiped Weapon: "+ player.getWeapon()+ "\n");
							printMessage("\nEnemy:\nHealth: " + map.getCurrentRoom().getEnemy().getHealth()+ "\nStrength: " + map.getCurrentRoom().getEnemy().getStrength() + "\nDefense: " + map.getCurrentRoom().getEnemy().getDefense()+ "\nEquiped Weapon: "+ map.getCurrentRoom().getEnemy().getWeapon()+ "\n");
						} else {
							playSound("error");
							printMessage("Now's not a very good time for that.\n");
						}
						
						if(enemy.getHealth()<=0 && boss==false)
						{
							playSound("enemydead");
							printMessage("You defeated "+makePurple(enemy.getName()) + " " + makePurple(enemy.getProfession()) +"\n");
							map.getCurrentRoom().setEnemy(null);
							fight=false;
							map.resetEnemies();
						}
						if(enemy.getHealth()<=0 && boss==true)
						{
							playSound("enemydead");
							printMessage("You defeated "+makePurple(enemy.getName()) + " " + makePurple(enemy.getProfession()) +"\n");
							map.getCurrentRoom().setEnemy(null);
							fight=false;
							map.resetEnemies();
							play=false;
							endgame();
						}				
						
						if(player.getHealth()<=0)
						{
							playSound("playerdead");
							printMessage("You were defeated by "+makePurple(enemy.getName()+ " the " + enemy.getProfession()) +"\n");
							play = false;
							printMessage("\nGAME OVER\n");
							fight = false;
						}
						
						if(!fight)
							player.heal((int)(0.05*player.getMaxHealth()));							
					}
				}
				
				//Get player input (non-battle sequences)
				if (play){
					printMessage("\nWhat will you do, "+makeYellow(player.getName())+"?\n", 30);
					System.out.print(CYAN + "> ");
					entry = keyboard.nextLine();
					System.out.print(RESET);
					entry.toLowerCase();
					System.out.println("\n");
				} else
					entry = "";
				
				if(entry.contains("help") || entry.equals("?")) {
					help();
				}
				else if (entry.contains("map") || entry.equals("m")) {
					System.out.println(map);
				}
				else if (entry.contains("inventory") || entry.contains("items") || entry.equals("i")) {
					inventory = true;
					while(inventory) {
						
						printMessage("What will you do with your inventory?\n");
						System.out.print(CYAN + "> ");
						entry = keyboard.nextLine();
						System.out.println(RESET);
						entry.toLowerCase();
						
						if (entry.contains("help") || entry.equals("?")) {
							
							printMessage("'see' or 's' : view the contents of your inventory\n", 15);
							printMessage("'use' or 'u' : use an item from your inventory\n", 15);
							printMessage("'equip' or 'e' : equip a weapon from your inventory\n", 15);
							printMessage("'drop' or 'd' : drop an item or weapon from yout inventory\n", 15);
							printMessage("'exit' : leave the inventory\n", 15);
						
						} else if (entry.contains("equip") || entry.equals("e")) {
							
							printMessage("What item would you like to equip?\nEnter the number of your selection:\n");
							for (int i = 0; i < player.getInventory().size(); i++)
								if (player.getInventory().get(i).getType().equals("Weapon"))
									printMessage((i + 1) + " - " + player.getInventory().get(i) + "\n");
							System.out.print(CYAN + "> ");
							int index = keyboard.nextInt() - 1;
							if(index >= player.getInventory().size()) {
								playSound("error");
								printMessage("You do not have that item.\n");
							}
							else if (!player.getInventory().get(index).getType().equals("Weapon")) {
								playSound("error");
								printMessage("You can only equip weapons, using the numbers above.");
							}
							else
							{
								//Return current item to inventory
								player.pickupItem(player.getWeapon());
								//Set weapon to selection
								player.setWeapon(player.getInventory().get(index));
								//Remove selection from inventory
								player.getInventory().remove(index);
								playSound("equip");
								printMessage(makeBlue(player.getWeapon().toString()) + " equipped.");
							}
							inventory = false;
							System.out.println(RESET);
							entry = keyboard.nextLine();
							
						} else if (entry.contains("drop") || entry.equals("d")) {
							
							printMessage("What item would you like to drop?\nEnter the number of your selection:\n");
							for (int i = 0; i < player.getInventory().size(); i++)
								printMessage((i + 1) + " - " + player.getInventory().get(i) + "\n");
							System.out.print(CYAN+ "> ");
							int index = keyboard.nextInt() - 1;
							if(index >= player.getInventory().size())
								printMessage("You do not have that item\n");
							else {
								printMessage(makeBlue(player.getInventory().get(index).getName()) + " dropped.");
								map.getCurrentRoom().addItems(player.getInventory().get(index));
								player.getInventory().remove(index);
								inventory = false;
							}
							System.out.println(RESET);
							entry = keyboard.nextLine();
							System.out.println();
							
						} else if (entry.contains("use") || entry.equals("u")) {
							
							printMessage("What item would you like to use?\nEnter the number of your selection:\n");
							for (int i = 0; i < player.getInventory().size(); i++)
								if (player.getInventory().get(i).getType().equals("Potion") || player.getInventory().get(i).getType().equals("Statue"))
									printMessage((i + 1) + " - " + player.getInventory().get(i)+ "\n");
							System.out.print(YELLOW+ "> ");
							int index = keyboard.nextInt() - 1;
							//error check
							if(index >= player.getInventory().size())
								printMessage("You do not have that item.\n");
							else if (player.getInventory().get(index).getName().equals("Health Potion")){
								playSound("potion");
								printMessage("You drank the potion and restored some health.");
								player.heal(player.getMaxHealth()/2);
							} else if (player.getInventory().get(index).getType().equals("Statue")){
								printMessage("The statue's blessings wash over you. You feel uncomfortably moist.\n");
								Item statue = player.getInventory().get(index);
								if (statue.getName().contains("Nisk")){
									player.setDefense(player.getDefense() + 10);
									player.setStrength(player.getStrength() + 5);
									playSound("potion");
									printMessage("Defense +10 Strength +5\n");
								} else if (statue.getName().contains("Caeven")){
									player.setStrength(player.getStrength() + 15);
									playSound("potion");
									printMessage("Strength +15\n");
								} else if (statue.getName().contains("Lockhaert")){
									player.setDefense(player.getDefense() + 10);
									player.setStrength(player.getStrength() + 5);
									playSound("potion");
									printMessage("Defense +10 Strength +5\n");
								} else if (statue.getName().contains("Traesk")){
									player.setMaxHealth(player.getMaxHealth() + 200);
									playSound("potion");
									printMessage("Max Health +200\n");
								} else if (statue.getName().contains("Duenn")){
									player.setDefense(player.getDefense() + 5);
									player.setMaxHealth(player.getMaxHealth() + 100);
									playSound("potion");
									printMessage("Defense +5 Max Health +100\n");
								}
							}
							inventory = false;
							if(index < player.getInventory().size())
								player.getInventory().remove(index);
							System.out.println(RESET);
							entry = keyboard.nextLine();
							
						} else if (entry.contains("see") || entry.contains("view") || entry.contains("look") || entry.equals("s")) {
							
							if (!player.getInventory().isEmpty()){
								for (int i = 0; i < player.getInventory().size(); i++){
									printMessage((i + 1) + " - " + player.getInventory().get(i) + "\n");
									printMessage("\t" + player.getInventory().get(i).getDetail() + "\n\t Weight: " + player.getInventory().get(i).getWeight());
									if (player.getInventory().get(i).getType().equals("Weapon"))
										printMessage("\n\t Damage: " + player.getInventory().get(i).getDataValue());
									printMessage("\n");
								}
								System.out.println();
							} else
								printMessage("There is nothing here.\n");
							
						} else if (entry.contains("exit")) {
							
							inventory = false;
							
						} else if (!entry.equals("")){
							playSound("error");
							printMessage("There is no time for that now.\n");
							
						}
					}
				}

				else if (entry.contains("look") || entry.equals("l")) {
					
					map.look();
					
				}
				else if (entry.contains("pick up") || entry.equals("p")) {
					
					if (!map.getCurrentRoom().getItems().isEmpty()){
						printMessage("Enter the number of your selection:\n");
						for (int i = 0; i < map.getCurrentRoom().getItems().size(); i++)
							printMessage((i + 1) + " - " + map.getCurrentRoom().getItems().get(i) + "\n");
						System.out.print(CYAN + "> ");
						int index = keyboard.nextInt() - 1;
						if(index >= map.getCurrentRoom().getItems().size()) {
							playSound("error");
							printMessage("There isn't that many items in the room.\n");
						}	
						else
						{
							printMessage(map.getCurrentRoom().getItems().get(index) + " picked up.\n");
							player.pickupItem(map.getCurrentRoom().getItems().get(index));
							map.getCurrentRoom().removeItems(index);
							entry = keyboard.nextLine();
						}
					} else {
						playSound("error");
						printMessage("There is nothing to pick up.");
					}
					System.out.println(RESET);
				
				}
				else if (entry.contains("north") || entry.equals("n")) {
					
					map.moveNorth();
				
				}
				else if (entry.contains("east") || entry.equals("e")) {
					
					map.moveEast();
				
				}
				else if (entry.contains("south") || entry.equals("s")) {
					
					map.moveSouth();
				
				}
				else if (entry.contains("west") || entry.equals("w")) {
					
					map.moveWest();
				
				}
				else if (entry.contains("unlock") || entry.equals("u")) {
					
					if(player.hasKey()) {
						map.unlock();
						player.deleteItem("Key");
						printMessage("You unlocked any locked doors in the rooom\n");
					} else
						printMessage("You have no keys to unlock with.\n");
				
				} else if(entry.equals("clean")||entry.equals("clear")) {
					
					System.out.println(CLEAN);
				
				} else if(entry.contains("stats") || entry.contains("health")) {
					
					printMessage("Health: " + player.getHealth()+ "/"+ player.getMaxHealth() + "\nStrength: " + player.getStrength() + "\nDefense: " + player.getDefense()+ 
							"\nInventory weight: "+ player.getInventoryWeight()+ "/"+ player.getStrength() + "\nEquipped weapon: "+ player.getWeapon()+ "\n");
				
				}
				
				//GOD MODE
				else if(entry.equals("):") || entry.equals(":(")) {
					playSound("god");
					player.setStrength(500);
					player.setDefense(500);
					player.setHealth(500);
					Item topDog = new Item("Digested Hot Dog of Death", "This stunning treasure is the most powerful weapon bestowed upon man. Digested by Odin himself!", 0, "weapon", 1000, true);
					player.pickupItem(topDog);
					player.setWeapon(topDog);
                    
				} else if (entry.equals("~") || entry.contains("cheat")){
					
					System.out.println("How do you want to break the game?\n");
					System.out.print(CYAN+ "> ");
					entry = keyboard.next();
					System.out.println(RESET);
					entry.toLowerCase();
					if (entry.equals("teleport")){
						int why, ecks;
						why = keyboard.nextInt();
						ecks = keyboard.nextInt();
						map.setCurrentRoom(map.getRooms()[why][ecks], why, ecks);
						map.getCurrentRoom().playerVisits();
						map.setAdjacentRooms();
						System.out.println(RESET);
						entry = keyboard.nextLine();
					}
					if(entry.equals("saxxy")) {
						playSound("saxxy");
					}
					
					if(entry.equals("dance")) {
						playSound("party");
					}
						
				} else if(entry.equals("quit")) {
					play = false;
				} else if (!entry.equals("")) {
					playSound("error");
					printMessage("There is no time for that now.\n");
				}

			}
			
			Thread.sleep(1000);
			System.out.println(CLEAN);
			
			//CREDITS
			printMessage("\n\n\n\n\t\tCredits");
			printMessage("\nGeoff Caven\t\tVice Admiral In Charge Of Breaking Shit");
			printMessage("\nAlex Dunn\t\tSad BoIIIIIIIII");
			printMessage("\nStanford Lockhart\tActual Cannibal Shia LeBeouf");
			printMessage("\nNiclas Skaaaaaluuuuuum  Liason to Asgard and Surrounding Suburbs");
			printMessage("\nMatthew Trask\t\tHead of Lard");
			printMessage("\n\n\t\tSpecial Thanks");
			printMessage("\nYung Lean");
			printMessage("\nECCO2K1");
			printMessage("\nSad Boys");
			printMessage("\nGravity Boys Shield Gang");
			printMessage("\nFidel Castro");
			printMessage("\nMalcolm Flannigan");
			printMessage("\nMalcolm in the Middle");
			printMessage("\nCookie");
			printMessage("\nStone Cold Steve Austin");
			printMessage("\nLard Lord");
			printMessage("\nGeoff says No");
			printMessage("\nThe RKO\n");
			Thread.sleep(1000);
			
		}
	}
	
	//Prints the set of options a user can input
	public static void help() throws InterruptedException {
		if(!fight) {
			//not battle inputs
			printMessage("'map' or 'm' : open your map (shows only previously visited and adjacent rooms)\n", 15);
			printMessage("'inventory' or 'i' : open inventory\n", 15);
			printMessage("'look' or 'l' : look at your surroundings\n", 15);
			printMessage("'pick up' or 'p' : pick up an item\n", 15);
			printMessage("'move north' or 'n' : move to the northern adjacent room (if valid)\n", 15);
			printMessage("'move east' or 'e' : move to the eastern adjacent room (if valid)\n", 15);
			printMessage("'move west' or 'w' : move to the western adjacent room (if valid)\n", 15);
			printMessage("'move south' or 's' : move to the southern adjacent room (if valid)\n", 15);
			printMessage("'unlock' or 'u' : unlocks an adjacent locked room\n", 15);
			printMessage("'stats' or 'health' : displays current character stats\n", 15);
			printMessage("\n", 15);
		} else {
			//battle inputs
			printMessage("'attack' or 'a' : attacks an enemy while in battle\n", 15);
			printMessage("'run' or 'run away' or 'flee' : flees from an enemy while in battle\n", 15);
		}
	}
	
	public static void loadUp() throws InterruptedException {
		printMessage("//////////////////////////////////BEGIN TRANSMISSION//////////////////////////////////\n\n", 15);
		printMessage("//////////////////////////////////LOAD UP ERROR RECIEVED//////////////////////////////////\n\n", 15);
		printMessage("*\n", 15);
		printMessage("(34wpCD error recieved)\n", 15);
		printMessage("//", 15);
		printMessage(".....\n", 150);
		printMessage("LOADING WINDOWS XP SERVICE PACK 4 >>>>>\n\n", 15);
		printMessage("kernel 4.5.2 \"SUPER SPACE\"\n", 15);
		printMessage("busting shell ghost\n", 15);
		printMessage("popping kernals\n\n", 15);
		printMessage("...\n", 165);
		printMessage("WINDOWS XP SERVICE PACK 4 BOOTUP COMPLETE::\n\n", 15);
		printMessage("forced wakeup pushed from 25.223.196.168:asgard\n\n", 15);
		printMessage("//////////////begin cryostasis wake up//////////////\n\n", 15);
		printMessage("initializing heart pump ", 15);
		printMessage("... ", 120);
		printMessage("done!\n", 15);
		printMessage("inflating lung[0] ", 15);
		printMessage("... ", 94);
		printMessage("done!\n", 15);		
		printMessage("inflating lung[1] ", 15);
		printMessage("... ", 77);
		printMessage("done!\n", 15);
		printMessage("initializing brain spark ", 15);
		printMessage("... ", 200);
		printMessage("failed!\n", 15);
		printMessage("\tinitializing brain spark ", 15);
		printMessage("... ", 100);
		printMessage("done!\n\n");
		printMessage("ping central nervous system\n\t", 15);
		printMessage("...\n\ttimeout 100% packet loss\n\n", 15);
		printMessage("//////////////check ship status//////////////\n\n", 15);
		printMessage("touch NS.bridge:\n\t", 15);
		printMessage("status- 404 bridge not found\n\t", 15);
		printMessage("non-functional\n\n", 15);
		printMessage("touch NS.hull:\n\t", 15);
		printMessage("status- totally gnasty\n\t", 15);
		printMessage("non-functional\n\n", 15);
		printMessage("touch NS.mess:\n\t", 15);
		printMessage("status- lil dirty\n\t", 15);
		printMessage("functional\n\n", 15);
		printMessage("touch NS.core:\n\t", 15);
		printMessage("status- spewing radiation\n\t", 15);
		printMessage("subnominal\n\n", 15);
		printMessage("//////////////Ship check complete//////////////\n\n", 15);
		printMessage("//////////////cryostasis wakeup complete//////////////\n\n", 15);
		printMessage("initializing email client");
		printMessage("... \n", 175);
		System.out.println(CLEAN);
		
	}
	
	public static void endgame() throws InterruptedException {
		printMessage("\n\nAs you strike the final blow, the core dissolves into a puddle of " + makeGreen("radioactive slag") + ".\n");
		printMessage("The ship suddenly loses power, which was evidently being provided by the core.\nYou feel your feet lift off of the ground as the artificial gravity disengages.\n");
		printMessage("A sudden realization: This ship is orbiting a fierce " +  makeRed("Red Giant Star") + ",\nand without the core powering the gravity drive\nyou will very shortly be plunged into the nuclear heart of the aformentioned " + makeRed("star") +  ".\n");
		printMessage("As the ship begins to fall, you are comforted to know that you have completed your mission.\n");
		printMessage(makeCyan("\nThe universe is safe.\n"),100);
		Thread.sleep(1000);
		System.out.println(CLEAN);
		printMessage("\n\n" + makeYellow("Stellar altitude dropping,\nsuborbital trajectory detected.\nReccomend immeadiate evacuation\nEscape pods offline\nPeril level 100"), 25);
		Thread.sleep(500);
		System.out.println(CLEAN);
		printMessage(makeRed("*** ALERT ***\n"),25);
		printMessage(makeRed("New E-mail Recieved!\n"),25);
		printMessage("From: odin@valhalla.no\n",25);
		printMessage("Subject: null\n\n",25);
		printMessage("Goodbye, warrior\nYou have done well.");
		Thread.sleep(500);
		printMessage(makeRed("\n\nHeat threshold exceeded, terminating commlink to 25.223.196.168:asgard"), 25);
		printMessage("\n\n//////////////////////////////////END TRANSMISSION//////////////////////////////////", 15);
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
	
	//method keeping all possible playable sounds in one place. Keep rest of code clean
	public static void playSound(String s) {
		if(s.equals("damage")) {
			AudioClip[] damage= new AudioClip[4];
			Random gen= new Random();	//select a random damage noise to play
			try {
				damage[0]= Applet.newAudioClip(new URL("file:Music/damage0.wav"));
				damage[1]= Applet.newAudioClip(new URL("file:Music/damage1.wav"));
				damage[2]= Applet.newAudioClip(new URL("file:Music/damage2.wav"));
				damage[3]= Applet.newAudioClip(new URL("file:Music/damage3.wav"));
				
				int rand= gen.nextInt(4);
				damage[rand].play();
			}
			catch (Exception e) {
				System.err.println(e);
			}
		}
		
		if(s.equals("equip")) {
			try {
				AudioClip equip= Applet.newAudioClip(new URL("file:Music/equip.wav"));
				equip.play();
			}
			catch(Exception e) {
				System.err.println(e);
			}
		}
		if(s.equals("error")) {
			try {
				AudioClip error= Applet.newAudioClip(new URL("file:Music/Error.wav"));
				error.play();
			}
			catch(Exception e) {
				System.err.println(e);
			}
		}
		
		if(s.equals("god")) {
			try {
				AudioClip godMode= Applet.newAudioClip(new URL("file:Music/GODMODE.wav"));
				godMode.play();
			}
			catch(Exception e) {
				System.err.println(e);
			}
		}
		
		if(s.equals("enemydead")) {
			try {
				AudioClip death= Applet.newAudioClip(new URL("file:Music/enemyDeath.wav"));
				death.play();
			}
			catch(Exception e) {
				System.err.println(e);
			}
		}
		
		if(s.equals("load")) {
			try {
				AudioClip loading= Applet.newAudioClip(new URL("file:Music/LOADUP.wav"));
				loading.play();
			}
			catch(Exception e) {
				System.err.println(e);
			}
		}
		
		if(s.equals("playerdead")) {
			try {
				AudioClip death= Applet.newAudioClip(new URL("file:Music/Player_Death.wav"));
				death.play();
			}
			catch(Exception e) {
				System.err.println(e);
			}
		}
		
		if(s.equals("potion")) {
			try {
				AudioClip heal= Applet.newAudioClip(new URL("file:Music/potion.wav"));
				heal.play();
			}
			catch(Exception e) {
				System.err.println(e);
			}
		}
		
		if(s.equals("saxxy")) {
			try {
				AudioClip cheaty= Applet.newAudioClip(new URL("file:Music/saxxy.wav"));
				cheaty.loop();
			}
			catch(Exception e) {
				System.err.println(e);
			}
		}
		
		if(s.equals("send")) {
			try {
				AudioClip dial= Applet.newAudioClip(new URL("file:Music/Sending.wav"));
				dial.play();
			}
			catch(Exception e) {
				System.err.println(e);
			}
		}
		
		if(s.equals("party")) {
			try {
				AudioClip funk= Applet.newAudioClip(new URL("file:Music/Who Likes to Party.wav"));
				funk.loop();
			}
			catch(Exception e) {
				System.err.println(e);
			}
		}
		
	}
	
	//methods to change colours of strings in terminal
	public static String makeBlack(String s) {
		return BLACK+ s.toUpperCase() + RESET;
	}
	public static String makeRed(String s) {
		return RED+ s.toUpperCase() + RESET;
	}
	public static String makeGreen(String s) {
		return GREEN+ s.toUpperCase() + RESET;
	}
	public static String makeYellow(String s) {
		return YELLOW+ s.toUpperCase() + RESET;
	}
	public static String makeBlue(String s) {
		return BLUE+ s.toUpperCase() + RESET;
	}
	public static String makePurple(String s) {
		return PURPLE+ s.toUpperCase() + RESET;
	}
	public static String makeCyan(String s) {
		return CYAN+ s.toUpperCase() + RESET;
	}
	public static String makeWhite(String s) {
		return WHITE+ s.toUpperCase() + RESET;
	}
	public static String makeHidden(String s) {
		return HIDDEN+ s + RESET;
	}
}
