package model;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * SalesRepresentative JavaBean class
 * @author Yuhang Zhao
 *
 */
@Entity
public class SalesRepresentative {
	@Id
	// Mark that this field is the primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	// The value of the primary key will be automatically generated.
	@Column(name = "SALESREPRESENTATIVE_ID", unique = true, nullable = false, updatable = false) 
	private int id;
	
	private String name;
	private double salary;
	
	@OneToMany(mappedBy="s")
	private Set<Customer> customerSet = new HashSet<Customer>();
	
	@OneToMany(mappedBy="salesRepresenative")
	private List<Contract> contracts_salesRepresentative = new LinkedList<Contract>();
	
	/**
	 * Default constructor, required by JPA
	 */
	public SalesRepresentative() {
		super();
	}
	
	/**
	 * Convenience constructor
	 */
	public SalesRepresentative(int id, String name, double salary, Set<Customer> customerSet) {
		super();
		this.id = id;
		if (name.length() < 1 || name.length() > 40) throw new IllegalArgumentException("The length of name is not in [1,40]");
		else this.name = name;
		if (salary < 0) throw new IllegalArgumentException("The salary of salesRepresentativeManager is not a positive amount");
		else this.salary = salary;
		
		this.customerSet = customerSet;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if (name.length() < 1 || name.length() > 40) throw new IllegalArgumentException("The length of name is not in [1,40]");
		else this.name = name;
	}
	
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		if (salary < 0) throw new IllegalArgumentException("The salary of salesRepresentativeManager is not a positive amount");
		else this.salary = salary;
	}
	
	@OneToMany(mappedBy="s")
	public Set<Customer> getCustomerSet() {
		return customerSet;
	}
	public void setCustomerSet(Set<Customer> customerSet) {
		this.customerSet = customerSet;
	}
	
	@Override
	public String toString() {
		return "SalesRepresentative [id=" + id + ", name=" + name + ", salary=" + salary + ", customerSet=" + customerSet
				+ "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SalesRepresentative other = (SalesRepresentative) obj;
		if (salary != other.getSalary()) 
			return false;
		if (id != other.getId())
			return false;
		if (name == null) {
			if (other.getName() != null)
				return false;
		} else if (!name.equals(other.getName()))
			return false;
		
		if(other.getCustomerSet() == null)
			return false;
		else if(!customerSet.equals(other.customerSet))
			return false;
			
		return true;
	}
	
}
