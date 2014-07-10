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
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.Random;

import javax.swing.*;

public class Game extends JFrame implements ActionListener{
	
	public static boolean play;
	public static boolean fight;
	public static boolean inventory;
	public static boolean boss = false;
	public static String RESET = "</span>";
	public static String BLACK = "<span style=\"color:rgb(0,0,0)\">";
	public static String RED = "<span style=\"color:rgb(255,0,0)\">";
	public static String GREEN = "<span style=\"color:rgb(0,255,0)\">";
	public static String YELLOW = "<span style=\"color:rgb(255,255,0)\">";
	public static String BLUE = "<span style=\"color:rgb(0,0,255)\">";
	public static String PURPLE = "<span style=\"color:rgb(255,0,255)\">";
	public static String CYAN = "<span style=\"color:rgb(0,255,255)\">";
	public static String WHITE = "<span style=\"color:rgb(255,255,255)\">";
	public static String CLEAN = "<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>";
	public static String HIDDEN= "";
	public static JPanel panel;
	public static JLabel console = new JLabel();
	public static JTextField text = new JTextField();
	public static String userInput = "";
	public static boolean flag = false;
	
	public Game(){
		
		panel = new JPanel(new BorderLayout());
		panel.setBackground(Color.BLACK);
		console.setPreferredSize(new Dimension(800, 450));
		console.setText("<html>");
		console.setFont(new Font("Courier New", Font.PLAIN, 12));
		console.setForeground(Color.WHITE);
		console.setHorizontalTextPosition(JLabel.LEFT);
		console.setVerticalTextPosition(JLabel.BOTTOM);
		console.setHorizontalAlignment(JLabel.LEFT);
		console.setVerticalAlignment(JLabel.BOTTOM);
		console.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		text.setBackground(Color.BLACK);
		text.setForeground(Color.WHITE);
//		UIManager.put("TextField.font", new Font("Courier New", Font.PLAIN, 12));
		text.setFont(new Font("Courier New", Font.PLAIN, 15));
		text.addActionListener(this);
		panel.add(console, BorderLayout.NORTH);
		panel.add(text, BorderLayout.SOUTH);
		add(panel);
		setTitle("Space Viking");
		setSize(800, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		Game game = new Game();
		
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
		
		console.setText("<html>");

		printMessage("A Blessed Boys production:<br>");
		printMessage("<br>", 0);
		printMessage("<br>", 0);
		printMessage("&#160;&#160;&#160;_____&#160;____&#160;&#160;___&#160;&#160;&#160;____________&#160;&#160;&#160;_&#160;&#160;&#160;&#160;________&#160;__&#160;_____&#160;&#160;&#160;________<br>", 0);
		printMessage("&#160;&#160;/&#160;___//&#160;__&#160;\\/&#160;&#160;&#160;|&#160;/&#160;____/&#160;____/&#160;&#160;|&#160;|&#160;&#160;/&#160;/&#160;&#160;_/&#160;//_//&#160;&#160;_/&#160;|&#160;/&#160;/&#160;____/<br>", 0);
		printMessage("&#160;&#160;\\__&#160;\\/&#160;/_/&#160;/&#160;/|&#160;|/&#160;/&#160;&#160;&#160;/&#160;__/&#160;&#160;&#160;&#160;&#160;|&#160;|&#160;/&#160;//&#160;//&#160;.&#160;/&#160;&#160;/&#160;//&#160;&#160;|/&#160;/&#160;/&#160;__&#160;&#160;<br>", 0);
		printMessage("&#160;___/&#160;/&#160;____/&#160;___&#160;/&#160;/___/&#160;/___&#160;&#160;&#160;&#160;&#160;|&#160;|/&#160;//&#160;//&#160;/|&#160;|_/&#160;//&#160;/|&#160;&#160;/&#160;/_/&#160;/&#160;&#160;<br>", 0);
		printMessage("/____/_/&#160;&#160;&#160;/_/&#160;&#160;|_\\____/_____/&#160;&#160;&#160;&#160;&#160;|___/___/_/&#160;|_/___/_/&#160;|_/\\____/&#160;&#160;&#160;<br>", 0);
		printMessage("<br>", 0);
		printMessage("&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;<br>", 0);
		printMessage("Press Enter to Continue.<br>");
		
		play = true;

		waitForUser();
		
		//creates the map
		Map map = new Map();
		
		//clears the console for a visually blank start
		console.setText("<html>");
		
		loadUp();
		playSound("load");
		
		//First email
		printMessage(makeRed("*** ALERT ***<br>"),25);
		printMessage(makeRed("New E-mail Recieved!<br>"),25);
		printMessage("From: odin@valhalla.no<br>",25);
		printMessage("Subject: Hello Warrior<br>",25);
		printMessage("<br>", 0);
		printMessage("Hello Warrior.<br>");
		printMessage("I am "+makeRed("Odin")+", The All-Father. You have been in cryostasis since the "+makePurple("Information Age")+".<br>");
		printMessage("It is the year "+makePurple("20XX PA (Post-Armageddon)")+", and you are drifting aboard the "+makeCyan("NS Fjord VValkyrie")+".<br>");
		printMessage("Your vessel and crew have succumb to a "+makeYellow("terrible fate")+".<br>");
		printMessage("<br>", 0);
		printMessage("Your crew was returning home from a raid on "+makeGreen("Neo-Dublin")+"<br>");
		printMessage("when an unexpected nuclear fish-salting accident occurred and the main core overheated and caused<br>");
		printMessage("a great explosion.<br>");
		printMessage("<br>", 0);
		printMessage("Every member of your crew was either mutated or killed in the explosion<br>");
		printMessage("and are now roaming the halls of this vessel, and may prove "+makeRed("dangerous")+".<br>");
		printMessage("<br>", 0);
		
		//user's character inputs
		printMessage("What would you like me to "+makeYellow("call")+" you, Warrior?<br>");
		printMessage("<br>", 0);
		printMessage(makeGreen("*** DRAFTING ***<br>"),25);
		printMessage("To: odin@valhalla.no<br>",25);
		printMessage("Subject: Re: Hello Warrior<br>",25);
		waitForUser();
		String name = userInput;
		printMessage("<br>Sending");
		playSound("send");
		printMessage("..........", 125);
		printMessage(" Sent!<br>");
		Thread.sleep(1000);
		console.setText("<html>");
		
		//Next email
		printMessage(makeRed("*** ALERT ***<br>"),25);
		printMessage(makeRed("New E-mail Recieved!<br>"),25);
		printMessage("From: odin@valhalla.no<br>",25);
		printMessage("Subject: Re:Re: Hello Warrior<br><br>",25);
		printMessage(makeYellow(name)+". An interesting name indeed. What is your "+makeYellow("title")+"?<br>");
		printMessage("<br>", 0);

		printMessage(makeGreen("*** DRAFTING ***<br>"),25);
		
		//User's second input field
		printMessage("To: odin@valhalla.no<br>",25);
		printMessage("Subject: Re:Re:Re: Hello Warrior<br>",25);
		waitForUser();
		String profession = userInput;
		printMessage("<br>Sending");
		playSound("send");
		printMessage("..........", 125);
		printMessage(" Sent!<br>");
		Thread.sleep(1000);
		console.setText("<html>");

		//Third email
		printMessage(makeRed("*** ALERT ***<br>"));
		printMessage(makeRed("New E-mail Recieved!<br>"));
		printMessage("From: odin@valhalla.no<br>");
		printMessage("Subject: Re:Re:Re:Re: Hello Warrior<br><br>");
		printMessage("Ah, "+makeYellow(name)+" the "+makeYellow(profession)+". Yes, I remember you.<br>");
		printMessage("<br>", 0);
		printMessage("I call upon you now "+makeYellow(name)+", to go and rid this universe of your mutating vessel.<br>");
		printMessage("You must reach the core and destroy it for good and finish this.<br>");
		printMessage("<br>", 0);
		
		//prints the entire map
			//when map is viewed during the actual game only previously visited rooms
			//and adjacent rooms will show
		printMessage("Here on the wall is a map of the "+makeCyan("NSFVV")+", I have marked your position with a pre-age symbol: *<br>");
		printMessage("It should look familiar to your time, it is called an asterisk.<br>");
		printMessage("<br>", 0);
		printMessage(map.fullMap(), 0);
		printMessage("<br>", 0);
		printMessage("This map will not be available to you after you leave this room, you will have<br>");
		printMessage("to mark each room after you've visited them. ");
		printMessage("This is what your map will normally look like:<br>");
		printMessage("<br>", 0);
		printMessage(map.toString(), 0);
		printMessage("<br>", 0);
		

		//receive first weapon
			//palm pilot joke
		
		printMessage("And here take "+makeBlue("these")+", you may find them useful on your quest.<br>");
		Item soedekilling = new Item("Soedekilling", "A lyn-gladius", 8, "Weapon", 20, true);

		playSound("equip");
		printMessage(makeRed("Odin has bestowed upon thee, Soedekilling. <br>A lyn-gladius that is given to novice warriors.<br>"));
		printMessage(makeRed("Odin has also bestowed upon thee a ")+makeCyan("Palm Pilot")+makeRed(",<br>a relic from the ")+makePurple("Information Age")+makeRed(".<br>You can use this to update your map as you venture further.<br>"));
		printMessage("Now careful, although your Palm Pilot will not effect you,<br>anything you pick up on your journey will slow you down, and ruin your effectiveness in battle.<br>");
		printMessage("Finally, remember that your keen "+ makeYellow(profession) +" instinct allows you to seek for \"help\" at any time.<br>");

		printMessage("Now Go Warrior.<br>You will die in the process, but in doing so you will save the universe.<br>");
		
		Thread.sleep(1000);
		console.setText("<html>");
		
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
				printMessage("You have encountered "+makePurple(enemy.getName()) + " " + makePurple(enemy.getProfession()) +"<br>");
				fight=true;

				while(fight)
				{	
					//get player input (for battle sequences)
					printMessage("<br>What will you do, "+makeYellow(player.getName())+"?<br>", 30);
					printMessage(RED+ "> ");
					waitForUser();
					String input = userInput;
					printMessage(RESET);
					input.toLowerCase();
					printMessage("<br><br>", 0);
					
					if(input.contains("help")||input.equals("?")) {
						printMessage("'attack' or 'fight' : attacks the perilous foe.<br>", 15);
						printMessage("'run' or 'flee' : abandon your viking virtues and run from battle.<br>", 15);
						printMessage("'stats' or 'health' : view your's and your enemy's current condition.<br>", 15);
					}
					
					else if(input.contains("run")||input.contains("flee"))
						printMessage("Oh I'm sorry. Clearly we've been mistaken and are "
								+"narrating the deeds of a perpetually "+makeYellow("SNIVELING COWARD")+", <br>as opposed to a powerful "
								+ makeYellow(profession) +" embarking on a "+makeRed("VIKING") +" related journey <br>in the cold and unforgiving "
								+makeCyan("VOID OF SPACE.")+" Would you also like a spiced latte <br>and a foot massage on your way out?"
								+" Hm? No, I thought not. <br>Now go back and fight.<br>");
					
					else if(input.contains("fight")||input.contains("attack"))
					{
						int damageDealt = enemy.takeDamage(player.dealDamage());
						playSound("damage");
						printMessage("You dealt "+damageDealt+" damage to your opponent.<br>");
						
						if(enemy.getHealth()>0) {
							int damageTaken = player.takeDamage(enemy.dealDamage());
							playSound("damage");
							printMessage("Your opponent dealt "+damageTaken+" damage to you<br>");
						}
					} else if(input.contains("stats") || input.contains("health")) {
						printMessage("Player:<br>Health: " + player.getHealth()+ "/"+ player.getMaxHealth()+ "<br>Strength: " + player.getStrength() + "<br>Defense: " + player.getDefense()+ "<br>Inventory weight: "+ player.getInventoryWeight()+"/"+ player.getDefense()+ "<br>Equiped Weapon: "+ player.getWeapon()+ "<br>");
						printMessage("<br>Enemy:<br>Health: " + map.getCurrentRoom().getEnemy().getHealth()+ "<br>Strength: " + map.getCurrentRoom().getEnemy().getStrength() + "<br>Defense: " + map.getCurrentRoom().getEnemy().getDefense()+ "<br>Equiped Weapon: "+ map.getCurrentRoom().getEnemy().getWeapon()+ "<br>");
					} else {
						playSound("error");
						printMessage("Now's not a very good time for that.<br>");
					}
					
					if(enemy.getHealth()<=0 && boss==false)
					{
						playSound("enemydead");
						printMessage("You defeated "+makePurple(enemy.getName()) + " " + makePurple(enemy.getProfession()) +"<br>");
						map.getCurrentRoom().setEnemy(null);
						fight=false;
						map.resetEnemies();
					}
					if(enemy.getHealth()<=0 && boss==true)
					{
						playSound("enemydead");
						printMessage("You defeated "+makePurple(enemy.getName()) + " " + makePurple(enemy.getProfession()) +"<br>");
						map.getCurrentRoom().setEnemy(null);
						fight=false;
						map.resetEnemies();
						play=false;
						endgame();
					}				
					
					if(player.getHealth()<=0)
					{
						playSound("playerdead");
						printMessage("You were defeated by "+makePurple(enemy.getName()+ " the " + enemy.getProfession()) +"<br>");
						play = false;
						printMessage("<br>GAME OVER<br>");
						fight = false;
					}
					
					if(!fight)
						player.heal((int)(0.05*player.getMaxHealth()));							
				}
			}
			
			//Get player input (non-battle sequences)
			if (play){
				printMessage("<br>What will you do, "+makeYellow(player.getName())+"?<br>", 30);
				printMessage(CYAN + "> ");
				waitForUser();
				entry = userInput;
				printMessage(RESET);
				entry.toLowerCase();
				printMessage("<br>");
			} else
				entry = "";
			
			if(entry.contains("help") || entry.equals("?")) {
				help();
			}
			else if (entry.contains("map") || entry.equals("m")) {
				printMessage(map.toString(), 0);
			}
			else if (entry.contains("inventory") || entry.contains("items") || entry.equals("i")) {
				inventory = true;
				while(inventory) {
					
					printMessage("What will you do with your inventory?<br>");
					printMessage(CYAN + "> ");
					waitForUser();
					entry = userInput;
					printMessage(RESET);
					entry.toLowerCase();
					
					if (entry.contains("help") || entry.equals("?")) {
						
						printMessage("'see' or 's' : view the contents of your inventory<br>", 15);
						printMessage("'use' or 'u' : use an item from your inventory<br>", 15);
						printMessage("'equip' or 'e' : equip a weapon from your inventory<br>", 15);
						printMessage("'drop' or 'd' : drop an item or weapon from yout inventory<br>", 15);
						printMessage("'exit' : leave the inventory<br>", 15);
					
					} else if (entry.contains("equip") || entry.equals("e")) {
						
						printMessage("What item would you like to equip?<br>Enter the number of your selection:<br>");
						for (int i = 0; i < player.getInventory().size(); i++)
							if (player.getInventory().get(i).getType().equals("Weapon"))
								printMessage((i + 1) + " - " + player.getInventory().get(i) + "<br>");
						printMessage(CYAN + "> ");
						
						waitForUser();
						Integer index = null;
						while (index == null){
							try {
								index = Integer.parseInt(userInput) - 1;
							} catch (NumberFormatException e) {
								printMessage("Please enter a number.");
							}
						}

						if(index >= player.getInventory().size()) {
							playSound("error");
							printMessage("You do not have that item.<br>");
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
						printMessage(RESET);
						
					} else if (entry.contains("drop") || entry.equals("d")) {
						
						printMessage("What item would you like to drop?<br>Enter the number of your selection:<br>");
						for (int i = 0; i < player.getInventory().size(); i++)
							printMessage((i + 1) + " - " + player.getInventory().get(i) + "<br>");
						printMessage(CYAN+ "> ");
						
						waitForUser();
						Integer index = null;
						while (index == null){
							try {
								index = Integer.parseInt(userInput) - 1;
							} catch (NumberFormatException e) {
								printMessage("Please enter a number.");
							}
						}
						
						if(index >= player.getInventory().size())
							printMessage("You do not have that item<br>");
						else {
							printMessage(makeBlue(player.getInventory().get(index).getName()) + " dropped.");
							map.getCurrentRoom().addItems(player.getInventory().get(index));
							player.getInventory().remove(index);
							inventory = false;
						}
						printMessage(RESET);
						printMessage("<br>", 0);
						
					} else if (entry.contains("use") || entry.equals("u")) {
						
						printMessage("What item would you like to use?<br>Enter the number of your selection:<br>");
						for (int i = 0; i < player.getInventory().size(); i++)
							if (player.getInventory().get(i).getType().equals("Potion") || player.getInventory().get(i).getType().equals("Statue"))
								printMessage((i + 1) + " - " + player.getInventory().get(i)+ "<br>");
						printMessage(YELLOW+ "> ");
						
						waitForUser();
						Integer index = null;
						while (index == null){
							try {
								index = Integer.parseInt(userInput) - 1;
							} catch (NumberFormatException e) {
								printMessage("Please enter a number.");
							}
						}
						
						//error check
						if(index >= player.getInventory().size())
							printMessage("You do not have that item.<br>");
						else if (player.getInventory().get(index).getName().equals("Health Potion")){
							playSound("potion");
							printMessage("You drank the potion and restored some health.");
							player.heal(player.getMaxHealth()/2);
						} else if (player.getInventory().get(index).getType().equals("Statue")){
							printMessage("The statue's blessings wash over you. You feel uncomfortably moist.<br>");
							Item statue = player.getInventory().get(index);
							if (statue.getName().contains("Nisk")){
								player.setDefense(player.getDefense() + 10);
								player.setStrength(player.getStrength() + 5);
								playSound("potion");
								printMessage("Defense +10 Strength +5<br>");
							} else if (statue.getName().contains("Caeven")){
								player.setStrength(player.getStrength() + 15);
								playSound("potion");
								printMessage("Strength +15<br>");
							} else if (statue.getName().contains("Lockhaert")){
								player.setDefense(player.getDefense() + 10);
								player.setStrength(player.getStrength() + 5);
								playSound("potion");
								printMessage("Defense +10 Strength +5<br>");
							} else if (statue.getName().contains("Traesk")){
								player.setMaxHealth(player.getMaxHealth() + 200);
								playSound("potion");
								printMessage("Max Health +200<br>");
							} else if (statue.getName().contains("Duenn")){
								player.setDefense(player.getDefense() + 5);
								player.setMaxHealth(player.getMaxHealth() + 100);
								playSound("potion");
								printMessage("Defense +5 Max Health +100<br>");
							}
						}
						inventory = false;
						if(index < player.getInventory().size())
							player.getInventory().remove(index);
						printMessage(RESET);
						
					} else if (entry.contains("see") || entry.contains("view") || entry.contains("look") || entry.equals("s")) {
						
						if (!player.getInventory().isEmpty()){
							for (int i = 0; i < player.getInventory().size(); i++){
								printMessage((i + 1) + " - " + player.getInventory().get(i) + "<br>");
								printMessage("&#160;&#160;&#160;&#160;&#160;" + player.getInventory().get(i).getDetail() + "<br>&#160;&#160;&#160;&#160;&#160; Weight: " + player.getInventory().get(i).getWeight());
								if (player.getInventory().get(i).getType().equals("Weapon"))
									printMessage("<br>&#160;&#160;&#160;&#160;&#160; Damage: " + player.getInventory().get(i).getDataValue());
								printMessage("<br>");
							}
							printMessage("<br>", 0);
						} else
							printMessage("There is nothing here.<br>");
						
					} else if (entry.contains("exit")) {
						
						inventory = false;
						
					} else if (!entry.equals("")){
						playSound("error");
						printMessage("There is no time for that now.<br>");
						
					}
				}
			}

			else if (entry.contains("look") || entry.equals("l")) {
				
				map.look();
				
			}
			else if (entry.contains("pick up") || entry.equals("p")) {
				
				if (!map.getCurrentRoom().getItems().isEmpty()){
					printMessage("Enter the number of your selection:<br>");
					for (int i = 0; i < map.getCurrentRoom().getItems().size(); i++)
						printMessage((i + 1) + " - " + map.getCurrentRoom().getItems().get(i) + "<br>");
					printMessage(CYAN + "> ");

					waitForUser();
					Integer index = null;
					while (index == null){
						try {
							index = Integer.parseInt(userInput) - 1;
						} catch (NumberFormatException e) {
							printMessage("Please enter a number.");
						}
					}
					
					if(index >= map.getCurrentRoom().getItems().size()) {
						playSound("error");
						printMessage("There isn't that many items in the room.<br>");
					}	
					else
					{
						printMessage(map.getCurrentRoom().getItems().get(index) + " picked up.<br>");
						player.pickupItem(map.getCurrentRoom().getItems().get(index));
						map.getCurrentRoom().removeItems(index);
					}
				} else {
					playSound("error");
					printMessage("There is nothing to pick up.");
				}
				printMessage(RESET);
			
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
					printMessage("You unlocked any locked doors in the rooom<br>");
				} else
					printMessage("You have no keys to unlock with.<br>");
			
			} else if(entry.equals("clean")||entry.equals("clear")) {
				
				console.setText("<html>");
			
			} else if(entry.contains("stats") || entry.contains("health")) {
				
				printMessage("Health: " + player.getHealth()+ "/"+ player.getMaxHealth() + "<br>Strength: " + player.getStrength() + "<br>Defense: " + player.getDefense()+ 
						"<br>Inventory weight: "+ player.getInventoryWeight()+ "/"+ player.getStrength() + "<br>Equipped weapon: "+ player.getWeapon()+ "<br>");
			
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
				
				printMessage("How do you want to break the game?<br>", 0);
				printMessage(CYAN+ "> ");
				waitForUser();
				entry = userInput;
				printMessage(RESET);
				entry.toLowerCase();
				Integer why = null, ecks = null;
				if (entry.equals("teleport")){
					waitForUser();
					while (why == null){
						try {
							why = Integer.parseInt(userInput) - 1;
						} catch (NumberFormatException e) {
							printMessage("Please enter a number.");
						}
					}
					waitForUser();
					while (ecks == null){
						try {
							ecks = Integer.parseInt(userInput) - 1;
						} catch (NumberFormatException e) {
							printMessage("Please enter a number.");
						}
					}
					map.setCurrentRoom(map.getRooms()[why][ecks], why, ecks);
					map.getCurrentRoom().playerVisits();
					map.setAdjacentRooms();
					printMessage(RESET);
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
				printMessage("There is no time for that now.<br>");
			}

		}
		
		Thread.sleep(1000);
		console.setText("<html>");
		
		//CREDITS
		printMessage("<br><br><br><br>&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;Credits");
		printMessage("<br>Geoff Caven&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;Vice Admiral In Charge Of Breaking Shit");
		printMessage("<br>Alex Dunn&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;Sad BoIIIIIIIII");
		printMessage("<br>Stanford Lockhart&#160;&#160;&#160;&#160;&#160;Actual Cannibal Shia LeBeouf");
		printMessage("<br>Niclas Skaaaaaluuuuuum  Liason to Asgard and Surrounding Suburbs");
		printMessage("<br>Matthew Trask&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;Head of Lard");
		printMessage("<br><br>&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;Special Thanks");
		printMessage("<br>Yung Lean");
		printMessage("<br>ECCO2K1");
		printMessage("<br>Sad Boys");
		printMessage("<br>Gravity Boys Shield Gang");
		printMessage("<br>Fidel Castro");
		printMessage("<br>Malcolm Flannigan");
		printMessage("<br>Malcolm in the Middle");
		printMessage("<br>Cookie");
		printMessage("<br>Stone Cold Steve Austin");
		printMessage("<br>Lard Lord");
		printMessage("<br>Geoff says No");
		printMessage("<br>The RKO<br>");
		Thread.sleep(1000);
	}
	
	private static void waitForUser() throws InterruptedException {
		while (!flag){
			Thread.sleep(10);
		}
		
		flag = false;
	}

	//Prints the set of options a user can input
	public static void help() throws InterruptedException {
		if(!fight) {
			//not battle inputs
			printMessage("'map' or 'm' : open your map (shows only previously visited and adjacent rooms)<br>", 15);
			printMessage("'inventory' or 'i' : open inventory<br>", 15);
			printMessage("'look' or 'l' : look at your surroundings<br>", 15);
			printMessage("'pick up' or 'p' : pick up an item<br>", 15);
			printMessage("'move north' or 'n' : move to the northern adjacent room (if valid)<br>", 15);
			printMessage("'move east' or 'e' : move to the eastern adjacent room (if valid)<br>", 15);
			printMessage("'move west' or 'w' : move to the western adjacent room (if valid)<br>", 15);
			printMessage("'move south' or 's' : move to the southern adjacent room (if valid)<br>", 15);
			printMessage("'unlock' or 'u' : unlocks an adjacent locked room<br>", 15);
			printMessage("'stats' or 'health' : displays current character stats<br>", 15);
			printMessage("<br>", 15);
		} else {
			//battle inputs
			printMessage("'attack' or 'a' : attacks an enemy while in battle<br>", 15);
			printMessage("'run' or 'run away' or 'flee' : flees from an enemy while in battle<br>", 15);
		}
	}
	
	public static void loadUp() throws InterruptedException {
		printMessage("//////////////////////////////////BEGIN TRANSMISSION//////////////////////////////////<br><br>", 15);
		printMessage("//////////////////////////////////LOAD UP ERROR RECIEVED//////////////////////////////////<br><br>", 15);
		printMessage("*<br>", 15);
		printMessage("(34wpCD error recieved)<br>", 15);
		printMessage("//", 15);
		printMessage(".....<br>", 150);
		printMessage("LOADING WINDOWS XP SERVICE PACK 4 >>>>><br><br>", 15);
		printMessage("kernel 4.5.2 \"SUPER SPACE\"<br>", 15);
		printMessage("busting shell ghost<br>", 15);
		printMessage("popping kernals<br><br>", 15);
		printMessage("...<br>", 165);
		printMessage("WINDOWS XP SERVICE PACK 4 BOOTUP COMPLETE::<br><br>", 15);
		printMessage("forced wakeup pushed from 25.223.196.168:asgard<br><br>", 15);
		printMessage("//////////////begin cryostasis wake up//////////////<br><br>", 15);
		printMessage("initializing heart pump ", 15);
		printMessage("... ", 120);
		printMessage("done!<br>", 15);
		printMessage("inflating lung[0] ", 15);
		printMessage("... ", 94);
		printMessage("done!<br>", 15);		
		printMessage("inflating lung[1] ", 15);
		printMessage("... ", 77);
		printMessage("done!<br>", 15);
		printMessage("initializing brain spark ", 15);
		printMessage("... ", 200);
		printMessage("failed!<br>", 15);
		printMessage("&#160;&#160;&#160;&#160;&#160;initializing brain spark ", 15);
		printMessage("... ", 100);
		printMessage("done!<br><br>");
		printMessage("ping central nervous system<br>&#160;&#160;&#160;&#160;&#160;", 15);
		printMessage("...<br>&#160;&#160;&#160;&#160;&#160;timeout 100% packet loss<br><br>", 15);
		printMessage("//////////////check ship status//////////////<br><br>", 15);
		printMessage("touch NS.bridge:<br>&#160;&#160;&#160;&#160;&#160;", 15);
		printMessage("status- 404 bridge not found<br>&#160;&#160;&#160;&#160;&#160;", 15);
		printMessage("non-functional<br><br>", 15);
		printMessage("touch NS.hull:<br>&#160;&#160;&#160;&#160;&#160;", 15);
		printMessage("status- totally gnasty<br>&#160;&#160;&#160;&#160;&#160;", 15);
		printMessage("non-functional<br><br>", 15);
		printMessage("touch NS.mess:<br>&#160;&#160;&#160;&#160;&#160;", 15);
		printMessage("status- lil dirty<br>&#160;&#160;&#160;&#160;&#160;", 15);
		printMessage("functional<br><br>", 15);
		printMessage("touch NS.core:<br>&#160;&#160;&#160;&#160;&#160;", 15);
		printMessage("status- spewing radiation<br>&#160;&#160;&#160;&#160;&#160;", 15);
		printMessage("subnominal<br><br>", 15);
		printMessage("//////////////Ship check complete//////////////<br><br>", 15);
		printMessage("//////////////cryostasis wakeup complete//////////////<br><br>", 15);
		printMessage("initializing email client");
		printMessage("... <br>", 175);
		console.setText("<html>");
	}
	
	public static void endgame() throws InterruptedException {
		printMessage("<br><br>As you strike the final blow, the core dissolves into a puddle of " + makeGreen("radioactive slag") + ".<br>");
		printMessage("The ship suddenly loses power, which was evidently being provided by the core.<br>You feel your feet lift off of the ground as the artificial gravity disengages.<br>");
		printMessage("A sudden realization: This ship is orbiting a fierce " +  makeRed("Red Giant Star") + ",<br>and without the core powering the gravity drive<br>you will very shortly be plunged into the nuclear heart of the aformentioned " + makeRed("star") +  ".<br>");
		printMessage("As the ship begins to fall, you are comforted to know that you have completed your mission.<br>");
		printMessage(makeCyan("<br>The universe is safe.<br>"),100);
		Thread.sleep(1000);
		console.setText("<html>");
		printMessage("<br><br>" + makeYellow("Stellar altitude dropping,<br>suborbital trajectory detected.<br>Reccomend immeadiate evacuation<br>Escape pods offline<br>Peril level 100"), 25);
		Thread.sleep(500);
		console.setText("<html>");
		printMessage(makeRed("*** ALERT ***<br>"),25);
		printMessage(makeRed("New E-mail Recieved!<br>"),25);
		printMessage("From: odin@valhalla.no<br>",25);
		printMessage("Subject: null<br><br>",25);
		printMessage("Goodbye, warrior<br>You have done well.");
		Thread.sleep(500);
		printMessage(makeRed("<br><br>Heat threshold exceeded, terminating commlink to 25.223.196.168:asgard"), 25);
		printMessage("<br><br>//////////////////////////////////END TRANSMISSION//////////////////////////////////", 15);
	}
	
	//prints strings letter by letter to create a typing effect
	public static void printMessage(String n) throws InterruptedException {
		
		int waitTime = 50;
		
		for (int i = 0; i < n.length(); i++){
			if (n.substring(i, i+1).equals("<"))
				waitTime = 0;
			if (n.substring(i, i+1).equals(">"))
				waitTime = 50;
			console.setText(console.getText() + n.substring(i, i+1));
			Thread.sleep(waitTime);
		}
	}
	
	public static void printMessage(String n, int time) throws InterruptedException {
		
		int waitTime = time;
		
		for (int i = 0; i < n.length(); i++){
			if (n.substring(i, i+1).equals("<"))
				waitTime = 0;
			if (n.substring(i, i+1).equals(">"))
				waitTime = time;
			console.setText(console.getText() + n.substring(i, i+1));
			Thread.sleep(waitTime);
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
	
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == text){
			System.out.println("enter hit");
			flag = true;
			userInput = text.getText();
			text.setText("");
		}
	}
}
