
public class Promotion {
	private int promoID;
	private String name;
	private String promoItem;
	
	public Promotion(int promoID, String name, String promoItem) {
		super();
		this.promoID = promoID;
		this.name = name;
		this.promoItem = promoItem;
	}
	
	public int getPromoID() {
		return promoID;
	}

	public void setPromoID(int promoID) {
		this.promoID = promoID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPromoItem() {
		return promoItem;
	}

	public void setPromoItem(String promoItem) {
		this.promoItem = promoItem;
	}

	
}
