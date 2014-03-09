/**
 * Item.java
 * @author Geoffrey Caven
 * B00629837
 * Mar 6, 2014
 * Dalhousie University
 * Faculty of Computer Science
 */

public class Item {
	
	private String name;
	private String detail;
	private int weight;
	private String type;
	private int dataValue;
	private boolean pickupAble;
	
	public Item(String name, String detail, int weight, String type,
			int dataValue, boolean pickupAble) {
		this.name = name;
		this.detail = detail;
		this.weight = weight;
		this.type = type;
		this.dataValue = dataValue;
		this.pickupAble = pickupAble;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getDataValue() {
		return dataValue;
	}
	public void setDataValue(int dataValue) {
		this.dataValue = dataValue;
	}
	public boolean isPickupAble() {
		return pickupAble;
	}
	public void setPickupAble(boolean pickupAble) {
		this.pickupAble = pickupAble;
	}
	
}
