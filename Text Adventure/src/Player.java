import java.util.ArrayList;
public class Player extends Person
{
	private ArrayList<Item> inventory = new ArrayList<Item>();
	private String saint;
	
	public Player(String name,String profession,int health,int strength,
			int defense,Item weapon,ArrayList<Item> inventory,String saint)
	{
		super(name,profession,health,strength,defense,weapon);
		this.saint=saint;
		inventory=new ArrayList<Item>();
	}

	public void dropItem()
	{
		inventory.remove(index);
	}
	
	public void pickupItem(Item item)
	{
		inventory.add(item);
	}
	
	public ArrayList<String> getInventory()
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
}
