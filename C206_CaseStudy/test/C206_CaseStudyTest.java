import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private PurchaseOrder po1;
	private PurchaseOrder po2;
	private PurchaseOrder po3;
	private ArrayList<PurchaseOrder> poList;
	
	private FoodItem fi1;
	private FoodItem fi2;
	private ArrayList<FoodItem> foodItemList;
	
	private OrderItem O1;
	private OrderItem O2;
	private OrderItem O3;
	private OrderItem O4;
	ArrayList<OrderItem> OrderList = new ArrayList<OrderItem>(100);
	
	@Before
	public void setUp() throws Exception {
		po1 = new PurchaseOrder (1,5,"Fruit Stall");
		po2 = new PurchaseOrder (2,8,"Drink Stall");
		po3 = new PurchaseOrder (3,4,"Mix Veg Stall");
		poList= new ArrayList<PurchaseOrder>();
		
		fi1 = new FoodItem("Nasi Ayam", 3);
		fi2 = new FoodItem("Steak", 15);
		foodItemList = new ArrayList<FoodItem>();
		
		O1 = new OrderItem(1,"Chicken Rice",2,3,true);
		O2 = new OrderItem(2,"Chicken Sandwhich",6,2,true);
		O3 = new OrderItem(3,"Fried Rice",2,3,false);
		O4 = new OrderItem(4,"Mac and Cheese",1,3,true);
		OrderList = new ArrayList<OrderItem>();
	}

	@Test
	public void testAddPurchaseOrder() {
		C206_CaseStudy.addPurchaseOrder(poList, po1);	
		//Test that purchase order list is empty, after add 1 purchase order, the size of the list is 1. (Normal condition)
		assertEquals(1,poList.size());
		
		//Test that purchase order list didn't not meet the maximum order, so that a new item can be added to (Boundary condition)
		assertNotEquals(8, poList.size());
		C206_CaseStudy.addPurchaseOrder(poList, po2);
		
		//Test that purchase order that newly added is in the same item as the last purchase order in the list, if not flag out error (Error condition)
		assertSame(po2, poList.get(poList.size()-1));
	}
	
	@Test
	public void testRetrieveAllPO() {
		//Test that purchase order list is not null, so that the string output will display the list of items (Boundary condition)
		assertNotNull(poList);
		C206_CaseStudy.retrieveAllPO(poList);
		C206_CaseStudy.viewAllPO(poList);
		
		//Test that given list and the retrieved list output is the same (Normal Condition)
		C206_CaseStudy.addPurchaseOrder(poList, po1);	
		String outputString = String.format("%-10s %-30s %-10s\n", "1", "5","Fruit Stall");
		assertEquals(outputString, C206_CaseStudy.retrieveAllPO(poList));
		
		//Test that given list is empty, after adding 2 items, the size list is 2, if not flag out error. (Error condition)
		C206_CaseStudy.addPurchaseOrder(poList, po2);
		assertEquals(2, poList.size());
	}
	
	@Test
	public void testDeletePO() {
		poList.add(po1);
		poList.add(po2);
		poList.add(po3);
		//Purchase order to be deleted is currently available. If not available, flag out error. (Error condition)
		assertTrue(C206_CaseStudy.findPO(poList,po1.getPoID()));
		poList.remove(po1);
		
		//Test that purchase order deleted is not longer in the in the list. (Normal condition)
		assertFalse(C206_CaseStudy.findPO(poList,po1.getPoID()));
		
		//Test that purchase order list is not null, so to retrieved the purchase order and delete it. (Boundary condition)
		assertNotNull(poList);
		C206_CaseStudy.retrieveAllPO(poList);
		poList.remove(po2);
	}
	
	@Test
	public void addFoodItem() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid FoodItem arraylist to add to", foodItemList);

		// Given an empty list, after adding 1 item, the size of the list is 1 - normal
		// The item just added is as same as the first item of the list
		C206_CaseStudy.addFoodItem(foodItemList, fi1);
		assertEquals("Check that FoodItem arraylist size is 1", 1, foodItemList.size());
		assertSame("Check that FoodItem is added", fi1, foodItemList.get(0));

		// Add another item. test The size of the list is 2? -normal
		// The item just added is as same as the second item of the list
		C206_CaseStudy.addFoodItem(foodItemList, fi2);
		assertEquals("Check that FoodItem arraylist size is 2", 2, foodItemList.size());
		assertSame("Check that FoodItem is added", fi2, foodItemList.get(1));
	}
	
	@Test
	public void retrieveAllFoodItemTest() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid FoodItem arraylist to retrieve item", foodItemList);

		// test if the list of food item retrieved from the SourceCentre is empty -
		// boundary
		String allFoodItem = C206_CaseStudy.retrieveAllFI(foodItemList);
		String testOutput = "";
		assertEquals("Check that ViewAllFI", testOutput, allFoodItem);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		// - normal
		C206_CaseStudy.addFoodItem(foodItemList, fi1);
		C206_CaseStudy.addFoodItem(foodItemList, fi2);
		assertEquals("Test that FoodItem arraylist size is 2", 2, foodItemList.size());

		// test if the expected output string same as the list of food item retrieved
		// from the SourceCentre
		allFoodItem = C206_CaseStudy.retrieveAllFI(foodItemList);
		testOutput = String.format("%-20s %10d\n", "Nasi Ayam", 3);
		testOutput += String.format("%-20s %10d\n", "Steak", 15);

		assertEquals("Test that ViewAllFI", testOutput, allFoodItem);

	}
	@Test
	public void deleteFoodItemTest() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid FoodItem arraylist to retrieve item", foodItemList);

		// test if the list of food item retrieved from the SourceCentre is empty -
		// boundary
		String allFoodItem = C206_CaseStudy.retrieveAllFI(foodItemList);
	}
	
	@Test
	public void addOrderTest() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid arraylist to add to", OrderList);

		//Order Selected is available
		C206_CaseStudy.addItem(OrderList, O4);
		ArrayList<OrderItem> AvailableList = new ArrayList<OrderItem>();
		AvailableList.add(O1);
		AvailableList.add(O2);
		AvailableList.add(O4);

		assertFalse("Test that Order item that is unavailable cannot be added to the Orderlist", AvailableList.contains(O3));
		
		assertTrue("Test that Order item that is available can be added to the Orderlist", AvailableList.contains(O4));
		//Add 2 items. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		assertEquals("Check that Camcorder arraylist size is 1", 1, OrderList.size());
		//Test that OrderList.size() maximum is 100
		assertNotEquals(100,OrderList);
		C206_CaseStudy.addItem(OrderList,O2);
		//Test that item added is the same as the item in the list
		assertSame(O4,OrderList.get(OrderList.size()-1));
	}
	
	@Test
	public void ViewAllTest() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid Camcorder arraylist to retrieve item", OrderList);
		
		//test if the list of orders retrieved from the SourceCentre is empty - boundary
		String allOrders= C206_CaseStudy.retrieveAllOrder(OrderList);
		String testOutput = "";
		assertEquals("Check that ViewAllOrderlist", testOutput, allOrders);
		
		
		//test if the expected output string same as the list of Orders retrieved from the SourceCentre	
		OrderList.add(O4);
		allOrders= C206_CaseStudy.retrieveAllOrder(OrderList);
		testOutput = String.format("%-10s %-30s %-10d %-10d\n",4, "Mac and Cheese",1 , 3);
	
		assertEquals("Test that ViewAllCamcorderlist", testOutput, allOrders);
	}
	
	@Test
	public void DeleteTest() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid arraylist to retrieve item", OrderList);
		
		//test if the list of orders retrieved from the SourceCentre is empty - boundary
		String allOrders= C206_CaseStudy.retrieveAllOrder(OrderList);
		String testOutput = "";
		assertEquals("Check that ViewAllOrderlist", testOutput, allOrders);
		
		
		//test if the expected output string same as the list of Orders retrieved from the SourceCentre	
		OrderList.remove(O4);
		OrderList.add(O1);
		allOrders= C206_CaseStudy.retrieveAllOrder(OrderList);
		testOutput = String.format("%-10d %-30s %-10d %-10d\n",1, "Chicken Rice",2 , 3);
	
		assertEquals("Test that ViewAllCamcorderlist", testOutput, allOrders);
	}

	
	
	@After
	public void tearDown() throws Exception {
		po1 = null;
		po2 = null;
		po3 = null;
		poList = null;
		
		fi1 = null;
		fi2 = null;
		foodItemList = null;
	}
}
