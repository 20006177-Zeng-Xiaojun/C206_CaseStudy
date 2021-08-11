
public class PurchaseOrder {
	private int poID;
	private int totalIngredients;
	private String stallName;
	
	public PurchaseOrder(int poID, int totalIngredients, String stallName) {
		this.poID = poID;
		this.totalIngredients = totalIngredients;
		this.stallName = stallName;
	}

	public int getPoID() {
		return poID;
	}

	public void setPoID(int poID) {
		this.poID = poID;
	}

	public int getTotalIngredients() {
		return totalIngredients;
	}

	public void setTotalIngredients(int totalIngredients) {
		this.totalIngredients = totalIngredients;
	}

	public String getStallName() {
		return stallName;
	}

	public void setStallName(String stallName) {
		this.stallName = stallName;
	}
	
	
	
}
