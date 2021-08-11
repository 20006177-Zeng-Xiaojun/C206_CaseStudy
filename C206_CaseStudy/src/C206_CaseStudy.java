import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Arraylist for User stories - 7 , 8 and 9
		ArrayList<PurchaseOrder> poList = new ArrayList<PurchaseOrder>();
		poList.add(new PurchaseOrder (1,5,"Fruit Stall"));
		poList.add(new PurchaseOrder (2,8,"Drink Stall"));
		poList.add(new PurchaseOrder (3,4,"Mix Veg Stall"));
		poList.add(new PurchaseOrder (4,7,"Chicken Rice Stall"));
		poList.add(new PurchaseOrder (5,2,"Western Stall"));
		
		
		ArrayList<FoodItem> foodItemList = new ArrayList<FoodItem>();
		foodItemList.add(new FoodItem("Nasi Ayam", 3));
		foodItemList.add(new FoodItem("Steak", 15));
		
		ArrayList<OrderItem> OrderList = new ArrayList<OrderItem>();
		
		int option = -1;

		while (option != 16) {
			menu();
			option = Helper.readInt("Enter an option >");

			if (option == 1) {
				
			}
			else if (option == 4) {
				FoodItem fi = inputFoodItem();
				addFoodItem(foodItemList,fi);
			} 
			else if (option == 5) {
				retrieveAllFI(foodItemList);
				viewAllFI(foodItemList);
			}
			else if (option == 6) {
				deleteFI(foodItemList);
			} 
			else if (option == 7) {
				PurchaseOrder cc = inputPO();
				C206_CaseStudy.addPurchaseOrder(poList, cc);
			}
			else if (option == 8) {
				C206_CaseStudy.viewAllPO(poList);
			}
			else if (option == 9) {
				C206_CaseStudy.deletePO(poList);
			} 
			else if(option == 13) {
				C206_CaseStudy.viewAllOrders(OrderList);
			} 
			else if (option == 14) {
				// Add Order
				Foodmenu();
				OrderItem OI = inputItem();
				C206_CaseStudy.addItem(OrderList, OI);
			}
				else if (option == 16) {
				System.out.println("Bye!");
			} 
			else {
				System.out.println("Invalid option");
			}
		}
		
	}
	public static void menu() {
		C206_CaseStudy.setHeader("Canteen Automation");
		System.out.println("4. Add Food Item Into Menu");
		System.out.println("5. View Food Item In Menu");
		System.out.println("6. Delete Food Item In Menu");
		System.out.println("7. Add purchase orders of ingredients by Stall Staff");
		System.out.println("8. View purchase order of ingredients by Stall Staff");
		System.out.println("9. Delete purchase orders of ingredients by Stall Staff");
		System.out.println("13. View All Order");
		System.out.println("14. Add Order");
		System.out.println("16. Quit");
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
	public static FoodItem inputFoodItem() {
		String fiName = Helper.readString("Enter food item name > ");
		int fiPrice = Helper.readInt("Enter food item price > $");

		FoodItem fi= new FoodItem(fiName, fiPrice);
		return fi;
		
	}
	
	public static void addFoodItem(ArrayList<FoodItem> foodItemList, FoodItem fi) {
		foodItemList.add(fi);

		System.out.println("Food Item added!");
	}

	public static String retrieveAllFI(ArrayList<FoodItem> foodItemList) {
		String output = "";
		// write your code here
		for (FoodItem f : foodItemList) {

			output += String.format("%-20s %10d\n", f.getName(), f.getPrice());
		}
		return output;
	}

	public static void viewAllFI(ArrayList<FoodItem> foodItemList) {
		C206_CaseStudy.setHeader("View Purchase order");
		String output = String.format("%-20s %-10s\n", "FOOD ITEM", "PRICE", "STALL NAME");
		output += retrieveAllFI(foodItemList);
		System.out.println(output);
	}

	public static boolean findFI(ArrayList<FoodItem> foodItemList, String getName) {
		for (FoodItem f : foodItemList) {
			if (getName == f.getName()) {
				return true;
			}
		}
		return false;
	}
	
	public static void deleteFI(ArrayList<FoodItem> foodItemList) {
		String name = Helper.readString("Enter purchase order id to delete > ");
		if (findFI(foodItemList, name)) {
			for (FoodItem f : foodItemList) {
				if (name == f.getName()) {
					foodItemList.remove(f);
				}
			}
			System.out.println("\nFood Item Name: " + name + "has been successfully deleted!\\n");
		}
	}
	
	public static void Foodmenu() {
		Helper.line(40, "=");
		System.out.println("MENU");
		Helper.line(40, "=");
		System.out.println("1.Chicken rice : $3");
		System.out.println("2.Chicken Sandwhich: $2");
		System.out.println("3.Fried rice: $3 ");
		System.out.println("4.Sphagetti:$4 ");
		System.out.println("5.Mac and Cheese: $3");
		Helper.line(80, "-");

	}
	public static OrderItem inputItem() {
		    int id = Helper.readInt("Enter Item number (1 - 5)>");
			String description = Helper.readString("Enter description > ");
			int qty = Helper.readInt("Enter qty >");
			int price = Helper.readInt("Enter price of item >");
				
			OrderItem OI = new OrderItem(id,description,qty,price,true);
			return OI;
		
	}

	public static void addItem(ArrayList<OrderItem> OrderList,OrderItem OI) {
		if(OI.getQty() > 5) {
			System.out.println("Maximum number of item you can purchase is 5.");
		}else {
		OrderList.add(OI);
		System.out.println("Order added. Your total cost is $"+ (OI.getprice() *OI.getQty()));
		}
	}
	private static Object showAvailability(boolean isAvailable) {
		// TODO Auto-generated method stub
		String avail;

		if (isAvailable == true) {
			avail = "Yes";
		} else {
			avail = "No";
		}
		return avail;
	}
	public static String retrieveAllOrder(ArrayList<OrderItem> OrderList) {
		String output = "";
		// write your code here
		for (int i = 0; i < OrderList.size(); i++) {

			output += String.format("%-10d %-30s %-10d %-10d\n",OrderList.get(i).getItemId(),
					OrderList.get(i).getDescription(), OrderList.get(i).getQty(),OrderList.get(i).getprice());
		}
		return output;
	}
	public static void viewAllOrders(ArrayList<OrderItem> OrderList) {
		Helper.line(40, "=");
		System.out.println("CAMCORDER LIST");
		Helper.line(40, "=");
		String output = String.format("%-10s %-30s %-10s %-10s\n", "ItemID", "DESCRIPTION","QTY","Price",
				"AVAILABILITY");
		output += retrieveAllOrder(OrderList);	
		System.out.println(output);
	}
}
