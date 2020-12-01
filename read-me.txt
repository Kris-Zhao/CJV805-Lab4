Lab4 Assignment Submission Form
==========================================================================
I/we declare that the attached assignment is my/our own work in accordance with Seneca Academic Policy. No
part of this assignment has been copied manually or electronically from any other source (including web sites) or
distributed to other students.

Name(s): Yuhang Zhao             Student ID(s): 150467199
----------------------------------------------------------------------------------------------------------------------- 

In model package, there are three JavaBean classes, Contract , Customer and SalesRepresentativeManager, standing for three tables on MySQL database. Some conditions
are defined and enforced when creating objects of these classes. The following conditions are:
	a) Customer.email (must be in the form xxx@xxx)
	b) Customer.name (must be between 1-40 characters long)
	c) Customer.age (must be between 18-25)
	d) SalesRepresentative.name (must be between 1-40 characters long)
	e) SalesRepresentative.salary (must be a positive amount)
Also the equals methods of Customer and SalesRepresentativeManager classes are overwritten.

----------------------------------------------------------------------------------------------------------------------- 

For CustomerManager class, it provides CRUD (create, read, update, delete) methods for Customer class.
The CustomerManagerTest class is to CRUD methods in CustomerManager class.


For SalesRepresentativeManager, it provides CRUD (create, read, update, delete) methods for SalesRepresentative class.
SalesRepresentativeManagerTest class is to CRUD methods in SalesRepresentativeManager class.

----------------------------------------------------------------------------------------------------------------------- 

I also have a UseJPQL class, which implements two methods. 
The first one queryAllCustomers_NamedQuery method returns all customer objects in the system using a named query specified in Customer class and prints all 
customer names and their email addresses on the console. 
The second one queryContractUsingInnerJoin method returns the customer name, sales representative name, contract description and contract value for each
contract that a given sales representative secures. I also print them on console.

UseJPQLTest class is for testing UseJPQL class.
After finishing the above tests, many records are stored in tables in the database. I can see these records via MySQL workbench, so for this Junit part, I just invoke
these methods and compare if the results are same as fields in my database.
This is the printed contents resulting from queryAllCustomers_NamedQuery method: (The contents are specially for my database)
*****************************Lists all customer names and their email addresses*****************************
Customer name: Yuhang, customer email: 2000@2000

Customer name: Zhao, customer email: 2001@2001

Customer name: Kevin, customer email: 2002@2002

Customer name: Durant, customer email: 2003@2003

Customer name: Kruis, customer email: 4002@4002

Customer name: Durant, customer email: 5002@5002


This is the printed contents resulting from queryContractUsingInnerJoin method: (The contents are specially for my database)
*********************List the customer name, sales representative name, contract description and contract value for each contract**********************
Customer name: Yuhang,  sales representative name: Marry, contract description: test, contract value: 20000.0

Customer name: Durant,  sales representative name: Hortons, contract description: JPQL, contract value: 80000.0

The results tell me my methods are totally correct.