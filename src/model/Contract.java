package model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
/**
 * Contract JavaBean class containing id, description, value, salesRepresentative and customer
 * @author Yuhang Zhao
 *
 */
@Entity
public class Contract {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CONTRACT_ID", unique = true, nullable = false, updatable = false) 
	private int id;
	
	private String description;
	private double value;
	
	@ManyToOne
	@JoinColumn(name = "SALESREPRESENTATIVE_ID")
	private SalesRepresentative salesRepresenative;
	
	@ManyToOne
	@JoinColumn(name = "CUSTOMER_ID")
	private Customer customer;
	
	/**
	 * Default constructor, required by JPA
	 */
	public Contract() {
		super();
	}
	/**
	 * Convenience constructor
	 */
	public Contract(int id, String description, double value, SalesRepresentative salesRepresenative, Customer customer) {
		super();
		this.id = id;
		this.description = description;
		this.value = value;
		this.salesRepresenative = salesRepresenative;
		this.customer = customer;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	
	@ManyToOne
	public SalesRepresentative getSalesRepresentative() {
		return this.salesRepresenative;
	}
	public void setSalesRepresentative(SalesRepresentative salesRepresentative) {
		this.salesRepresenative = salesRepresentative;
	}
	
	@ManyToOne
	public Customer getCustomer() {
		return this.customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
