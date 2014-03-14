public class Person
{
	private String name,profession;
	private int health,strength,defense;
<<<<<<< HEAD
	//private Item weapon;
	
	public Person(String name,String profession,int health,int strength,int defense/*,Item weapon*/)
=======
	private Item weapon;
	
	public Person(String name,String profession,int health,int strength,int defense,Item weapon)
>>>>>>> master
	{
		this.name=name;
		this.profession=profession;
		this.health=health;
		this.strength=strength;
		this.defense=defense;
<<<<<<< HEAD
		/*this.weapon=new Item(weapon.getName() etc...*/
=======
		this.weapon=new Item(weapon.getName(),weapon.getDetail(),weapon.getWeight(),
				weapon.getType(),weapon.getDataValue(),weapon.isPickupAble);
>>>>>>> master
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public int getHealth()
	{
		return health;
	}
	
	public void setHealth(int health)
	{
		this.health=health;
	}
	
	public int getStrength()
	{
		return strength;
	}
	
	public void setStrength(int strength)
	{
		this.strength=strength;
	}
	
	public int getDefense()
	{
		return defense;
	}
	
	public void setDefense(int defense)
	{
		this.defense=defense;
	}
	
<<<<<<< HEAD
	/*
=======
>>>>>>> master
	public Item getWeapon()
	{
		return weapon;
	}
	 
	public void setWeapon(Item weapon)
	{
		this.weapon=weapon;
	}
<<<<<<< HEAD
	*/
=======
>>>>>>> master
	
	public String getProfession()
	{
		return profession;
	}
	
	public void setProfession(String profession)
	{
		this.profession=profession;
	}
	
	public void takeDamage(int damage)
	{
		health-=damage;
	}
	
<<<<<<< HEAD
	/*
	public double dealDamage(int damage)
	{
		return weapon.getWeight()+(.1*strength)...whatever damage formula ends up being
	}
	*/
=======
	public double dealDamage(int damage)
	{
		return weapon.getWeight()+(.1*strength); //whatever damage formula ends up being
	}
>>>>>>> master
	
	public String toString()
	{
		return "\nStatus:\nHealth:\t"+health+"\nStrength:\t"+strength
<<<<<<< HEAD
				+"\nDefense:\t"+defense+"\nWeapon name:\t"+/*weapon.getName()+*/
					"\nWeapon strength:\t"/*+weapon.getStrength()*/;
=======
				+"\nDefense:\t"+defense+"\nWeapon name:\t"+weapon.getName();
>>>>>>> master
	}
}
