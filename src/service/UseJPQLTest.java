package service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Customer;

public class UseJPQLTest {
	private UseJPQL use = new UseJPQL();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("The test for UseJPQL is starting.");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("The test for UseJPQL is done.");
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	/**
	 * This test would call the queryAllCustomers_NamedQuery() method and print all customer names and their email addresses in the system.
	 * Then I can compare the results with what I can see in the MySQL workbench, finding it is the same. So this method is correct.
	 */
	@Test
	public void queryAllCustomers_NamedQueryTest() {
		
		List<Customer> customers = use.queryAllCustomers_NamedQuery();
		
	}

	/**
	 * This test would call the queryContractUsingInnerJoin() method and print the customer name, sales representative name, contract description and contract value for each
	 * contract that a given sales representative secures.
	 * Then I can compare the results with what I can see in the MySQL workbench, finding it is the same. So this method is correct.
	 */
	@Test
	public void queryContractUsingInnerJoinTest() {
		
		List<Object[]> objects = use.queryContractUsingInnerJoin();
		
	}
}
