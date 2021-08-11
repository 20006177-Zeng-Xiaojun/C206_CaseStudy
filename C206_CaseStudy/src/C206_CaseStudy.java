import java.util.ArrayList;

public class C206_CaseStudy {

	private static final int OPTION_QUIT = 16;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Arraylist for User stories - 4 , 5 and 6
		ArrayList<FoodItem> foodItemList = new ArrayList<FoodItem>();
		foodItemList.add(new FoodItem ("Nasi Ayam", 4));
		foodItemList.add(new FoodItem ("Nasi Lemak", 3));
		foodItemList.add(new FoodItem ("Chicken Chop", 5));
		foodItemList.add(new FoodItem ("Steak", 15));
		foodItemList.add(new FoodItem ("Rib Eye", 15));
		
		int option = 0;

		while (option != OPTION_QUIT) {
			menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 7) {
				addPurchaseOrder(foodItemList);
			}
			else if (option == 8) {
				retrieveAllPO(foodItemList);
				viewAllPO(foodItemList);
			}
			else if (option == 9) {
				deletePO(foodItemList);
			}
			else if (option == 16) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}
		}
	
	}
}
