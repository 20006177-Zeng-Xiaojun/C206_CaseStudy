import java.util.ArrayList;

public class C206_CaseStudy {

	private static final int OPTION_QUIT = 16;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Arraylist for User stories - 4 , 5 and 6
		ArrayList<FoodItem> foodItemList = new ArrayList<FoodItem>();
		foodItemList.add(new FoodItem("Nasi Ayam", 4));
		foodItemList.add(new FoodItem("Nasi Lemak", 3));
		foodItemList.add(new FoodItem("Chicken Chop", 5));
		foodItemList.add(new FoodItem("Steak", 15));
		foodItemList.add(new FoodItem("Rib Eye", 15));

		int option = 0;

		while (option != OPTION_QUIT) {
			menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 4) {
				addFoodItem(foodItemList);
			} else if (option == 5) {
				retrieveAllFI(foodItemList);
				viewAllFI(foodItemList);
			} else if (option == 6) {
				deleteFI(foodItemList);
			} else if (option == 16) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}
		}

	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	public static void menu() {
		C206_CaseStudy.setHeader("Canteen Automation");

		System.out.println("4. Add Food Item Into Menu");
		System.out.println("5. View Food Item In Menu");
		System.out.println("6. Delete Food Item In Menu");
		System.out.println("16. Quit");
		Helper.line(80, "-");

	}

	public static void addFoodItem(ArrayList<FoodItem> foodItemList) {
		String fiName = Helper.readString("Enter food item name > ");
		int fiPrice = Helper.readInt("Enter food item price > $");

		foodItemList.add(new FoodItem(fiName, fiPrice));

		System.out.println("\nFood Item Name:" + fiName + " has been successfully added!\n");
	}

	public static String retrieveAllFI(ArrayList<FoodItem> foodItemList) {
		String output = "";
		// write your code here
		for (FoodItem f : foodItemList) {

			output += String.format("%-10s $%-10d\n", f.getName(), f.getPrice());
		}
		return output;
	}

	public static void viewAllFI(ArrayList<FoodItem> foodItemList) {
		C206_CaseStudy.setHeader("View Purchase order");
		String output = String.format("%-10s %-10s\n", "FOOD ITEM", "PRICE", "STALL NAME");
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
					foodItemList.remove(name);
				}
			}
			System.out.println("\nFood Item Name: " + name + "has been successfully deleted!\\n");
		}
	}
}
