import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private PurchaseOrder po1;
	private PurchaseOrder po2;
	private PurchaseOrder po3;
	private PurchaseOrder po4;
	private PurchaseOrder po5;
	private ArrayList<PurchaseOrder> poList;
	
	@Before
	public void setUp() throws Exception {
		po1 = new PurchaseOrder (1,5,"Fruit Stall");
		po2 = new PurchaseOrder (2,8,"Drink Stall");
		po3 = new PurchaseOrder (3,4,"Mix Veg Stall");
		po4 = new PurchaseOrder (4,7,"Chicken Rice Stall");
		po5 = new PurchaseOrder (5,2,"Western Stall");
		poList= new ArrayList<PurchaseOrder>();
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
	
	
	@After
	public void tearDown() throws Exception {
		po1 = null;
		po2 = null;
		po3 = null;
		po4 = null;
		po5 = null;
		poList = null;
	}
}
