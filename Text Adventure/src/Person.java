import java.util.Random;

/**
 * Person.java
 * @author Niclas Skaalum
 * B00
 * Mar 6, 2014
 * Dalhousie University
 * Faculty of Computer Science
 */

public class Person
{
	//Instance Variables
	private String name,profession;
	private int health,strength,defense;
	private Item weapon;
	
	/**
	 * Constructor to create new Person (called by Player)
	 * @param name
	 * @param profession
	 * @param health
	 * @param strength
	 * @param defense
	 * @param weapon
	 */
	public Person(String name,String profession,int health,int strength,int defense,Item weapon)
	{
		this.name=name;
		this.profession=profession;
		this.health=health;
		this.strength=strength;
		this.defense=defense;
		this.weapon=new Item(weapon.getName(),weapon.getDetail(),weapon.getWeight(),
				weapon.getType(),weapon.getDataValue(),weapon.isPickupAble());
	}
	
	/**
	 * @return the name of the Person
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Set the name of the person
	 * @param name
	 */
	public void setName(String name)
	{
		this.name=name;
	}
	
	/**
	 * @return the current health of the Person
	 */
	public int getHealth()
	{
		return health;
	}
	
	/**
	 * Set the current health of the person
	 * @param health
	 */
	public void setHealth(int health)
	{
		this.health=health;
	}
	
	/**
	 * @return the strength value of the Person
	 */
	public int getStrength()
	{
		return strength;
	}
	
	/**
	 * Set the current strength value of the Person
	 * @param strength
	 */
	public void setStrength(int strength)
	{
		this.strength=strength;
	}
	
	/**
	 * @return the defense value of the Person
	 */
	public int getDefense()
	{
		return defense;
	}
	
	/**
	 * Set the defense value of the Person
	 * @param defense
	 */
	public void setDefense(int defense)
	{
		this.defense=defense;
	}
	
	/**
	 * @return the current weapon of the Person
	 */
	public Item getWeapon()
	{
		return weapon;
	}
	 
	/**
	 * Change the current weapon of the Person
	 * @param weapon
	 */
	public void setWeapon(Item weapon)
	{
		this.weapon=weapon;
	}
	
	/**
	 * @return the current profession of the Person
	 */
	public String getProfession()
	{
		return profession;
	}
	
	/**
	 * Set the current profession of the Person
	 * @param profession
	 */
	public void setProfession(String profession)
	{
		this.profession=profession;
	}
	
	/**
	 * Calculate the damage done and subtract from health
	 * @param damage
	 * @return
	 */
	public int takeDamage(int damage)
	{
		double temp;
		temp = damage - (0.5*this.getDefense());
		if (temp < 0) 
			temp = 0;
		
		health -= (int)Math.round(temp);
		return (int)Math.round(temp);
	}
	
	/**
	 * Deal damage based on weapon and strength
	 * @return damage
	 */
	public int dealDamage()
	{
		Random gen= new Random();
		int damage;
		
		int factor= gen.nextInt(5);
		
		damage= (int)Math.round(this.getWeapon().getDataValue()+ factor*(0.8*this.getStrength()) + 25*Math.log(0.25*this.getStrength()));
		
		return damage;
	}
	
	/**
	 * Return person as a string
	 */
	public String toString()
	{
		return "<br>Status:<br>Health:&#160;&#160;&#160;&#160;&#160;"+health+"<br>Strength:&#160;&#160;&#160;&#160;&#160;"+strength
				+"<br>Defense:&#160;&#160;&#160;&#160;&#160;"+defense+"<br>Weapon name:&#160;&#160;&#160;&#160;&#160;"+weapon.getName();
	}
}
