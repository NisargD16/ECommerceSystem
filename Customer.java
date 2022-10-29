/*
 *  class Customer defines a registered customer. It keeps track of the customer's name and address. 
 *  A unique id is generated when when a new customer is created. 
 *  
 *  Implement the Comparable interface and compare two customers based on name
 */
// Name: Nisarg Doshi
//Student #: 501109700
public class Customer implements Comparable<Customer>
{
	private String id;  
	private String name;
	private String shippingAddress;
	public Cart custCart;
	
	public Customer(String id)
	{
		this.id = id;
		this.name = "";
		this.shippingAddress = "";
		this.custCart = new Cart();
	}
	
	public Customer(String id, String name, String address)
	{
		this.id = id;
		this.name = name;
		this.shippingAddress = address;
		this.custCart = new Cart();
	}
	
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getShippingAddress()
	{
		return shippingAddress;
	}
	
	public void setShippingAddress(String shippingAddress)
	{
		this.shippingAddress = shippingAddress;
	}
	
	public void print()
	{
		System.out.printf("\nName: %-20s ID: %3s Address: %-35s", name, id, shippingAddress);
	}
	
	// This equals method can be used to check if the customer object that we are dealing with is the same as another customer object by checking its ID
	public boolean equals(Object other) //parameter is an object instance
	{
		Customer otherC = (Customer) other; //here we make the object a Customer object
		return this.id.equals(otherC.id);   //here we check if the customer object we are dealing with has the same ID as the "other" object's ID
	}
	public int compareTo(Customer o) {  //this compareTo method is associated with the Comparable interface and it helps compare two customers' names
		return (this.getName().compareTo(o.getName()));
	}
	
}
