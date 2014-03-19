import java.util.ArrayList;

/*
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
	Room[][] rooms = new Room[15][11];	//(y,x), (0,0) is at top left
	Room currentRoom;
	int currentX;
	int currentY;
	boolean[] isDoor = new boolean[4];	//0 for North, 1 for East, 2 for South, 3 for West
	boolean[] isLocked = new boolean[4]; 	//Same as above
	
	/**
	 * No args constructor, creates the map in the 2D array and sets all variables for first room
	 */
	public Map() {
		rooms[0][0] = new Room(false, false, new ArrayList<Item>(),null, "A small box of maintenance supplies is overturned on the floor");
		rooms[0][1] = null;
		rooms[0][2] = new Room(false, false, new ArrayList<Item>(),null ,"The rear of the ship\nLarge windows allow a view of the stars beyond, while massive nuclear thrusters loom to each side");
		rooms[0][3] = new Room(false, false, new ArrayList<Item>(),null ,"The rear of the ship\nLarge windows allow a view of the stars beyond, while massive nuclear thrusters loom to each side");
		rooms[0][4] = null;
		rooms[0][5] = new Room(false, true, new ArrayList<Item>(),null ,"The nuclear core is in view./n The room is bathed in the green glow of the unshielded core");
		rooms[0][6] = null;
		rooms[0][7] = new Room(false, false, new ArrayList<Item>(),null ,"The stern of the ship\nLarge windows allow a view of the stars beyond, while massive nuclear thrusters loom to each side");
		rooms[0][8] = new Room(false, false, new ArrayList<Item>(),null ,"The stern of the ship\nLarge windows allow a view of the stars beyond, while massive nuclear thrusters loom to each side");
		rooms[0][9] = null;
		rooms[0][10] = new Room(false, false, new ArrayList<Item>(),null,"A line of keyhooks labeled 'Core Access' is on the wall, though only one key is hanging on it");
		
		rooms[1][0] = new Room(false, false, new ArrayList<Item>(),null, "A gray metal hallway\nCore exhaust pipes run along the walls\nA severed foot is lodged in between two pipes");
		rooms[1][1] = new Room(false, false, new ArrayList<Item>(),null, "A gray metal hallway\nCore exhaust pipes run along the walls");
		rooms[1][2] = new Room(false, false, new ArrayList<Item>(),null, "A gray metal hallway\nCore exhaust pipes run along the walls");
		rooms[1][3] = new Room(false, false, new ArrayList<Item>(),null, "A gray metal hallway\nCore exhaust pipes run along the walls");
		rooms[1][4] = new Room(false, false, new ArrayList<Item>(),null, "A gray metal hallway\nCore exhaust pipes run along the walls\nA green glow is leaking under the door from the room to the east");
		rooms[1][5] = new Room(false, true, new ArrayList<Item>(),null,"The door to the north has a sign: 'Central Drive Core Chamber'\nA green glow emanates from under the door and reflects around the room");
		rooms[1][6] = new Room(false, false, new ArrayList<Item>(),null, "A gray metal hallway\nCore exhaust pipes run along the walls\n\nA green glow is leaking under the door from the room to the west");
		rooms[1][7] = new Room(false, false, new ArrayList<Item>(),null, "A gray metal hallway\nCore exhaust pipes run along the walls");
		rooms[1][8] = new Room(false, false, new ArrayList<Item>(),null, "A gray metal hallway\nCore exhaust pipes run along the walls");
		rooms[1][9] = new Room(false, false, new ArrayList<Item>(),null, "A gray metal hallway\nCore exhaust pipes run along the walls\nA bloody lyn-saber was snapped in half and left on the floor");
		rooms[1][10] = new Room(false, false, new ArrayList<Item>(),null,"A gray metal hallway\nCore exhaust pipes run along the walls");
		
		rooms[2][0] = null;
		rooms[2][1] = null;
		rooms[2][2] = null;
		rooms[2][3] = new Room(false, false, new ArrayList<Item>(), null,"A narrow maintenance hallway\nA small porthole on the west wall provides a scenic view of a passing nebula");
		rooms[2][4] = null;
		rooms[2][5] = null;
		rooms[2][6] = null;
		rooms[2][7] = new Room(false, false, new ArrayList<Item>(), null,"A narrow maintenance hallway\nThe walls have been smeared with someone's surplus blood");
		rooms[2][8] = null;
		rooms[2][9] = null;
		rooms[2][10] = null;
		
		rooms[3][0] = new Room(false, false, new ArrayList<Item>(), null,"Sleeping Quarters\nMost of the bunks have been torn to shreds. The trash can was carefully placed upside-down");
		rooms[3][1] = new Room(false, false, new ArrayList<Item>(), null,"A storage closest\nA skull sits on the shelf. 'with love, mom' is written across the brow");
		rooms[3][2] = null;
		rooms[3][3] = new Room(false, false, new ArrayList<Item>(), null,"A narrow maintenance hallway");
		rooms[3][4] = new Room(false, false, new ArrayList<Item>(), null,"The floor is covered in strewn human bones and viscera\n Horned helmets are piled against the north wall, though most have been broken");
		rooms[3][5] = new Room(false, true, new ArrayList<Item>(), null,"A central maintenance room\nDoors to the west and east provide access to the engine sector");
		rooms[3][6] = new Room(false, false, new ArrayList<Item>(), null,"This room is spotless\nSomeone even took the time to clean the ceilings");
		rooms[3][7] = new Room(false, false, new ArrayList<Item>(), null,"A narrow maintenance hallway");
		rooms[3][8] = null;
		rooms[3][9] = new Room(false, true, new ArrayList<Item>(), null,"Capt. Ormskaeg's private room\n The Captain's belongings have been thrown onto the floor");
		rooms[3][10] = new Room(false, false, new ArrayList<Item>(), null,"Sleeping quarters\nBunks are pushed against the north and east walls");
		
		rooms[4][0] = new Room(false, false, new ArrayList<Item>(), null, "Sleeping quarters\nThe west and east walls are lined with bunks\nBlood on the floor is evidence of a recent fight.");
		rooms[4][1] = null;
		rooms[4][2] = new Room(false, false, new ArrayList<Item>(), null, "A large bathroom\nSomeone knocked over all the stall walls. How rude.");
		rooms[4][3] = null;
		rooms[4][4] = null;
		rooms[4][5] = new Room(false, false, new ArrayList<Item>(), null, "A hallway\nThe door to the north has a sign on it: 'Engine Sector Access'");
		rooms[4][6] = null;
		rooms[4][7] = null;
		rooms[4][8] = new Room(false, false, new ArrayList<Item>(), null, "A small alcove filled with shelves\nThe shelves are mostly filled with salted fish");
		rooms[4][9] = null;
		rooms[4][10] = new Room(false, false, new ArrayList<Item>(), null, "These were sleeping quarters, though all the beds seem to be missing");
		
		rooms[5][0] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[5][1] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[5][2] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[5][3] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[5][4] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[5][5] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[5][6] = null;
		rooms[5][7] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[5][8] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[5][9] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[5][10] = new Room(false, false, new ArrayList<Item>(), null, "");
		
		rooms[6][0] = null;
		rooms[6][1] = null;
		rooms[6][2] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[6][3] = null;
		rooms[6][4] = null;
		rooms[6][5] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[6][6] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[6][7] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[6][8] = null;
		rooms[6][9] = null;
		rooms[6][10] = null;
		
		rooms[7][0] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[7][1] = null;
		rooms[7][2] = new Room(false, true, new ArrayList<Item>(), null, "");
		rooms[7][3] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[7][4] = null;
		rooms[7][5] = null;
		rooms[7][6] = null;
		rooms[7][7] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[7][8] = null;
		rooms[7][9] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[7][10] = null;
		
		rooms[8][0] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[8][1] = null;
		rooms[8][2] = null;
		rooms[8][3] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[8][4] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[8][5] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[8][6] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[8][7] = null;
		rooms[8][8] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[8][9] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[8][10] = new Room(false, false, new ArrayList<Item>(), null, "");
		
		rooms[9][0] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[9][1] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[9][2] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[9][3] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[9][4] = null;
		rooms[9][5] = null;
		rooms[9][6] = null;
		rooms[9][7] = null;
		rooms[9][8] = null;
		rooms[9][9] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[9][10] = null;
		
		rooms[10][0] = null;
		rooms[10][1] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[10][2] = null;
		rooms[10][3] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[10][4] = null;
		rooms[10][5] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[10][6] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[10][7] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[10][8] = null;
		rooms[10][9] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[10][10] = null;
		
		rooms[11][0] = null;
		rooms[11][1] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[11][2] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[11][3] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[11][4] = null;
		rooms[11][5] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[11][6] = null;
		rooms[11][7] = new Room(false, false, new ArrayList<Item>(), null, "The closet you took shelter in when it all went bad\nFor some reason it has extra radiation shielding");
		rooms[11][8] = null;
		rooms[11][9] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[11][10] = new Room(false, true, new ArrayList<Item>(), null, "");
		
		rooms[12][0] = null;
		rooms[12][1] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[12][2] = null;
		rooms[12][3] = null;
		rooms[12][4] = null;
		rooms[12][5] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[12][6] = null;
		rooms[12][7] = null;
		rooms[12][8] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[12][9] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[12][10] = null;
		
		rooms[13][0] = null;
		rooms[13][1] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[13][2] = null;
		rooms[13][3] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[13][4] = new Room(false, true, new ArrayList<Item>(), null, "");
		rooms[13][5] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[13][6] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[13][7] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[13][8] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[13][9] = new Room(false, false, new ArrayList<Item>(), null, "");
		rooms[13][10] = new Room(false, false, new ArrayList<Item>(), null, "");
		
		rooms[14][0] = new Room(false, false, new ArrayList<Item>(), null, "The bow of the ship\nA large window to the south provides a view of passing asteroids");
		rooms[14][1] = new Room(false, false, new ArrayList<Item>(), null, "The bow of the ship\nThe bulkhead to the south has sealed off access to the bridge\nThe room is full of comfortable chairs and piles of half-salted fish");
		rooms[14][2] = new Room(false, false, new ArrayList<Item>(), null, "The bow of the ship\nA human skeleton is lounging on a couch in front of the window\nThe large window provides a nice view of the passing debris. Is that the bridge floating over there?");
		rooms[14][3] = new Room(false, false, new ArrayList<Item>(), null, "The bow of the ship\nNormally one could see the bridge through the southern window, but it seems to be missing");
		rooms[14][4] = null;
		rooms[14][5] = new Room(false, false, new ArrayList<Item>(), null, "The secondary bow airlock it to the west, but it has been automatically sealed\nA lyn-axe has been thrown into the shattered southern window, triggering the bulkhead seal");
		rooms[14][6] = null;
		rooms[14][7] = new Room(false, false, new ArrayList<Item>(), null, "The main bow airlock is to east, but it has been automatically sealed\nHalf salted fish litters the floor\nYou can see a distant gas giant through the large window to the south");
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
	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
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
	 */
	public void moveNorth(){
		if (isDoor[0] && !isLocked[0]){
			currentY++;
			currentRoom = rooms[currentX][currentY];
			setAdjacentRooms();
		} else if (!isDoor[0])
			System.out.println("There is no door in that direction");
		else if (isLocked[0])
			System.out.println("You try to continue, but the door is locked");
	}
	
	/**
	 * Move the player east if there is a door there and it is not locked
	 */
	public void moveEast(){
		if (isDoor[1] && !isLocked[1]){
			currentX++;
			currentRoom = rooms[currentX][currentY];
			setAdjacentRooms();
		} else if (!isDoor[1])
			System.out.println("There is no door in that direction");
		else if (isLocked[1])
			System.out.println("You try to continue, but the door is locked");
	}
	
	/**
	 * Move the player north if there is a door there and it is not locked
	 */
	public void moveSouth(){
		if (isDoor[2] && !isLocked[2]){
			currentY--;
			currentRoom = rooms[currentX][currentY];
			setAdjacentRooms();
		} else if (!isDoor[2])
			System.out.println("There is no door in that direction");
		else if (isLocked[2])
			System.out.println("You try to continue, but the door is locked");
	}
	
	/**
	 * Move the player north if there is a door there and it is not locked
	 */
	public void moveWest(){
		if (isDoor[3] && !isLocked[3]){
			currentX--;
			currentRoom = rooms[currentX][currentY];
			setAdjacentRooms();
		} else if (!isDoor[3])
			System.out.println("There is no door in that direction");
		else if (isLocked[3])
			System.out.println("You try to continue, but the door is locked");
	}
	
	/**
	 * Returns a description of the current room
	 */
	public void look(){
		System.out.println(currentRoom.getDescription());
		if (isDoor[0]){
			if (isLocked[0])
				System.out.println("There is a locked door to the North");
			else
				System.out.println("There is a door to the North");
		}
		if (isDoor[1]){
			if (isLocked[1])
				System.out.println("There is a locked door to the East");
			else
				System.out.println("There is a door to the East");
		}
		if (isDoor[2]){
			if (isLocked[2])
				System.out.println("There is a locked door to the South");
			else
				System.out.println("There is a door to the South");
		}
		if (isDoor[3]){
			if (isLocked[3])
				System.out.println("There is a locked door to the West");
			else
				System.out.println("There is a door to the West");
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
	private void setAdjacentRooms(){
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
}
