package service;
import model.Customer;

import java.util.Iterator;
import java.util.List;
import javax.persistence.*;


public class UseJPQL {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public void getEntityManager() {
		// Create the EntityManager
		emf = Persistence.createEntityManagerFactory("cjv805");
		em = emf.createEntityManager();
	}

	public void closeEntityManager() {
		// Close the EntityManager
		em.close();
		emf.close();
	}
	
	/**
	 * Query all customers using name query and printing customer names and email addresses
	 */
	public List<Customer> queryAllCustomers_NamedQuery() {
		getEntityManager();
		List<Customer> customers = null;

		try {
			// get the named query
			TypedQuery<Customer> query = em.createNamedQuery("Customer.findAll", Customer.class);

			customers = query.getResultList();
			
		} catch (Exception ex) {
		} finally {
			closeEntityManager();
		}
		System.out.println("\n\n*****************************Lists all customer names and their email addresses*****************************");
		Iterator<Customer> i = customers.iterator();
		while(i.hasNext()) {
			Customer c = i.next();
			System.out.println(
					"Customer name: " + c.getName() + ", customer email: " + c.getEmail()+"\n");
		}
		
		return customers;
	}
	
	@SuppressWarnings("unchecked") 
	public List<Object[]> queryContractUsingInnerJoin() {
		getEntityManager();
		List<Object[]> results = null;
		
		try {
			// Define query String
			final String jpqlQuery = "SELECT c.name, con.description, con.value, sal.name FROM Customer AS c"
					+ " JOIN c.contracts_customer AS con JOIN con.salesRepresenative AS sal";
			// Define the query
			Query query = em.createQuery(jpqlQuery);

			// Query and get result
			results = query.getResultList();
		} catch (Exception ex) {
		} finally {
			closeEntityManager();
		}
		
		System.out.println("\n\n*********************List the customer name, sales representative name, contract description and contract value for each contract**********************");
		Iterator<Object[]> i = results.iterator();
		
		while(i.hasNext()) {
			Object[] o = i.next();
			System.out.println(
					"Customer name: " + o[0] + ",  sales representative name: " + o[3] + ", contract description: " + o[1] + ", contract value: " + o[2]+"\n");
		}

		return results;
	}
	
}
