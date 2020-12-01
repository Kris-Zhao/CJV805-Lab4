package service;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Customer;
public class CustomerManagerTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("The test for CustomerManager is starting.");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("The test for CustomerManager is done.");
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	/**
	 * Test for createCustomer method. I create a new customer1 and also get an another customer2 returned by createCustomer method. Then compare if they are equal
	 */
	@Test
	public void createCustomerTest() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "cjv805" );
		EntityManager entitymanager = emfactory.createEntityManager( );
		
		Customer customer1 = new Customer(1000, "1000@1000", "Steven", 20);
		
		Customer customer2 = CustomerManager.createCustomer(entitymanager, 1000, "1000@1000", "Steven", 20);
		
		entitymanager.close( );
	    emfactory.close( );	
	    
		assertEquals(customer1, customer2);
	}
	
	/**
	 * Test for readCustomer method. I create a new customer1 and also get an another customer2 returned by createCustomer method.
	 * Then I use readCustomer method to read this newly created customer and compare them.
	 */
	@Test
	public void readCustomerTest() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "cjv805" );
		EntityManager entitymanager = emfactory.createEntityManager( );
		
		Customer customer3 = CustomerManager.createCustomer(entitymanager, 1001, "1001@1001", "Kevin", 22);
		
		Customer customer1 = new Customer(1001, "1001@1001", "Kevin", 22);
		Customer customer2 = CustomerManager.readCustomer(entitymanager, 1001);
		
		entitymanager.close( );
	    emfactory.close( );	
		
		assertEquals(customer1, customer2);
	}
	
	/**
	 * Test for updateCustomer method. Create a new customer3 and update it with some updated info
	 */
	@Test
	public void updateCustomerTest() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "cjv805" );
		EntityManager entitymanager = emfactory.createEntityManager( );
		
		Customer customer3 = CustomerManager.createCustomer(entitymanager, 1002, "asdasd@asdasd", "Tom",19);
		
		Customer customer1 = new Customer(1002, "1002@1002", "James", 23);
		Customer customer2 = CustomerManager.updateCustomer(entitymanager, 1002, "1002@1002", "James", 23);
		
		entitymanager.close( );
	    emfactory.close( );	
		
		assertEquals(customer1, customer2);
	}
	
	/**
	 * Test for deleteCustomer method. Create a customer3 via createCustomer method and then delete it via deleteCustomer method.
	 */
	@Test
	public void deleteCustomerTest() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "cjv805" );
		EntityManager entitymanager = emfactory.createEntityManager( );
		
		Customer customer3 = CustomerManager.createCustomer(entitymanager, 1003, "1003@1003", "Simit",20);
		CustomerManager.deleteCustomer(entitymanager, 1003);
		
		entitymanager.close( );
	    emfactory.close( );	
	}

}
