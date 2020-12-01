package model;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER")
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")

/**
 * Customer JavaBean class
 * @author Yuhang Zhao
 *
 */
public class Customer {
	
	private static Pattern pattern = Pattern.compile("^(.+)@(.+)$");
	
	@Id
	// Mark that this field is the primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	// The value of the primary key will be automatically generated.
	@Column(name = "CUSTOMER_ID", unique = true, nullable = false, updatable = false) 
	private int id;
	
	private String email;
	private String name;
	private int age;
	
	
	@ManyToOne
	@JoinColumn(name="SALESREPRESENTATIVE_ID")
	private SalesRepresentative s;
	
	@OneToMany(mappedBy="customer")
	private List<Contract> contracts_customer = new LinkedList<Contract>();
	
	/**
	 * Default constructor, required by JPA
	 */
	public Customer() {
		super();
	}
	
	/**
	 * Convenience constructor
	 */
	public Customer(int id, String email, String name, int age) {
		
		super();
		this.id = id;
		Matcher matcher = pattern.matcher(email);
		if (!matcher.matches()) throw new IllegalArgumentException("The form of email for this customer doesn't conform to xxx@xxx.");
		else this.email = email;
		if (name.length() < 1 || name.length() > 40) throw new IllegalArgumentException("The length of name is not in [1,40]");
		else this.name = name;
		if (age < 18 || age > 25 ) throw new IllegalArgumentException("The age of customer is not in [18,25]");
		else this.age = age;
		

	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		Matcher matcher = pattern.matcher(email);
		if (!matcher.matches()) throw new IllegalArgumentException("The form of email for this customer doesn't conform to xxx@xxx.");
		else this.email = email;
			
		
		
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		if (name.length() < 1 || name.length() > 40) throw new IllegalArgumentException("The length of name is not in [1,40]");
		else this.name = name;
		
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if (age < 18 || age > 25 ) throw new IllegalArgumentException("The age of customer is not in [18,25]");
		else this.age = age;
	}
	
	
	@ManyToOne
	public SalesRepresentative getSalesRepresentative() {
		return this.s;
	}
	public void setSalesRepresentative(SalesRepresentative s) {
		this.s = s;
	}
	
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", email=" + email + ", name=" + name + ", age=" + age
				+ "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + age;
		
		return result;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (age != other.age) 
			return false;
			
		return true;
	}
}
