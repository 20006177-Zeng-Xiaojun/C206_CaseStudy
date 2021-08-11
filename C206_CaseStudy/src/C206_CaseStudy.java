import java.util.ArrayList;

public class C206_CaseStudy {
	
	private static final int OPTION_QUIT = 4;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Arraylist for User stories - 7 , 8 and 9
		ArrayList<PurchaseOrder> poList = new ArrayList<PurchaseOrder>();
		poList.add(new PurchaseOrder (1,5,"Fruit Stall"));
		poList.add(new PurchaseOrder (2,8,"Drink Stall"));
		poList.add(new PurchaseOrder (3,4,"Mix Veg Stall"));
		poList.add(new PurchaseOrder (4,7,"Chicken Rice Stall"));
		poList.add(new PurchaseOrder (5,2,"Western Stall"));
		
		int option = 0;

		while (option != OPTION_QUIT) {
			menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				PurchaseOrder cc = inputPO();
				C206_CaseStudy.addPurchaseOrder(poList, cc);
			}
			else if (option == 2) {
				C206_CaseStudy.retrieveAllPO(poList);
				C206_CaseStudy.viewAllPO(poList);
			}
			else if (option == 3) {
				C206_CaseStudy.deletePO(poList);
			}
			else if (option == 4) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}
		}
		
	}
	public static void menu() {
		C206_CaseStudy.setHeader("Canteen Automation");
		System.out.println("1. Add purchase orders of ingredients by Stall Staff");
		System.out.println("2. View purchase order of ingredients by Stall Staff");
		System.out.println("3. Delete purchase orders of ingredients by Stall Staff");
		System.out.println("4. Quit");
		Helper.line(80, "-");

	}
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	public static PurchaseOrder inputPO() {
		int poId = Helper.readInt("Enter purchase order id > ");
		int amtIngredients = Helper.readInt("Enter total amout of ingredients > ");
		String zoom = Helper.readString("Enter stall name > ");

		PurchaseOrder cc= new PurchaseOrder(poId, amtIngredients, zoom);
		return cc;
		
	}
	public static void addPurchaseOrder(ArrayList<PurchaseOrder> poList, PurchaseOrder cc){
		poList.add(cc);
		System.out.println("\nPurchase Order has been successfully added!\n");
	}
	
	public static String retrieveAllPO(ArrayList<PurchaseOrder> poList) {
		String output = "";
		// write your code here
		for (int i = 0; i < poList.size(); i++) {

			output += String.format("%-10s %-30s %-10s\n", poList.get(i).getPoID(),
					poList.get(i).getTotalIngredients(), poList.get(i).getStallName());
		}
		return output;
	}
	
	public static void viewAllPO(ArrayList<PurchaseOrder> poList) {
		C206_CaseStudy.setHeader("View Purchase order");
		String output = String.format("%-10s %-30s %-10s\n", "PO ID", "TOTAL INGREDIENTS",
				"STALL NAME");
		 output += retrieveAllPO(poList);	
		System.out.println(output);
	}
	
	public static boolean findPO(ArrayList<PurchaseOrder> poList,int poId) {
		for (int j = 0; j < poList.size(); j++) {
			if(poId == poList.get(j).getPoID()) {
				return true;
			}
		}
		return false;
	}
	
	public static void deletePO(ArrayList<PurchaseOrder> poList){
		int id = Helper.readInt("Enter purchase order id to delete > ");
		if(findPO(poList, id)) {
			for (int j = 0; j < poList.size(); j++) {
				if(id == poList.get(j).getPoID()) {
					poList.remove(j);
				}
			}System.out.println("\nPurchase Order #"+id+ "has been successfully deleted!\n");
		}
		
	}
}
