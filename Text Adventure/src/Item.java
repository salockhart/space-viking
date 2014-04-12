/**
 * Item.java
 * @author Geoffrey Caven
 * B00629837
 * Mar 6, 2014
 * Dalhousie University
 * Faculty of Computer Science
 */

public class Item {
	
	//Instance Variables
	private String name;
	private String detail;
	private int weight;
	private String type;
	private int dataValue;
	private boolean pickupAble;
	
	/**
	 * Constructor to create a new Item
	 * @param name
	 * @param detail
	 * @param weight
	 * @param type
	 * @param dataValue
	 * @param pickupAble
	 */
	public Item(String name, String detail, int weight, String type,
			int dataValue, boolean pickupAble) {
		this.name = name;
		this.detail = detail;
		this.weight = weight;
		this.type = type;
		this.dataValue = dataValue;
		this.pickupAble = pickupAble;
	}

	/**
	 * @return name of the object
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Set name of object
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the detail string for the Item
	 */
	public String getDetail() {
		return detail;
	}
	
	/**
	 * Set the detail string of an Item
	 * @param detail
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	/**
	 * @return the weight of an item
	 */
	public int getWeight() {
		return weight;
	}
	
	/**
	 * Set the weight of an item
	 * @param weight
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	/**
	 * @return the Item's type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Set the type of Item
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * @return the data value of the Item
	 */
	public int getDataValue() {
		return dataValue;
	}
	
	/**
	 * Set the data value of an Item
	 * @param dataValue
	 */
	public void setDataValue(int dataValue) {
		this.dataValue = dataValue;
	}
	
	/**
	 * @return whether the Item can be picked up
	 */
	public boolean isPickupAble() {
		return pickupAble;
	}
	
	/**
	 * Set whether the Item can be picked up
	 * @param pickupAble
	 */
	public void setPickupAble(boolean pickupAble) {
		this.pickupAble = pickupAble;
	}

	/**
	 * Return the Item as a String
	 */
	@Override
	public String toString()
	{
		return getName();
	}
	
}