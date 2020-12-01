package service;

import java.util.Iterator;
import java.util.Set;

import javax.persistence.EntityManager;

import model.Customer;
import model.SalesRepresentative;

public class SalesRepresentativeManager {
	
	public static SalesRepresentative createSalesRepresentative(EntityManager entitymanager, int id, String name, double salary, Set<Customer> customerSet) {
		
		entitymanager.getTransaction().begin( );
		
		SalesRepresentative salesRepresentative = new SalesRepresentative( ); 
		salesRepresentative.setId(id);
		salesRepresentative.setName(name);
		salesRepresentative.setSalary(salary);
		
		Iterator<Customer> i = customerSet.iterator();
		while(i.hasNext()) {
			Customer c = i.next();
			entitymanager.persist(c);
			c.setSalesRepresentative(salesRepresentative);
			//salesRepresentative.getCustomerSet().add(c);
		}
		
		salesRepresentative.setCustomerSet(customerSet);
	    entitymanager.persist(salesRepresentative);
	    
	    entitymanager.getTransaction( ).commit( );
	   
	    
	    return salesRepresentative;
	}
	
	public static SalesRepresentative readSalesRepresentative(EntityManager entitymanager, int id) {
		SalesRepresentative salesRepresentative = entitymanager.find(SalesRepresentative.class, id);
		
		System.out.println("salesRepresentative ID = " + salesRepresentative.getId());
		System.out.println("salesRepresentative NAME = " + salesRepresentative.getName());
		System.out.println("salesRepresentative SALARY = " + salesRepresentative.getSalary());
		System.out.println("The customer set is : ");
		
		Iterator<Customer> i = salesRepresentative.getCustomerSet().iterator();
		while(i.hasNext()) {
			Customer c = i.next();
			System.out.println(c);
		}
		
		return salesRepresentative;
	}
	
	public static SalesRepresentative updateSalesRepresentative(EntityManager entitymanager, int id, String name, double salary, Set<Customer> customerSet) {
		
		entitymanager.getTransaction( ).begin( );
		
		SalesRepresentative salesRepresentative = entitymanager.find(SalesRepresentative.class, id);
		
		salesRepresentative.setName(name);
		salesRepresentative.setSalary(salary);
		
		Set<Customer> oldCustomerSet = salesRepresentative.getCustomerSet();

		Iterator<Customer> i1 = oldCustomerSet.iterator();
		while(i1.hasNext()) {
			Customer c = i1.next();
			entitymanager.remove(c);
		}
		oldCustomerSet.clear();
		
		Iterator<Customer> i2 = customerSet.iterator();
		while(i2.hasNext()) {
			Customer c = i2.next();
			oldCustomerSet.add(c);
			entitymanager.persist(c);
			c.setSalesRepresentative(salesRepresentative);
		}
		
		salesRepresentative.setCustomerSet(customerSet);
	    entitymanager.getTransaction().commit( );
	 		
	    return salesRepresentative;
	}
	
	public static void deleteSalesRepresentative(EntityManager entitymanager, int id) {
		entitymanager.getTransaction( ).begin( );
	      
		SalesRepresentative salesRepresentative = entitymanager.find(SalesRepresentative.class, id);
		Iterator<Customer> i = salesRepresentative.getCustomerSet().iterator();
		while(i.hasNext()) {
			Customer c = i.next();
			entitymanager.remove(c);
		}

	    entitymanager.remove(salesRepresentative);
	    entitymanager.getTransaction( ).commit( );
	}
}
