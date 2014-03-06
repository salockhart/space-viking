<<<<<<< HEAD
import java.util.ArrayList;

/**
 * Room.java
 * @author Matthew Trask
 * B00639252
 * Mar 5, 2014
 * Dalhousie University
 * Faculty of Computer Science
 */
public class Room {

	//Instance variables
	private boolean isTrap;
	private boolean isLocked;
	private ArrayList<Item> items;
	private Person enemy;
	private Player player;
	private String description;
	private boolean hasVisited;
	
	/**
	 * Constructor to create the room 
	 * @param isTrap
	 * @param isLocked
	 * @param items
	 * @param enemy
	 * @param description
	 */
	public Room(boolean isTrap, boolean isLocked, ArrayList<Item> items, Person enemy, String description) {
		this.isTrap = isTrap;
		this.isLocked = isLocked;
		this.items = items;
		this.enemy = enemy;
		this.description = description;
		this.hasVisited = false;
	}
	
	/**
	 * @return whether the room is trapped or not
	 */
	public boolean isTrap() {
		return isTrap;
	}
	
	/**
	 * @return whether the room is locked or not
	 */
	public boolean isLocked() {
		return isLocked;
	}
	
	/**
	 * @param isLocked
	 * Unlocks the room
	 */
	public void unLock() {
		this.isLocked = false;
	}
	
	/**
	 * @return the array list of items in the room
	 */
	public ArrayList<Item> getItems() {
		return items;
	}
	
	/**
	 * Set the items in the room to the given arraylist
	 * @param items
	 */
	public void setItems(Item[] items) {
		this.items = items;
	}
	
	//this will likely not work as it's looking for item not item list I'll change once the item class is created
	/**
	 * Removes given Item from item list
	 * @param itemName
	 */
	public void removeItems(String itemName) {
		if(items.contains(itemName) {	
			items.remove(itemName);
		}
	}
	
	/**
	 * Adds a given Item to the items list
	 * @param adding
	 */
	public void addItems(Item adding) {
		items.add(adding);
	}
	
	/**
	 * @return the enemy object
	 */
	public Person getEnemy() {
		return enemy;
	}
	
	/**
	 * Sets enemy in room to inputted Enemy
	 * @param enemy
	 */
	public void setEnemy(Person enemy) {
		this.enemy = enemy;
	}
	
	/**
	 * @return the Player object
	 */
	public Player getPlayer() {
		return player;
	}
	
	/**
	 * Sets the player to given player object
	 * @param player
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	/**
	 * @return the room's String description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Sets the room's description to inputted String
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return whether player has visited the room
	 */
	public boolean hasVisited() {
		return hasVisited;
	}

	/**
	 * @param set the hasVisited variable to true
	 */
	public void playerVisits() {
		this.hasVisited = true;
	}

	/**
	 * Return the room as a string
	 */
	public String toString() {
		if (hasVisited)
			return "[*]";
		else
			return "[ ]";
	}
	
}
=======
import java.util.ArrayList;
public class Room {

	/**
	 * @author Matthew Trask B00639252
	 */
	
	private boolean isTrap;
	private boolean isLocked;
	private ArrayList<Item> items;
	private Person enemy;
	private Player player;
	private String description;
	
	
	public Room(boolean isTrap, boolean isLocked, Item[] items, Person enemy,String description) {
		this.isTrap = isTrap;
		this.isLocked = isLocked;
		this.items = items;
		this.enemy = enemy;
		this.description = description;
	}
	
	public boolean isTrap() {
		return isTrap;
	}
	
	public boolean isLocked() {
		return isLocked;
	}
	
	public void unLock(boolean isLocked) {
		this.isLocked = false;
	}
	
	public ArrayList<Item> getItems() {
		return items;
	}
	
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	
	//this will likely not work as it's looking for item not item list I'll change once the item class is created
	public void removeItems(String itemName) {
		if(items.contains(itemName)) {	
			items.remove(itemName);
		}
	}
	
	public void addItems(Item adding) {
		items.add(adding);
	}
	
	public Person getEnemy() {
		return enemy;
	}
	
	public void setEnemy(Person enemy) {
		this.enemy = enemy;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
}
>>>>>>> 601013ad2abf2431884301cc6829a4eb61a38a13
