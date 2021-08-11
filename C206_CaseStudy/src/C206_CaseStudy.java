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

		System.out.println("7. Add purchase orders of ingredients by Stall Staff");
		System.out.println("8. View purchase order of ingredients by Stall Staff");
		System.out.println("9. Delete purchase orders of ingredients by Stall Staff");
		System.out.println("15. Quit");
		Helper.line(80, "-");

	}
	
	public static void addFoodItem(ArrayList<FoodItem> foodItemList){
		
	}
	
	public static String retrieveAllFI(ArrayList<FoodItem> foodItemList) {
		String output = "";
		// write your code here
		for (FoodItem f : foodItemList) {

			output += String.format("%-10s $%-10d\n", f.getName(),f.getPrice());
		}
		return output;
	}
	
	public static void viewAllFI(ArrayList<FoodItem> foodItemList) {
		
	}
	
	public static boolean findFI(ArrayList<FoodItem> foodItemList,String getName) {
		for (FoodItem f : foodItemList) {
			if(getName == f.getName()) {
				return true;
			}
		}
		return false;
	}
	
	public static void deleteFI(ArrayList<FoodItem> foodItemList){
		
	}
}
