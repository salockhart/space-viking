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
