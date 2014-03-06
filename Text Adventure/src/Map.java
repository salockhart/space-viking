import java.util.ArrayList;

/**
 * Map.java
 * @author Stanford Lockhart
 * B00646015
 * Mar 6, 2014
 * Dalhousie University
 * Faculty of Computer Science
 */
public class Map {

	//Instance variables
	Room[][] rooms = new Room[10][10];
	Room currentRoom;
	int currentX;
	int currentY;
	boolean[] isDoor = new boolean[4];	//0 for North, 1 for East, 2 for South, 3 for West
	boolean[] isLocked = new boolean[4]; 	//Same as above
	
	/**
	 * No args constructor, creates the map in the 2D array and sets all variables for first room
	 */
	public Map() {
		rooms[0][0] = new Room(false, false, new ArrayList<Item>(), );
		//fill with rooms -- new Room(isTrap, isLocked, items, enemy, description) 
		rooms[10][10] = new Room();
		currentRoom = rooms[0][0];
		currentRoom.playerVisits();
		currentX = 0;
		currentY = 0;
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
	 * Returns the map as a string
	 */
	@Override
	public String toString() {
		String map = "";
		for (int i = 9; i >= 0; i--){
			for (int j = 0; j < 10; j++){
				map += rooms[j][i];
			}
			map += "\n";
		}
		return map;
	}
	
	/**
	 * Sets whether adjacent rooms exist and/or are locked
	 */
	private void setAdjacentRooms(){
		isDoor[0] = rooms[currentX][currentY + 1] != null;
		isDoor[1] = rooms[currentX + 1][currentY] != null;
		isDoor[2] = rooms[currentX][currentY - 1] != null;
		isDoor[3] = rooms[currentX - 1][currentY] != null;
		isLocked[0] = rooms[currentX][currentY + 1].isLocked();
		isLocked[1] = rooms[currentX + 1][currentY].isLocked();
		isLocked[2] = rooms[currentX][currentY - 1].isLocked();
		isLocked[3] = rooms[currentX - 1][currentY].isLocked();
	}
}
