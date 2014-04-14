import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Map.java
 * @author Stanford Lockhart
 * B00646015
 * @author Geoffrey Caven
 * B00629837
 * March 2014
 * Dalhousie University
 * Faculty of Computer Science
 */
public class Map {

	//Instance variables
	private Room[][] rooms = new Room[15][11];	//(y,x), (0,0) is at top left
	private Room currentRoom;
	private int currentX;
	private int currentY;
	private boolean[] isDoor = new boolean[4];	//0 for North, 1 for East, 2 for South, 3 for West
	private boolean[] isLocked = new boolean[4]; 	//Same as above
	private Random rand = new Random();
	
	//Create all player items for the game
	private Item weapon2 = new Item("Sjoraeningi", "A dull lyn-cutlass, more fit for a pirate than a viking", 7, "Weapon", 30, true);
	private Item weapon3 = new Item("Vejmon's Edge", "You can tell by the make of the lyn-saber that this used to belong to your friend, Vejmon.\n\tHow many others has Odin sent to their deaths before you?", 3, "Weapon", 40, true);
	private Item weapon4 = new Item("The Bjoernkrammer", "Solid metal lyn-gauntlets, for punching this ship right back to hell.", 12, "Weapon", 50, true);
	private Item weapon5 = new Item("Hestespiser", "A brutal looking axe, although from the stains it looks a tad used.", 14, "Weapon", 60, true);
	private Item weapon6 = new Item("Andetaender", "A set of lyn-daggers, very useful for throwing at enemies from a distance.\nToo bad you can't throw.", 10, "Weapon", 70, true);
	private Item weapon7 = new Item("Solvarmer", "Painted with a crude drawing of a shark, this lyn-flamethrower will pack a punch.", 15, "Weapon", 80, true);
	private Item weapon8 = new Item("Fiskefrikadeller", "A hallowed pair of lyn-nunchuks - be sure to use them wisely.", 16, "Weapon", 90, true);
	
	//Create all generic enemy weapons in the game
	private Item lynGladius = new Item("lyn-gladius", "", 0, "Weapon", 20, false);
	private Item lynCutlass = new Item("lyn-cutlass", "", 0, "Weapon", 30, false);
	private Item lynSaber = new Item("lyn-saber", "", 0, "Weapon", 40, false);
	private Item lynGauntlets = new Item("lyn-gauntlets", "", 0, "Weapon", 50, false);
	private Item lynAxe = new Item("lyn-axe", "", 0, "Weapon", 60, false);
	private Item lynDagger = new Item("lyn-dagger", "", 0, "Weapon", 70, false);
	private Item lynFlamethrower = new Item("lyn-flamethrower", "", 0, "Weapon", 80, false);
	private Item lynNunchuk = new Item("lyn-nunchuk", "", 0, "Weapon", 90, false);
	
	//Boss weapon
	private Item lynReactor = new Item("The reactor core.", "", 0, "Weapon", 100, false);
	
	//Create generic enemies
	//If health values change, be sure to change the resetEnemies method below
	private Person[] easy = {
		new Person("Ali", "The Wicked", 200, 20, 5, lynGladius),
		new Person("Svertingr", "The Blacksmith", 200, 21, 5, lynGladius),
		new Person("Kiotvi", "The Warrior", 200, 22, 5, lynGladius),
		new Person("Tofa", "The Warmaiden", 200, 23, 10, lynCutlass),
		new Person("Thorve", "The Clan Mother", 200, 24, 10, lynCutlass),
		new Person("Kvistr", "The Quick", 200, 25, 10, lynCutlass),
		new Person("Thorvidr", "The Oarman", 200, 26, 15, lynCutlass),
		new Person("Oskar","The Quartermaster", 200, 27, 15, lynCutlass),
		new Person("Karl","The Lackey", 200, 28, 15, lynCutlass),
		new Person("Lars","The Hurried", 200, 29, 20, lynGladius),
		new Person("Egil","The Scholar", 200, 30, 20, lynGladius)
	};
	
	private Person[] medium = {
		new Person("Cynbel", "The Forgotten", 300, 30, 20, lynSaber),
		new Person("Tomas", "Bjornsson", 300, 32, 25, lynSaber),
		new Person("Sindri", "The Tactician", 300, 34, 25, lynSaber),
		new Person("Fi", "The Piper", 300, 36, 25, lynGauntlets),
		new Person("Orjan", "The Butcher", 300, 38, 30, lynGauntlets),
		new Person("Thorbjorn", "The Invader", 300, 39, 30, lynGauntlets),
		new Person("Gry", "The Farmer", 300, 40, 30, lynGauntlets)
	};
	
	private Person[] hard = {
		new Person("Egil", "The Woodsman", 400, 40, 35, lynAxe),
		new Person("Ylva", "The Carpenter", 400, 40, 35, lynAxe),
		new Person("Gunhild", "The Shield Bearer", 400, 41, 35, lynAxe),
		new Person("Sonja", "The Priestess", 400, 41, 40, lynDagger),
		new Person("Harald", "The Old", 400, 42, 40, lynDagger),
		new Person("Svea", "The Small", 400, 43, 40, lynDagger),
		new Person("Terje", "The Prince", 400, 44, 45, lynDagger)
	};
	
	private Person[] tough = {
		new Person("Baldr", "The First", 500, 45, 45, lynFlamethrower),
		new Person("Eir", "The Second", 500, 45, 45, lynFlamethrower),
		new Person("Frea", "The Third", 500, 45, 45, lynNunchuk),
		new Person("Hildr", "The Fourth", 500, 45, 45, lynNunchuk)
	};
	
	//Create boss
	private Person boss = new Person("R.A.I.D.", "THE REACTOR ARTIFICIAL INTELLIGENCE DESIGNATE", 600, 50, 50, lynReactor);
	
	//Create all keys
	private Item key1 = new Item("Rusty Key", "A rusty, old key that doesn't look like its been used recently.", 1, "Key", 0, true);
	private Item key2 = new Item("Light Key", "This key spits out a burst of light, opening any door ahead.", 1, "Key", 0, true);
	private Item key3 = new Item("Bone Key", "You shudder to think about what this key might be made of...", 1, "Key", 0, true);
	private Item key4 = new Item("Iron Key", "It may not look pretty, but this key could be the one that leads you to the reactor...", 1, "Key", 0, true);
	private Item key5 = new Item("Janitor's Key", "Once upon a time, there was a space viking janitor who kept keys on his belt...", 1, "Key", 0, true);
	private Item key6 = new Item("Bent Key", "This key has seen better days, but it still works.", 1, "Key", 0, true);
	private Item key7 = new Item("Trophy Key", "\"For first place in the Viking Unlocking Doors Championship", 1, "Key", 0, true);
	
	//Create potion
	private Item potion = new Item("Health Potion", "Restores Half of Maximum Health", 1, "Potion", 1, true);
	
	//Create all statues
	private Item nisk = new Item("Statue of Nisk", "The statue fills you with an unknown power; you feel like even more of a Viking. Defense +10 Strength +5", 1, "Statue", 0, true);
	private Item caeven = new Item("Statue of Caeven", "The statue fills you with an unknown power; you feel stronger than ever before. Strength +15", 1, "Statue", 0, true);	
	private Item lockhaert = new Item("State of Lockhaert", "The statue fills you with an unknown power; you feel better than you just did a second ago. Defense +10 Strength +5", 1, "Statue", 0, true);
	private Item traesk = new Item("Statue of Traesk", "The statue fills you with lard, er, an unknown power; you can feel old wounds begin to heal and shut. Health +200", 1, "Statue", 0, true);
	private Item duenn = new Item("Statue of Duenn", "The statue fills you with a longing for hats. Defense +5 Health +100", 1, "Statue", 0, true);
	
	/**
	 * No args constructor, creates the map in the 2D array and sets all variables for first room
	 */
	public Map() {
		rooms[0][0] = new Room(false, new ArrayList<Item>(Arrays.asList(key1)), null, "A small box of maintenance supplies is overturned on the floor.");
		rooms[0][1] = null;
		rooms[0][2] = new Room(false, new ArrayList<Item>(Arrays.asList(nisk)), null, "The rear of the ship\nLarge windows allow a view of the stars beyond, while massive nuclear thrusters loom to each side.");
		rooms[0][3] = new Room(false, new ArrayList<Item>(), null, "The rear of the ship\nLarge windows allow a view of the stars beyond, while massive nuclear thrusters loom to each side.");
		rooms[0][4] = null;
		rooms[0][5] = new Room(true, new ArrayList<Item>(), boss, "The nuclear core is in view. The room is bathed in the green glow of the unshielded core.");
		rooms[0][6] = null;
		rooms[0][7] = new Room(false, new ArrayList<Item>(), null, "The stern of the ship\nLarge windows allow a view of the stars beyond, while massive nuclear thrusters loom to each side.");
		rooms[0][8] = new Room(false, new ArrayList<Item>(Arrays.asList(weapon8)), null, "The stern of the ship\nLarge windows allow a view of the stars beyond, while massive nuclear thrusters loom to each side.");
		rooms[0][9] = null;
		rooms[0][10] = new Room(false, new ArrayList<Item>(Arrays.asList(key2)), null, "A line of keyhooks labeled 'Core Access' is on the wall, though only one key is hanging on it.");
		
		rooms[1][0] = new Room(false, new ArrayList<Item>(), null, "A gray metal hallway\nCore exhaust pipes run along the walls. A severed foot is lodged in between two pipes.");
		rooms[1][1] = new Room(false, new ArrayList<Item>(Arrays.asList(potion)), null, "A gray metal hallway\nCore exhaust pipes run along the walls.");
		rooms[1][2] = new Room(false, new ArrayList<Item>(), null, "A gray metal hallway\nCore exhaust pipes run along the walls. It smells of spoiled milk.");
		rooms[1][3] = new Room(false, new ArrayList<Item>(), hard[rand.nextInt(hard.length)], "A gray metal hallway\nCore exhaust pipes run along the walls.");
		rooms[1][4] = new Room(false, new ArrayList<Item>(), null, "A gray metal hallway\nCore exhaust pipes run along the walls.\nA green glow is leaking under the door from the room to the east.");
		rooms[1][5] = new Room(true, new ArrayList<Item>(), null, "The door to the north has a sign: 'Central Drive Core Chamber'.\nA green glow emanates from under the door and reflects around the room.");
		rooms[1][6] = new Room(false, new ArrayList<Item>(), null, "A gray metal hallway\nCore exhaust pipes run along the walls.\n\nA green glow is leaking under the door from the room to the west.");
		rooms[1][7] = new Room(false, new ArrayList<Item>(), null, "A gray metal hallway\nCore exhaust pipes run along the walls.");
		rooms[1][8] = new Room(false, new ArrayList<Item>(), null, "A gray metal hallway\nCore exhaust pipes run along the walls.");
		rooms[1][9] = new Room(false, new ArrayList<Item>(Arrays.asList(potion)), null, "A gray metal hallway\nCore exhaust pipes run along the walls. A bloody lyn-saber was snapped in half and left on the floor");
		rooms[1][10] = new Room(false, new ArrayList<Item>(), null, "A gray metal hallway\nCore exhaust pipes run along the walls.");
		
		rooms[2][0] = null;
		rooms[2][1] = null;
		rooms[2][2] = null;
		rooms[2][3] = new Room(false, new ArrayList<Item>(), null, "A narrow maintenance hallway\nA small porthole on the west wall provides a scenic view of a passing nebula.");
		rooms[2][4] = null;
		rooms[2][5] = null;
		rooms[2][6] = null;
		rooms[2][7] = new Room(false, new ArrayList<Item>(), hard[rand.nextInt(7)], "A narrow maintenance hallway\nThe walls have been smeared with someone's surplus blood.");
		rooms[2][8] = null;
		rooms[2][9] = null;
		rooms[2][10] = null;
		
		rooms[3][0] = new Room(false, new ArrayList<Item>(), hard[rand.nextInt(7)],"Sleeping Quarters, most of the bunks have been torn to shreds. The trash can was carefully placed upside-down.");
		rooms[3][1] = new Room(false, new ArrayList<Item>(Arrays.asList(key3)), null,"A storage closest, a skull sits on the shelf. 'with love, from mom' is written across the brow.");
		rooms[3][2] = null;
		rooms[3][3] = new Room(false, new ArrayList<Item>(Arrays.asList(potion)), null, "A narrow maintenance hallway");
		rooms[3][4] = new Room(false, new ArrayList<Item>(), tough[rand.nextInt(4)], "The floor is covered in strewn human bones and viscera\nHorned helmets are piled against the north wall, though most have been broken.");
		rooms[3][5] = new Room(true, new ArrayList<Item>(), null, "A central maintenance room\nDoors to the west and east provide access to the engine sector.");
		rooms[3][6] = new Room(false, new ArrayList<Item>(), tough[rand.nextInt(4)], "This room is spotless\nSomeone even took the time to clean the ceilings.");
		rooms[3][7] = new Room(false, new ArrayList<Item>(Arrays.asList(potion)), null, "A narrow maintenance hallway");
		rooms[3][8] = null;
		rooms[3][9] = new Room(true, new ArrayList<Item>(Arrays.asList(caeven)), null, "Capt. Ormskaeg's private room\nThe Captain's belongings have been thrown onto the floor.");
		rooms[3][10] = new Room(false, new ArrayList<Item>(), hard[rand.nextInt(7)], "Sleeping quarters, bunks are pushed against the north and east walls.");
		
		rooms[4][0] = new Room(false, new ArrayList<Item>(Arrays.asList(potion)), null, "Sleeping quarters, the west and east walls are lined with bunks\nBlood on the floor is evidence of a recent fight.");
		rooms[4][1] = null;
		rooms[4][2] = new Room(false, new ArrayList<Item>(Arrays.asList(weapon5)), null, "A large bathroom, someone knocked over all the stall walls. How rude.");
		rooms[4][3] = null;
		rooms[4][4] = null;
		rooms[4][5] = new Room(false, new ArrayList<Item>(), null, "A hallway, the door to the north has a sign on it: 'Engine Sector Access'.");
		rooms[4][6] = null;
		rooms[4][7] = null;
		rooms[4][8] = new Room(false, new ArrayList<Item>(Arrays.asList(key4)), null, "A small alcove filled with shelves\nThe shelves are mostly filled with salted fish.");
		rooms[4][9] = null;
		rooms[4][10] = new Room(false, new ArrayList<Item>(), null, "These were sleeping quarters, though all the beds seem to be missing.");
		
		rooms[5][0] = new Room(false, new ArrayList<Item>(), medium[rand.nextInt(7)], "Sleeping quarters, the bunks are orderly and well made.");
		rooms[5][1] = new Room(false, new ArrayList<Item>(), null, "This is the west sleeping quarter wing, the bunks are all in place but someone tore all the sheets off.");
		rooms[5][2] = new Room(false, new ArrayList<Item>(), medium[rand.nextInt(7)], "A nice looking room, the shag carpet is an unfortunate shade of orange. Also its full of cockroaches or something.");
		rooms[5][3] = new Room(false, new ArrayList<Item>(), null, "A wide hallway. The walls are lined with elaborate oil paintings of the captain.");
		rooms[5][4] = new Room(false, new ArrayList<Item>(), null, "A wide hallway. The sides of the hall are lined with busts of the captain.");
		rooms[5][5] = new Room(false, new ArrayList<Item>(), medium[rand.nextInt(7)], "The captain's prized atrium, the wood panel walls are polished to a shine.");
		rooms[5][6] = null;
		rooms[5][7] = new Room(false, new ArrayList<Item>(), medium[rand.nextInt(7)], "A dull hallway, the floors are a grey metal and the walls are a sickly shade of green.");
		rooms[5][8] = new Room(false, new ArrayList<Item>(), null, "A slightly-less-than dull hallway, the floors a slightly-less-than grey metal.");
		rooms[5][9] = new Room(false, new ArrayList<Item>(), null, "The tacky carpet in this room has been pounded flat by thousands of viking boots.");
		rooms[5][10] = new Room(false, new ArrayList<Item>(Arrays.asList(potion)), null, "A billiards room, someone smashed all the balls into a fine rainbow dust.");
		
		rooms[6][0] = null;
		rooms[6][1] = null;
		rooms[6][2] = new Room(false, new ArrayList<Item>(), tough[rand.nextInt(4)], "What looks to be an abandoned living room.  Some of the pillows look like they  have been shredded by some beast..");
		rooms[6][3] = null;
		rooms[6][4] = null;
		rooms[6][5] = new Room(false, new ArrayList<Item>(Arrays.asList(potion)), null, "Backed into a corner, this dust filled room has nothing of importance.");
		rooms[6][6] = new Room(false, new ArrayList<Item>(), null, "An open hallway, branching into three different rooms.");
		rooms[6][7] = new Room(false, new ArrayList<Item>(), null, "Backed into a corner, this dust filled room has nothing of importance.");
		rooms[6][8] = null;
		rooms[6][9] = null;
		rooms[6][10] = null;
		
		rooms[7][0] = new Room(false, new ArrayList<Item>(Arrays.asList(key5)), null, "The space janitor was kind enough to leave his door unlocked before perishing; hopefully he left his keys too.");
		rooms[7][1] = null;
		rooms[7][2] = new Room(true, new ArrayList<Item>(), null, "Backed into a corner, this dust filled room has nothing of importance.");
		rooms[7][3] = new Room(false, new ArrayList<Item>(), null, "Backed into a corner, this dust filled room has nothing of importance.");
		rooms[7][4] = null;
		rooms[7][5] = null;
		rooms[7][6] = null;
		rooms[7][7] = new Room(false, new ArrayList<Item>(Arrays.asList(lockhaert)), null, "The room, though very much delapitated like the rest of the ship, bears the sweet, sweet musk of achievement.");
		rooms[7][8] = null;
		rooms[7][9] = new Room(false, new ArrayList<Item>(), medium[rand.nextInt(7)], "Stepping closer to the center of the room brings the sensation of hundreds of screaming voices gasping their final breaths.\nGnarsty.");
		rooms[7][10] = null;
		
		rooms[8][0] = new Room(false, new ArrayList<Item>(), null, "A maintenance hallway, there are some brooms in here. They probably won't make good weapons.");
		rooms[8][1] = null;
		rooms[8][2] = null;
		rooms[8][3] = new Room(false, new ArrayList<Item>(), null, "This was the combat practice area, unfortunately somebody already took all the weapons.");
		rooms[8][4] = new Room(false, new ArrayList<Item>(Arrays.asList(weapon6)), null, "Marksmanship practice took place in here, some old targets hang on the far wall.");
		rooms[8][5] = new Room(false, new ArrayList<Item>(), null, "Weapons storage for the practice rooms. It looks pretty barren.");
		rooms[8][6] = new Room(false, new ArrayList<Item>(Arrays.asList(traesk)), null, "This room hasn't been opened in years, a box is upended on the floor.");
		rooms[8][7] = null;
		rooms[8][8] = new Room(false, new ArrayList<Item>(Arrays.asList(key6)), null, "A dusty, forgotton little room. Someone was keeping their collection of loose keys in here, though most of them are pretty bent.");
		rooms[8][9] = new Room(false, new ArrayList<Item>(Arrays.asList(potion)), null, "A tall, airy chamber. The ceiling has a stained glass cupola.\nApparently the captain stole it off some Neo-British station way back.");
		rooms[8][10] = new Room(false, new ArrayList<Item>(Arrays.asList(weapon3)), null, "Backed into a corner, this dust filled room has nothing of importance.");
		
		rooms[9][0] = new Room(false, new ArrayList<Item>(), null, "A maintenance hallway, the space janitor left his tools here in a hurry.");
		rooms[9][1] = new Room(false, new ArrayList<Item>(), medium[rand.nextInt(7)], "This room is full of card tables. The decks have thrown around the room.");
		rooms[9][2] = new Room(false, new ArrayList<Item>(Arrays.asList(potion)), null, "A storage room, the walls are lined with metal crates covered in dust (and some blood).");
		rooms[9][3] = new Room(false, new ArrayList<Item>(), medium[rand.nextInt(7)], "This was the canteen, there doesn't seem to be any food left. Maybe under the counter?");
		rooms[9][4] = null;
		rooms[9][5] = null;
		rooms[9][6] = null;
		rooms[9][7] = null;
		rooms[9][8] = null;
		rooms[9][9] = new Room(false, new ArrayList<Item>(), medium[rand.nextInt(7)], "This hallway is painted in the most hideous shade of turquoise you have ever seen.");
		rooms[9][10] = null;
		
		rooms[10][0] = null;
		rooms[10][1] = new Room(false, new ArrayList<Item>(), null, "Escape pods line the west wall, all the door handles have been broken off them.");
		rooms[10][2] = null;
		rooms[10][3] = new Room(false, new ArrayList<Item>(), null, "The mess hall, all the plates are smashed on the floor and rotting food is everywhere.");
		rooms[10][4] = null;
		rooms[10][5] = new Room(false, new ArrayList<Item>(), null, "There aren't any more pods, but there are some awfully bloody controls here. Some intestines too.");
		rooms[10][6] = new Room(false, new ArrayList<Item>(Arrays.asList(potion)), null, "Even more cyrostatis pods, how many warriors do they have on hold?");
		rooms[10][7] = new Room(false, new ArrayList<Item>(), easy[rand.nextInt(easy.length)], "More cryostatis pods, this place is full of the things.");
		rooms[10][8] = null;
		rooms[10][9] = new Room(false, new ArrayList<Item>(), null, "This hallway is completely plain and unremarkable");
		rooms[10][10] = null;
		
		rooms[11][0] = null;
		rooms[11][1] = new Room(false, new ArrayList<Item>(), easy[rand.nextInt(easy.length)], "The main exterior airlock, this is where the warriors would leave the ship on their raids.");
		rooms[11][2] = new Room(false, new ArrayList<Item>(), null, "Space-Bearskin spacesuits are hung in long rows through the room.");
		rooms[11][3] = new Room(false, new ArrayList<Item>(Arrays.asList(weapon7)), null, "Oxygen tanks are stacked to the ceiling, a lot of them are empty.");
		rooms[11][4] = null;
		rooms[11][5] = new Room(false, new ArrayList<Item>(), easy[rand.nextInt(easy.length)], "This is a service hallway, pretty boring really. A lot of metal here, as it happens.");
		rooms[11][6] = null;
		rooms[11][7] = new Room(false, new ArrayList<Item>(), null, "The cryostatis chamber you woke up in, other warriors from various ages are inanimate in their respective pods.");
		rooms[11][8] = null;
		rooms[11][9] = new Room(false, new ArrayList<Item>(Arrays.asList(key7)), null, "The hallway is lined with trophy cases. There are some trophies too.\n'Norse Soccer Champions 20XX-4', huh.");
		rooms[11][10] = new Room(true, new ArrayList<Item>(Arrays.asList(duenn)), null, "This seems to be a treasure closet. A burlap sack in the corner is labelled 'swag bag'.");
		
		rooms[12][0] = null;
		rooms[12][1] = new Room(false, new ArrayList<Item>(), null, "An unremarkable hallway. A sign points north and reads: 'Main Airlock'.");
		rooms[12][2] = null;
		rooms[12][3] = null;
		rooms[12][4] = null;
		rooms[12][5] = new Room(false, new ArrayList<Item>(), easy[rand.nextInt(easy.length)], "This is a service hallway, its made of wood for some reason. Elaborate scenes of viking glory are carved into the walls.");
		rooms[12][6] = null;
		rooms[12][7] = null;
		rooms[12][8] = new Room(false, new ArrayList<Item>(Arrays.asList(potion)), null, "Recreational quarters once upon a time, the room is full of severed heads now.");
		rooms[12][9] = new Room(false, new ArrayList<Item>(), null, "Recreational quarters, table tennis etc. Looks fun.");
		rooms[12][10] = null;
		
		rooms[13][0] = null;
		rooms[13][1] = new Room(false, new ArrayList<Item>(), easy[rand.nextInt(easy.length)], "A largely unremarkable hallway. A sign points south and reads: 'Bridge Access and Fish Saltery'.");
		rooms[13][2] = null;
		rooms[13][3] = new Room(false, new ArrayList<Item>(), tough[rand.nextInt(4)], "The wall panelling is spread around the room.\nThe pipes have been pulled out of the wall and are spraying superheated steam in the air.");
		rooms[13][4] = new Room(true, new ArrayList<Item>(), null, "A security room. It was locked down prety tight until you found the key.\nSomeone already emptied the weapon cabinet.");
		rooms[13][5] = new Room(false, new ArrayList<Item>(), null, "A nice snack room, the vending machines are fully stocked.\nA bulkhead automatically sealed off access to the west.");
		rooms[13][6] = new Room(false, new ArrayList<Item>(), easy[rand.nextInt(easy.length)], "The salt storage depository, someone took the time to smash all the salt jars. What a jerk.");
		rooms[13][7] = new Room(false, new ArrayList<Item>(), null, "A pleasant hallway, rather 1970s with some wood panelling.");
		rooms[13][8] = new Room(false, new ArrayList<Item>(), easy[rand.nextInt(easy.length)], "Recreational quarters, or they were. More like a morgue now really. Pretty grizzly.");
		rooms[13][9] = new Room(false, new ArrayList<Item>(), null, "Recreational quarters, the rooms is filled with startlingly uncomfortable looking couches.");
		rooms[13][10] = new Room(false, new ArrayList<Item>(), easy[rand.nextInt(easy.length)], "A bay window reveals a beautiful space vista. Someone taped a chore list to the window.\nIt's Sveinbjorn's day to do the dishes, he probably won't though.");
		
		rooms[14][0] = new Room(false, new ArrayList<Item>(Arrays.asList(weapon4)), null, "The bow of the ship\nA large window to the south provides a view of passing asteroids.");
        rooms[14][1] = new Room(false, new ArrayList<Item>(Arrays.asList(potion)), null, "The bow of the ship\nThe bulkhead to the south has sealed off access to the bridge.\nThe room is full of comfortable chairs and piles of half-salted fish.");
		rooms[14][2] = new Room(false, new ArrayList<Item>(), easy[rand.nextInt(easy.length)], "The bow of the ship\nA human skeleton is lounging on a couch in front of the window.\nThe large window provides a nice view of the star the ship is orbiting. Is that the bridge floating over there?.");
		rooms[14][3] = new Room(false, new ArrayList<Item>(), null, "The bow of the ship\nNormally one could see the bridge through the southern window, but it seems to be missing.");
		rooms[14][4] = null;
		rooms[14][5] = new Room(false, new ArrayList<Item>(), null, "The secondary bow airlock is to the west, but it has been automatically sealed.");
		rooms[14][6] = null;
		rooms[14][7] = new Room(false, new ArrayList<Item>(Arrays.asList(weapon2)), null, "The main bow airlock is to east, but it has been automatically sealed.\nHalf salted fish litters the floor\nYou can see a distant gas giant through the large window to the south.");
		rooms[14][8] = null;
		rooms[14][9] = null;
		rooms[14][10] = null;
		
		//fill with rooms -- new Room(isTrap, isLocked, items, enemy, description) 
		currentRoom = rooms[11][7];
		currentRoom.playerVisits();
		currentX = 7;
		currentY = 11;
		setAdjacentRooms();
	}

	/**
	 * @return the rooms
	 */
	public Room[][] getRooms() {
		return rooms;
	}

	/**
	 * @param rooms the rooms to set
	 */
	public void setRooms(Room[][] rooms) {
		this.rooms = rooms;
	}

	/**
	 * @return the currentRoom
	 */
	public Room getCurrentRoom() {
		return currentRoom;
	}

	/**
	 * @param currentRoom the currentRoom to set
	 */
	public void setCurrentRoom(Room currentRoom, int y, int x) {
		if (currentRoom != null){
			this.currentRoom = currentRoom;
			currentY = y;
			currentX = x;
		}
	}

	/**
	 * @return the isDoor
	 */
	public boolean[] getIsDoor() {
		return isDoor;
	}

	/**
	 * @param isDoor the isDoor to set
	 */
	public void setIsDoor(boolean[] isDoor) {
		this.isDoor = isDoor;
	}

	/**
	 * @return the isLocked
	 */
	public boolean[] getIsLocked() {
		return isLocked;
	}

	/**
	 * @param isLocked the isLocked to set
	 */
	public void setIsLocked(boolean[] isLocked) {
		this.isLocked = isLocked;
	}
	
	/**
	 * Move the player north if there is a door there and it is not locked
	 * @throws InterruptedException 
	 */
	public void moveNorth() throws InterruptedException{
		if (isDoor[0] && !isLocked[0]){
			currentY--;
			currentRoom = rooms[currentY][currentX];
			currentRoom.playerVisits();
			setAdjacentRooms();
		} else if (!isDoor[0])
			Game.printMessage("There is no door in that direction\n");
		else if (isLocked[0])
			Game.printMessage("You try to continue, but the door is locked\n");
	}
	
	/**
	 * Move the player east if there is a door there and it is not locked
	 * @throws InterruptedException 
	 */
	public void moveEast() throws InterruptedException{
		if (isDoor[1] && !isLocked[1]){
			currentX++;
			currentRoom = rooms[currentY][currentX];
			currentRoom.playerVisits();
			setAdjacentRooms();
		} else if (!isDoor[1])
			Game.printMessage("There is no door in that direction\n");
		else if (isLocked[1])
			Game.printMessage("You try to continue, but the door is locked\n");
	}
	
	/**
	 * Move the player north if there is a door there and it is not locked
	 * @throws InterruptedException 
	 */
	public void moveSouth() throws InterruptedException{
		if (isDoor[2] && !isLocked[2]){
			currentY++;
			currentRoom = rooms[currentY][currentX];
			currentRoom.playerVisits();
			setAdjacentRooms();
		} else if (!isDoor[2])
			Game.printMessage("There is no door in that direction\n");
		else if (isLocked[2])
			Game.printMessage("You try to continue, but the door is locked\n");
	}
	
	/**
	 * Move the player north if there is a door there and it is not locked
	 * @throws InterruptedException 
	 */
	public void moveWest() throws InterruptedException{
		if (isDoor[3] && !isLocked[3]){
			currentX--;
			currentRoom = rooms[currentY][currentX];
			currentRoom.playerVisits();
			setAdjacentRooms();
		} else if (!isDoor[3])
			Game.printMessage("There is no door in that direction\n");
		else if (isLocked[3])
			Game.printMessage("You try to continue, but the door is locked\n");
	}
	
	/**
	 * Returns a description of the current room
	 * @throws InterruptedException 
	 */
	public void look() throws InterruptedException{
		Game.printMessage(currentRoom.getDescription() + "\n");
		if (isDoor[0]){
			if (isLocked[0])
				Game.printMessage("There is a locked door to the North\n");
			else
				Game.printMessage("There is a door to the North\n");
		}
		if (isDoor[1]){
			if (isLocked[1])
				Game.printMessage("There is a locked door to the East\n");
			else
				Game.printMessage("There is a door to the East\n");
		}
		if (isDoor[2]){
			if (isLocked[2])
				Game.printMessage("There is a locked door to the South\n");
			else
				Game.printMessage("There is a door to the South\n");
		}
		if (isDoor[3]){
			if (isLocked[3])
				Game.printMessage("There is a locked door to the West\n");
			else
				Game.printMessage("There is a door to the West\n");
		}
		if (!currentRoom.getItems().isEmpty())
			Game.printMessage("The room has the following items:\n" + currentRoom.getItems() + "\n");
	}
	
	/**
	 * Unlock all adjacent rooms
	 */
	public void unlock(){
		if (isDoor[0]){
			rooms[currentY - 1][currentX].unlock();
			isLocked[0] = false;
		}
		if (isDoor[1]){
			rooms[currentY][currentX + 1].unlock();
			isLocked[1] = false;
		}
		if (isDoor[2]){
			rooms[currentY + 1][currentX].unlock();
			isLocked[2] = false;
		}
		if (isDoor[3]){
			rooms[currentY][currentX - 1].unlock();
			isLocked[3] = false;
		}
	}
	
	/**
	 * @return the entire map, regardless of whether or not a room has been visited
	 */
	public String fullMap(){
		String map = "";
		for (int i = 0; i < 15; i++){
			for (int j = 0; j < 11; j++){
				if (rooms[i][j] != null)
					if (i == currentY && j == currentX)
						map += "[*]";
					else
						map += rooms[i][j];
				else
					map += "   ";
			}
			map += "\n";
		}
		return map;
	}
	
	/**
	 * Returns the map as a string
	 */
	@Override
	public String toString() {
		String map = "";
		for (int i = 0; i < 15; i++){
			for (int j = 0; j < 11; j++){
				if (rooms[i][j] != null && (rooms[i][j].hasVisited() || isAdjacent(rooms, i, j)))
					if (i == currentY && j == currentX)
						map += "[*]";
					else
						map += rooms[i][j];
				else
					map += "   ";
			}
			map += "\n";
		}
		return map;
	}
	
	/**
	 * Returns whether room is currently adjacent
	 * @param rooms2
	 * @param y
	 * @param x
	 * @return
	 */
	private boolean isAdjacent(Room[][] rooms2, int y, int x) {
		if (currentX == 0){
			if (currentY == 0){
				if (x == currentX + 1 && y == currentY)
					return true;
				else if (x == currentX && y == currentY + 1)
					return true;
			} else if (currentY == 14){
				if (x == currentX + 1 && y == currentY)
					return true;
				else if (x == currentX && y == currentY - 1)
					return true;
			} else {
				if (x == currentX + 1 && y == currentY)
					return true;
				else if (x == currentX && y == currentY + 1)
					return true;
				else if (x == currentX && y == currentY - 1)
					return true;
			}
		} else if (currentX == 10){
			if (currentY == 0){
				if (x == currentX - 1 && y == currentY)
					return true;
				else if (x == currentX && y == currentY + 1)
					return true;
			} else if (currentY == 14){
				if (x == currentX - 1 && y == currentY)
					return true;
				else if (x == currentX && y == currentY - 1)
					return true;
			} else {
				if (x == currentX - 1 && y == currentY)
					return true;
				else if (x == currentX && y == currentY - 1)
					return true;
				else if (x == currentX && y == currentY + 1)
					return true;
			}
		} else {
			if (currentY == 0){
				if (x == currentX - 1 && y == currentY)
					return true;
				else if (x == currentX + 1 && y == currentY)
					return true;
				else if (x == currentX && y == currentY + 1)
					return true;
			} else if (currentY == 14){
				if (x == currentX - 1 && y == currentY)
					return true;
				else if (x == currentX + 1 && y == currentY)
					return true;
				else if (x == currentX && y == currentY - 1)
					return true;
			} else {
				if (x == currentX - 1 && y == currentY)
					return true;
				else if (x == currentX + 1 && y == currentY)
					return true;
				else if (x == currentX && y == currentY - 1)
					return true;
				else if (x == currentX && y == currentY + 1)
					return true;
			}
		}
		return false;
	}

	/**
	 * Sets whether adjacent rooms exist and/or are locked
	 */
	public void setAdjacentRooms(){
		if (currentX == 0){
			if (currentY == 0){
				isDoor[0] = false;
				isDoor[1] = rooms[currentY][currentX + 1] != null;
				isDoor[2] = rooms[currentY + 1][currentX] != null;
				isDoor[3] = false;
				if (isDoor[0])
					isLocked[0] = false;
				if (isDoor[1])
					isLocked[1] = rooms[currentY][currentX + 1].isLocked();
				if (isDoor[2])
					isLocked[2] = rooms[currentY + 1][currentX].isLocked();
				if (isDoor[3])
					isLocked[3] = false;
			} else if (currentY == 14){
				isDoor[0] = rooms[currentY - 1][currentX] != null;
				isDoor[1] = rooms[currentY][currentX + 1] != null;
				isDoor[2] = false;
				isDoor[3] = false;
				if (isDoor[0])
					isLocked[0] = rooms[currentY - 1][currentX].isLocked();
				if (isDoor[1])
					isLocked[1] = rooms[currentY][currentX + 1].isLocked();
				if (isDoor[2])
					isLocked[2] = false;
				if (isDoor[3])
					isLocked[3] = false;
			} else {
				isDoor[0] = rooms[currentY - 1][currentX] != null;
				isDoor[1] = rooms[currentY][currentX + 1] != null;
				isDoor[2] = rooms[currentY + 1][currentX] != null;
				isDoor[3] = false;
				if (isDoor[0])
					isLocked[0] = rooms[currentY - 1][currentX].isLocked();
				if (isDoor[1])
					isLocked[1] = rooms[currentY][currentX + 1].isLocked();
				if (isDoor[2])
					isLocked[2] = rooms[currentY + 1][currentX].isLocked();
				if (isDoor[3])
					isLocked[3] = false;
			}
		} else if (currentX == 10){
			if (currentY == 0){
				isDoor[0] = false;
				isDoor[1] = false;
				isDoor[2] = rooms[currentY + 1][currentX] != null;
				isDoor[3] = rooms[currentY][currentX - 1] != null;
				if (isDoor[0])
					isLocked[0] = false;
				if (isDoor[1])
					isLocked[1] = false;
				if (isDoor[2])
					isLocked[2] = rooms[currentY + 1][currentX].isLocked();
				if (isDoor[3])
					isLocked[3] = rooms[currentY][currentX - 1].isLocked();
			} else if (currentY == 14){
				isDoor[0] = rooms[currentY - 1][currentX] != null;
				isDoor[1] = false;
				isDoor[2] = false;
				isDoor[3] = rooms[currentY][currentX - 1] != null;
				if (isDoor[0])
					isLocked[0] = rooms[currentY - 1][currentX].isLocked();
				if (isDoor[1])
					isLocked[1] = false;
				if (isDoor[2])
					isLocked[2] = false;
				if (isDoor[3])
					isLocked[3] = rooms[currentY][currentX - 1].isLocked();
			} else {
				isDoor[0] = rooms[currentY - 1][currentX] != null;
				isDoor[1] = false;
				isDoor[2] = rooms[currentY + 1][currentX] != null;
				isDoor[3] = rooms[currentY][currentX - 1] != null;
				if (isDoor[0])
					isLocked[0] = rooms[currentY - 1][currentX].isLocked();
				if (isDoor[1])
					isLocked[1] = false;
				if (isDoor[2])
					isLocked[2] = rooms[currentY + 1][currentX].isLocked();
				if (isDoor[3])
					isLocked[3] = rooms[currentY][currentX - 1].isLocked();
			}
		} else {
			if (currentY == 0){
				isDoor[0] = false;
				isDoor[1] = rooms[currentY][currentX + 1] != null;
				isDoor[2] = rooms[currentY + 1][currentX] != null;
				isDoor[3] = rooms[currentY][currentX - 1] != null;
				if (isDoor[0])
					isLocked[0] = false;
				if (isDoor[1])
					isLocked[1] = rooms[currentY][currentX + 1].isLocked();
				if (isDoor[2])
					isLocked[2] = rooms[currentY + 1][currentX].isLocked();
				if (isDoor[3])
					isLocked[3] = rooms[currentY][currentX - 1].isLocked();
			} else if (currentY == 14){
				isDoor[0] = rooms[currentY - 1][currentX] != null;
				isDoor[1] = rooms[currentY][currentX + 1] != null;
				isDoor[2] = false;
				isDoor[3] = rooms[currentY][currentX - 1] != null;
				if (isDoor[0])
					isLocked[0] = rooms[currentY - 1][currentX].isLocked();
				if (isDoor[1])
					isLocked[1] = rooms[currentY][currentX + 1].isLocked();
				if (isDoor[2])
					isLocked[2] = false;
				if (isDoor[3])
					isLocked[3] = rooms[currentY][currentX - 1].isLocked();
			} else {
				isDoor[0] = rooms[currentY - 1][currentX] != null;
				isDoor[1] = rooms[currentY][currentX + 1] != null;
				isDoor[2] = rooms[currentY + 1][currentX] != null;
				isDoor[3] = rooms[currentY][currentX - 1] != null;
				if (isDoor[0])
					isLocked[0] = rooms[currentY - 1][currentX].isLocked();
				if (isDoor[1])
					isLocked[1] = rooms[currentY][currentX + 1].isLocked();
				if (isDoor[2])
					isLocked[2] = rooms[currentY + 1][currentX].isLocked();
				if (isDoor[3])
					isLocked[3] = rooms[currentY][currentX - 1].isLocked();
			}
		}
	}

	/**
	 * Resets enemy health to original to prepare for next encounter
	 */
	public void resetEnemies(){
		for (Person e : easy)
			e.setHealth(200);
		for (Person e : medium)
			e.setHealth(300);
		for (Person e : hard)
			e.setHealth(400);
		for (Person e : tough)
			e.setHealth(500);
	}
}
