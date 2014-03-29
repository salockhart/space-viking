import java.util.ArrayList;
import java.util.Random;

public class Player extends Person
{
	private ArrayList<Item>inventory;
	private String saint;

	public Player(String name,String profession,int health,int strength,
			int defense,Item weapon,String saint)
	{
		super(name,profession,health,strength,defense,weapon);
		this.saint=saint;
		inventory=new ArrayList<Item>();
	}
	
	public int getInventoryWeight() {
		int weight= 0;
		
		for(int i=0; i<inventory.size(); i++) {
			weight+= inventory.get(i).getWeight();
		}
		return weight;
	}

	public void dropItem(int index)
	{
		inventory.remove(index);
	}

	public void pickupItem(Item item)
	{
		inventory.add(item);
	}

	public ArrayList<Item> getInventory()
	{
		return inventory;
	}

	public void printInventory()
	{
		System.out.println("\n\ninventory\n");
	}

	public String getSaint()
	{
		return saint;
	}

	public void setSaint(String saint)
	{
		this.saint=saint;
	}
	
	public double dealDamage()	//overrides person dealDamage method
	{
		Random gen= new Random();
		int damage;
		
		double factor= gen.nextInt(5)+1;
		
		damage= (int)Math.round(this.getWeapon().getDataValue()+ factor*(0.1*this.getStrength())+ 25*Math.log(this.getStrength()/this.getInventoryWeight()));
		
		return damage;
	}
}
