import java.util.ArrayList;
import java.util.Random;

/**
 * Person.java
 * @author Niclas Skaalum
 * B00
 * Mar 6, 2014
 * Dalhousie University
 * Faculty of Computer Science
 */

public class Player extends Person
{
	//Instance Variables
	private ArrayList<Item> inventory;
	private String saint;
	private int maxHealth;

	/**
	 * Constructor to create the Player (Calls Person)
	 * @param name
	 * @param profession
	 * @param health
	 * @param strength
	 * @param defense
	 * @param weapon
	 * @param saint
	 */
	public Player(String name,String profession,int health,int strength,
			int defense,Item weapon,String saint)
	{
		super(name,profession,health,strength,defense,weapon);
		this.saint=saint;
		inventory=new ArrayList<Item>();
		maxHealth=health;
	}
	
	/**
	 * @return the weight of the items in the inventory
	 */
	public int getInventoryWeight() {
		int weight= 0;
		
		for(int i=0; i<inventory.size(); i++) {
			weight+= inventory.get(i).getWeight();
		}
		if (weight == 0)
			return 1;
		else
			return weight;
	}
	
	/**
	 * Set the maximum health the player can have
	 * @param maxHealth
	 */
	public void setMaxHealth(int maxHealth)
	{
		this.maxHealth=maxHealth;
	}
	
	/**
	 * @return the max player health
	 */
	public int getMaxHealth()
	{
		return maxHealth;
	}
	
	/**
	 * Change player health, ensuring it is within the maximum
	 */
	public void setHealth(int health)
	{
		super.setHealth(health);
		if(getHealth()>maxHealth)
			setHealth(maxHealth);
	}
	
	/**
	 * Increment the player's health by a value, ensuring it is within the maximum
	 * @param health
	 */
	public void heal(int health)
	{
		setHealth(getHealth() + health);
	}
	
	/**
	 * Remove the specified item from the inventory
	 * @param index
	 */
	public void dropItem(int index)
	{
		inventory.remove(index);
	}

	/**
	 * Add input item to inventory
	 * @param item
	 */
	public void pickupItem(Item item)
	{
		inventory.add(item);
	}

	/**
	 * Return the inventory arraylist
	 * @return
	 */
	public ArrayList<Item> getInventory()
	{
		return inventory;
	}

	/**
	 * Print the inventory name
	 */
	public void printInventory()
	{
		System.out.println("\n\ninventory\n");
	}

	/**
	 * @return the player's chosen saint (DEPRECATED)
	 */
	public String getSaint()
	{
		return saint;
	}

	/**
	 * Set the player's chosen saint (DEPRECATED)
	 * @param saint
	 */
	public void setSaint(String saint)
	{
		this.saint=saint;
	}
	
	/**
	 * @return whether the inventory contains a key
	 */
	public boolean hasKey(){
		for (Item i : inventory)
			if (i.getType().equals("Key"))
				return true;
		return false;
	}
	
	/**
	 * Delete the first occurrence of the specified item type in the inventory
	 * @param n
	 */
	public void deleteItem(String n){
		for (int i = 0; i < inventory.size(); i++)
			if (inventory.get(i).getType().equals(n)){
				inventory.remove(i);
				return;
			}
	}
	
	/**
	 * Calculate the damage done by the player
	 */
	public int dealDamage()	//overrides person dealDamage method
	{
		Random gen= new Random();
		int damage;
		
		int factor= gen.nextInt(5)+1;
		
		damage= (int)Math.round(this.getWeapon().getDataValue()+ factor*(0.1*this.getStrength())+ 25*Math.log(this.getStrength()/this.getInventoryWeight()));
		
		return damage;
	}
}
