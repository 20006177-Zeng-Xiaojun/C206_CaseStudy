/*
 * I declare that this code was written by me. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Nur Shakira
 * Student ID: 20024907
 * Class: W64E
 * Date/Time created: Wednesday 11-08-2021 10:10
 */

public class OrderItem {
	private int itemId;
	private String description;
	private int qty;
	private int price;
	private boolean isAvailable;
	
	public OrderItem(int itemId, String description, int qty,int price, boolean isAvailable) {
		this.itemId = itemId;
		this.description = description;
		this.qty = qty;
		this.price = price;
		this.isAvailable = isAvailable;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getprice() {
		return price;
	}

	public void setprice(int price) {
		this.price = price;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getDescription() {
		return description;
	}


}
