import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

class PriorityQueueTest{

	@Test
	void WorthComparatorTest() {
		
		Comparator<Customer> netWorthComparator = new Customer.WorthComparator();
		PriorityQueue<Customer> queue = new PriorityQueue<>(netWorthComparator);
		
		Customer NWcustomer1 = new Customer(50000, 5, 8);
		Customer NWcustomer2 = new Customer(10000, 3, 9);
		Customer NWcustomer3 = new Customer(30000, 7, 7);
		Customer NWcustomer4 = new Customer(30000, 7, 7);
		
		
		assertTrue(netWorthComparator.compare(NWcustomer2, NWcustomer3)<0);
		assertTrue(netWorthComparator.compare(NWcustomer1, NWcustomer3)>0);
		assertTrue(netWorthComparator.compare(NWcustomer1, NWcustomer2)>0);
		assertTrue(netWorthComparator.compare(NWcustomer3, NWcustomer4)==0);
		
		queue.push(NWcustomer1);
		queue.push(NWcustomer2);
		queue.push(NWcustomer3);
		
		/* person with biggest networth pop first*/
		assertEquals(NWcustomer1,queue.pop());
		assertEquals(NWcustomer3,queue.pop());
		assertEquals(NWcustomer2,queue.pop());
		
		
	}
	
	@Test
	void LoyaltyComparatorTest() {
		
		Comparator<Customer> loyaltyComparator = new Customer.LoyaltyComparator();
		PriorityQueue<Customer> queue = new PriorityQueue<>(loyaltyComparator);
		
		Customer Lcustomer1 = new Customer(50000, 5, 8);
		Customer Lcustomer2 = new Customer(10000, 3, 9);
		Customer Lcustomer3 = new Customer(30000, 7, 7);
		Customer Lcustomer4 = new Customer(30000, 7, 7);
		
		assertTrue(loyaltyComparator.compare(Lcustomer2, Lcustomer3)<0);
		assertTrue(loyaltyComparator.compare(Lcustomer1, Lcustomer3)<0);
		assertTrue(loyaltyComparator.compare(Lcustomer1, Lcustomer2)>0);
		assertTrue(loyaltyComparator.compare(Lcustomer3, Lcustomer4)==0);
		
		queue.push(Lcustomer1);
		queue.push(Lcustomer2);
		queue.push(Lcustomer3);
		
		/* person with most amount of years pop first*/
		assertEquals(Lcustomer3,queue.pop());
		assertEquals(Lcustomer1,queue.pop());
		assertEquals(Lcustomer2,queue.pop());
		
		
	}
	
	@Test
	void NicestComparatorTest() {
		
		Comparator<Customer> nicestComparator = new Customer.WorthPoliteComparator();
		PriorityQueue<Customer> queue = new PriorityQueue<>(nicestComparator);
		
		
		Customer Kcustomer1 = new Customer(50000, 5, 8);
		Customer Kcustomer2 = new Customer(10000, 3, 9);
		
		Customer Kcustomer3 = new Customer(30000, 7, 7);
		Customer Kcustomer4 = new Customer(30000, 7, 7);
		
		Customer Kcustomer5 = new Customer(50000, 7, 9);
		Customer Kcustomer6 = new Customer(50000, 7, 10);
		
		assertTrue(nicestComparator.compare(Kcustomer2, Kcustomer3)<0);
		assertTrue(nicestComparator.compare(Kcustomer1, Kcustomer3)>0);
		assertTrue(nicestComparator.compare(Kcustomer1, Kcustomer2)>0);
		assertTrue(nicestComparator.compare(Kcustomer3, Kcustomer4)==0);
		assertTrue(nicestComparator.compare(Kcustomer5, Kcustomer6)<0);
		
		
		queue.push(Kcustomer1);
		queue.push(Kcustomer2);
		queue.push(Kcustomer3);
		
		/* person with the most kind first*/
		assertEquals(Kcustomer1,queue.pop());
		assertEquals(Kcustomer3,queue.pop());
		assertEquals(Kcustomer2,queue.pop());
		
		
	}
	
	

}
