package service;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.*;
public class SalesRepresentativeManagerTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("The test for SalesRepresativeManager is starting.");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("The test for SalesRepresativeManager is done.");
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	/**
	 * Test for createSalesRepresentative method. Here I create a salesRepresentative1 and also create a salesRepresentative2 via createSalesRepresentative method.
	 * Then compare if they are equal.
	 */
	@Test
	public void createSalesRepresentativeTest() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "cjv805" );
		EntityManager entitymanager = emfactory.createEntityManager( );
		
		Set<Customer> customerSet = new HashSet<Customer>();
		customerSet.add(new Customer(2000, "2000@2000", "Yuhang", 24));
		customerSet.add(new Customer(2001, "2001@2001", "Zhao", 24));
		
		SalesRepresentative salesRepresentative1 = new SalesRepresentative(3000, "Marry", 50000d, customerSet);
		
		SalesRepresentative salesRepresentative2 = SalesRepresentativeManager.createSalesRepresentative(entitymanager, 3000, "Marry", 50000d, customerSet);
		
		assertEquals(salesRepresentative1, salesRepresentative2);
				
		entitymanager.close( );
	    emfactory.close( );	
	}
	
	/**
	 * Test for readSalesRepresentative method. I create a salesRepresentative1 via createSalesRepresentative method and also retrieve salesRepresentative2 using
	 * readSalesRepresentative method. Then compare if salesRepresentative1 is equal to salesRepresentative2
	 */
	@Test
	public void readSalesRepresentativeTest() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "cjv805" );
		EntityManager entitymanager = emfactory.createEntityManager( );
		
		Set<Customer> customerSet = new HashSet<Customer>();
		customerSet.add(new Customer(2002, "2002@2002", "Kevin", 22));
		customerSet.add(new Customer(2003, "2003@2003", "Durant", 23));
		
		SalesRepresentative salesRepresentative1 = SalesRepresentativeManager.createSalesRepresentative(entitymanager, 3001, "Tommy", 70000d, customerSet);
		
		SalesRepresentative salesRepresentative2 = SalesRepresentativeManager.readSalesRepresentative(entitymanager, 3001);
		
		assertEquals(salesRepresentative1, salesRepresentative2);
		
		entitymanager.close( );
	    emfactory.close( );	

	}
	
	/**
	 * Test for updateSalesRepresentative method. After creating a SalesRepresentative, using updateSalesRepresentative method to update its info
	 */
	@Test
	public void updateSalesRepresentativeTest() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "cjv805" );
		EntityManager entitymanager = emfactory.createEntityManager( );
		
		Set<Customer> customerSet1 = new HashSet<Customer>();
		customerSet1.add(new Customer(2004, "2004@2004", "Tom", 23));
		customerSet1.add(new Customer(2005, "2005@2005", "Kevin", 21));
		
		Set<Customer> customerSet2 = new HashSet<Customer>();
		customerSet2.add(new Customer(4002, "4002@4002", "Kruis", 18));
		customerSet2.add(new Customer(5002, "5002@5002", "Durant", 19));
		
		SalesRepresentative salesRepresentative1 = SalesRepresentativeManager.createSalesRepresentative(entitymanager, 3002, "Tim", 80000d, customerSet1);
		
		SalesRepresentative salesRepresentative2 = SalesRepresentativeManager.updateSalesRepresentative(entitymanager, 3002, "Hortons", 20000d, customerSet2);
		
		assertEquals(salesRepresentative1, salesRepresentative2);
		
		entitymanager.close( );
	    emfactory.close( );	
	}
	
	/**
	 * Test for deleteSalesRepresentative method. After creating a SalesRepresentative, using deleteSalesRepresentative method to delete it 
	 */
	@Test
	public void deleteSalesRepresentativeTest() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "cjv805" );
		EntityManager entitymanager = emfactory.createEntityManager( );
		
		Set<Customer> customerSet = new HashSet<Customer>();
		customerSet.add(new Customer(2006, "2006@2006", "James", 18));
		customerSet.add(new Customer(2007, "2007@2007", "Owen", 19));
		
		SalesRepresentative salesRepresentative1 = SalesRepresentativeManager.createSalesRepresentative(entitymanager, 3003, "Sunny", 10000d, customerSet);
		
		SalesRepresentativeManager.deleteSalesRepresentative(entitymanager, 3003);
		entitymanager.close( );
	    emfactory.close( );
	}
}
