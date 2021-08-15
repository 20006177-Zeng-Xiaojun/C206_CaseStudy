
public class Stall {
	private String vendName;
	private String cuisineType;
	private int phoneNum;
	private String stallName;
	
	
	public Stall(String vendName, String cuisineType, int phoneNum, String stallName) {
		
		this.vendName = vendName;
		this.cuisineType = cuisineType;
		this.phoneNum = phoneNum;
		this.stallName = stallName;
	}
	
	public String getName() {
		return vendName;
	}
	
	public String getCuisine() {
		return cuisineType;
	}
	
	public int getNo() {
		return phoneNum;
		
	}
	
	public String getStallName() {
		return stallName;
	}
}
