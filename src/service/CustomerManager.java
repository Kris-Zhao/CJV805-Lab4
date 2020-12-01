package service;


import javax.persistence.EntityManager;

import model.Customer;

public class CustomerManager {
	
	
	public static Customer createCustomer(EntityManager entitymanager, int id, String email, String name, int age) {
		
		entitymanager.getTransaction().begin( );
		
		Customer customer = new Customer( ); 
		customer.setId(id);
		customer.setEmail(email);
		customer.setName(name);
		customer.setAge(age);
	    entitymanager.persist(customer);
	    
	    entitymanager.getTransaction( ).commit( );
	   
	    return customer;
	}
	
	public static Customer readCustomer(EntityManager entitymanager, int id) {
		Customer customer = entitymanager.find(Customer.class, id);
		
		System.out.println("customer ID = " + customer.getId());
		System.out.println("customer EMAIL = " + customer.getEmail());
		System.out.println("customer NAME = " + customer.getName());
		System.out.println("customer AGE = " + customer.getAge());
		
		return customer;
	}
	
	public static Customer updateCustomer(EntityManager entitymanager, int id, String email, String name, int age) {
		
		
		entitymanager.getTransaction( ).begin( );
		
		Customer customer = entitymanager.find(Customer.class, id);
		
		//before update
		System.out.println(customer);
		customer.setEmail(email);
		customer.setName(name);
		customer.setAge(age);
	    entitymanager.getTransaction( ).commit( );
	     
	    //after update
	    System.out.println(customer);
		
	    return customer;
	}
	
	public static void deleteCustomer(EntityManager entitymanager, int id) {
		entitymanager.getTransaction( ).begin( );
	      
		Customer customer = entitymanager.find(Customer.class, id);
		System.out.println("The customer "+id+" is deleted");
	    entitymanager.remove(customer);
	    entitymanager.getTransaction( ).commit( );
	}
}
