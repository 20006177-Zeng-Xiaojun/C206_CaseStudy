import java.util.ArrayList;

public class C206_CaseStudy {
	
	private static final int OPTION_QUIT = 16;

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
			
			if(option == 1) {
				
			}
			else if (option == 2) {
				
			}
			else if (option == 3) {
				
			}
			else if (option == 4) {
				
			}
			else if (option == 5) {
				
			}
			else if (option == 6) {
				
			}
			else if (option == 7) {
				addPurchaseOrder(poList);
			}
			else if (option == 8) {
				retrieveAllPO(poList);
				viewAllPO(poList);
			}
			else if (option == 9) {
				deletePO(poList);
			}
			else if (option == 10) {
				
			}
			else if (option == 11) {
				
			}
			else if (option == 12) {
				
			}
			else if (option == 13) {
				
			}
			else if (option == 14) {
				
			}
			else if (option == 15) {
				
			}
			else if (option == 16) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}
		}
		
	}
	public static void menu() {
		C206_CaseStudy.setHeader("Canteen Automation");
		System.out.println("1. ");
		System.out.println("2. ");
		System.out.println("3. ");
		System.out.println("4. ");
		System.out.println("5. ");
		System.out.println("6. ");
		System.out.println("7. Add purchase orders of ingredients by Stall Staff");
		System.out.println("8. View purchase order of ingredients by Stall Staff");
		System.out.println("9. Delete purchase orders of ingredients by Stall Staff");
		System.out.println("10. ");
		System.out.println("11. ");
 		System.out.println("12. ");
		System.out.println("13. ");
		System.out.println("14. ");
		System.out.println("15. ");
		System.out.println("16. Quit");
		Helper.line(80, "-");

	}
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	
	public static void addPurchaseOrder(ArrayList<PurchaseOrder> poList){
		int poId = Helper.readInt("Enter purchase order id > ");
		int amtIngredients = Helper.readInt("Enter total amout of ingredients > ");
		String zoom = Helper.readString("Enter stall name > ");

		poList.add(new PurchaseOrder (poId, amtIngredients, zoom));
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
	
	public static void deletePO(ArrayList<PurchaseOrder> poList) {
		int poId = Helper.readInt("Enter purchase order id to delete > ");
		for (int i = 0; i < poList.size(); i++) {
			if(poId == poList.get(i).getPoID()) {
				poList.remove(i);
			}
		}
	}
}
