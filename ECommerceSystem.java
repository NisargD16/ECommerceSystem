import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;


/*
 * Models a simple ECommerce system. Keeps track of products for sale, registered customers, product orders and
 * orders that have been shipped to a customer
 */
// Name: Nisarg Doshi
//Student #: 501109700
public class ECommerceSystem
{
    private Map<String, Product>  products = new TreeMap<String, Product>(); //changed products ArrayList to products TreeMap
    // private ArrayList<Product> products = new ArrayList<Product>();	
    private ArrayList<Customer> customers = new ArrayList<Customer>();	
    
    private ArrayList<ProductOrder> orders   = new ArrayList<ProductOrder>();
    private ArrayList<ProductOrder> shippedOrders   = new ArrayList<ProductOrder>();
    private Map<Integer, String> stats = new HashMap<Integer, String>(); //HashMap of statistics
    // These variables are used to generate order numbers, customer id's, product id's 
    private int orderNumber = 500;
    private int customerId = 900;
    private int productId = 700;
    
    // General variable used to store an error message when something is invalid (e.g. customer id does not exist)  
    String errMsg = null;
    
    // Random number generator
    Random random = new Random();
    
    public ECommerceSystem()
    {
      try
      {
        ArrayList<Product> tempProd = readFile("products.txt");  //calls file i/o method on products.txt file to read it
        for (Product p: tempProd)
        {
          products.put(p.getId(), p);  //adds productId to keys of products treemap and product object as values
          stats.put(0, p.getId());  //makes all the keys of stats hashmap to 0 and makes all the values the productId
        }
      }
      catch (IOException e)  //catches IOException
      {
        System.out.println(e.getMessage());
        System.exit(1);
      }
    	// NOTE: do not modify or add to these objects!! - the TAs will use for testing
    	// If you do the class Shoes bonus, you may add shoe products
    	
    	// Create some products. Notice how generateProductId() method is used
    	// products.add(new Product("Acer Laptop", generateProductId(), 989.0, 99, Product.Category.COMPUTERS));
    	// products.add(new Product("Apex Desk", generateProductId(), 1378.0, 12, Product.Category.FURNITURE));
    	// products.add(new Book("Book", generateProductId(), 45.0, 4, 2, "Ahm Gonna Make You Learn", "T. McInerney"));
    	// products.add(new Product("DadBod Jeans", generateProductId(), 24.0, 50, Product.Category.CLOTHING));
    	// products.add(new Product("Polo High Socks", generateProductId(), 5.0, 199, Product.Category.CLOTHING));
    	// products.add(new Product("Tightie Whities", generateProductId(), 15.0, 99, Product.Category.CLOTHING));
    	// products.add(new Book("Book", generateProductId(), 35.0, 4, 2, "How to Fool Your Prof", "D. Umbast"));
    	// products.add(new Book("Book", generateProductId(), 45.0, 4, 2, "How to Escape from Prison", "A. Fugitive"));
    	// products.add(new Book("Book", generateProductId(), 44.0, 14, 12, "Ahm Gonna Make You Learn More", "T. McInerney"));
    	// products.add(new Product("Rock Hammer", generateProductId(), 10.0, 22, Product.Category.GENERAL));
    	// products.add(new Shoes("Air Force 1's", generateProductId(), 200.0, 100, Product.Category.SHOES)); //new shoe product added
    	// Create some customers. Notice how generateCustomerId() method is used
    	customers.add(new Customer(generateCustomerId(),"Inigo Montoya", "1 SwordMaker Lane, Florin"));
    	customers.add(new Customer(generateCustomerId(),"Prince Humperdinck", "The Castle, Florin"));
    	customers.add(new Customer(generateCustomerId(),"Andy Dufresne", "Shawshank Prison, Maine"));
    	customers.add(new Customer(generateCustomerId(),"Ferris Bueller", "4160 Country Club Drive, Long Beach"));
      
    }
    
    private String generateOrderNumber()
    {
    	return "" + orderNumber++;
    }

    private String generateCustomerId()
    {
    	return "" + customerId++;
    }
    
    private String generateProductId()
    {
    	return "" + productId++;
    }
    
    public String getErrorMessage()
    {
    	return errMsg;
    }
    
    public void printAllProducts()
    {
    	for (Product p : products.values())
    		p.print();
      // for (Product p: products)
      // {
      //   p.print();
      // }
    }
    
    // Print all products that are books. See getCategory() method in class Product
    public void printAllBooks()
    {
      for (Product p : products.values())
      {
        if (p.getCategory() == Product.Category.BOOKS)
        {
          p.print();
        }
      }
      // for (Product p: products)
      // {
      //   if (p.getCategory() == Product.Category.BOOKS)
      //   {
      //     p.print();
      //   }
      // }
    	
    }
    
    // Print all current orders
    public void printAllOrders()
    {
      for (ProductOrder o : orders)
      {
        o.print();
      }
    	
    }
    // Print all shipped orders
    public void printAllShippedOrders()
    {
      for (ProductOrder s : shippedOrders)
      {
        s.print();
      }
    	
    }
    
    // Print all customers
    public void printCustomers()
    {
      for (Customer c : customers)
      {
        c.print();
      }
    	
    }
    /*
     * Given a customer id, print all the current orders and shipped orders for them (if any)
     */
    public void printOrderHistory(String customerId) throws UnknownCustomerException
    {
      // Make sure customer exists - check using customerId
    	// If customer does not exist, set errMsg String and return false
    	// see video for an appropriate error message string
    	// ... code here
      int indexNum = customers.indexOf(new Customer(customerId));  //Declares an int and sets it to the index number where there is a Customer object in the customers ArrayList that has the given customerId
      if (indexNum == -1)                                          //index -1 means the index doesn't exist ---> no customer with the given customerId exists
      {
        throw new UnknownCustomerException("Customer " + customerId + " Not Found"); // this line and every similar line below replaced the errMsg with an exception   
      }
    	
    	// Print current orders of this customer 
    	System.out.println("Current Orders of Customer " + customerId);
    	// enter code here
      for (int i = 0; i < orders.size(); i++)  // Iterate through the orders ArrayList
      {
        if (orders.get(i).getCustomer().getId().equals(customerId)) //If it iterates to an element in the orders ArrayList whose associated customer's ID matches the customerId given 
        {                                                          // then it would print this order with the print method in ProductOrder
          orders.get(i).print();
        }
      }

    	// Print shipped orders of this customer 
    	System.out.println("\nShipped Orders of Customer " + customerId);  
    	//enter code here
      for (int i = 0; i < shippedOrders.size(); i++)  // Iterate through the shippedOrders ArrayList
      {
        if (shippedOrders.get(i).getCustomer().getId().equals(customerId))  //If it iterates to an element in the shippedOrders ArrayList whose associated customer's ID matches the customerId given 
        {                                                                   // then it would print this shipped order with the print method in ProductOrder
          shippedOrders.get(i).print();
        }
      }
    }
    
    public String orderProduct(String productId, String customerId, String productOptions) throws UnknownProductException, UnknownCustomerException, InvalidProdOptionException, ProdOutOfStockException
    {
    	// First check to see if customer object with customerId exists in array list customers
    	// if it does not, set errMsg and return null (see video for appropriate error message string)
    	// else get the Customer object
      Customer currCust = null;    //Created a Customer object called currCust initially setting to null
      for (int i = 0; i< customers.size(); i++)
      {
        if (customers.get(i).getId().equals(customerId))  //similar process as above methods
        {
          currCust = customers.get(i);      // when it finds the right customer in the customers ArrayList, it sets the currCust variable to that
          break;
        }
      }
      if (currCust == null)         // if it didnt find the matching customer by the first if statement then that means it currCust is still null in
      {                             // which case we have to set error message and return null
        throw new UnknownCustomerException("Customer " + customerId + " Not Found"); 
      }
    	
    	// Check to see if product object with productId exists in array list of products
    	// if it does not, set errMsg and return null (see video for appropriate error message string)
    	// else get the Product object 
    	Product currProd = null;       // same approach as above but this time checking if product exists in the products ArrayList
      for (int i = 0; i< products.size(); i++) 
      {
        if (products.get(i).getId().equals(productId))
        {
          currProd = products.get(i);
          break;
        }
      }
      if (currProd == null)
      {
        throw new UnknownProductException("Product " + productId + " Not Found"); 
      }
    	// Check if the options are valid for this product (e.g. Paperback or Hardcover or EBook for Book product)
    	// See class Product and class Book for the method vaidOptions()
    	// If options are not valid, set errMsg string and return null;
      if (currProd.validOptions(productOptions) == false) 
      {
        throw new InvalidProdOptionException("Product " + currProd.getName() + " ProductId " + productId + " Invalid Options: " + productOptions);
      }
    	// Check if the product has stock available (i.e. not 0)
    	// See class Product and class Book for the method getStockCount()
    	// If no stock available, set errMsg string and return null
    	if (currProd.getStockCount(productOptions) == 0)
      {
        throw new ProdOutOfStockException("No " + productOptions + " Stock Available for Product Id " + productId);
      }
      // Create a ProductOrder, (make use of generateOrderNumber() method above)
    	// reduce stock count of product by 1 (see class Product and class Book)
    	// Add to orders list and return order number string
      String orderNumber = generateOrderNumber();  //made a String variable to store the order number that generateOrderNumber() function creates
      ProductOrder p = new ProductOrder(orderNumber, currProd, currCust, productOptions);  // created a new ProductOrder object that uses its  
      currProd.reduceStockCount(productOptions);                                           // appropriate parameters with the order number being the orderNumber variable
      orders.add(p);    // adds the ProductOrder object to orders ArrayList
      return "Order #" + orderNumber;
      


    	    	
    }
    
    /*
     * Create a new Customer object and add it to the list of customers
     */
    
    public boolean createCustomer(String name, String address) throws InvalidCustomerNameException, InvalidCustomerAddressException
    {
    	// Check name parameter to make sure it is not null or ""
    	// If it is not a valid name, set errMsg (see video) and return false
    	// Repeat this check for address parameter
      if ((name == null) || (name.equals("")))   
      {
        throw new InvalidCustomerNameException("Invalid Customer Name");
      }
      if ((address == null) || (address.equals("")))
      {
        throw new InvalidCustomerAddressException("Invalid Customer Address");
      }
      Customer customer = new Customer(generateCustomerId(), name, address);
      customers.add(customer);  // creates a Customer object with the given parameters and adds it to customers ArrayList

      return true;

    	
    	// Create a Customer object and add to array list
    }
    
    public ProductOrder shipOrder(String orderNumber) throws InvalidOrderNumberException
    {
      // Check if order number exists first. If it doesn't, set errMsg to a message (see video) 
    	// and return false
    	// Retrieve the order from the orders array list, remove it, then add it to the shippedOrders array list
    	// return a reference to the order
      int indexNum = orders.indexOf(new ProductOrder(orderNumber, null, null, "")); // stores the index of the ProductOrder object in ArrayList objects
      if (indexNum == -1)                                                           // which has the same order number as the one given in the parameter
      {                                                                             // the Product product and Customer customer objects are null as we are not provided with them and this is also
        throw new InvalidOrderNumberException("Order " + orderNumber + " Not Found");                            // why productOptions is an empty string
      }
      ProductOrder order = orders.get(indexNum);  //if order number exists it creates a new ProductOrder object of the object that had that order number in the ArrayList
      orders.remove(indexNum);               // we remove that specific order from the orders ArrayList 
      shippedOrders.add(order);             // we add that specific order to the shippedOrders ArrayList
    	return order;
    }
    
    /*
     * Cancel a specific order based on order number
     */
    public boolean cancelOrder(String orderNumber) throws InvalidOrderNumberException
    {
      // Check if order number exists first. If it doesn't, set errMsg to a message (see video) 
    	// and return false
      int indexNum = orders.indexOf(new ProductOrder(orderNumber, null, null, "")); // similar explanation as above
      if (indexNum == -1)
      {
        throw new InvalidOrderNumberException("Order " + orderNumber + " Not Found");
      }
      orders.remove(indexNum);   // essentially removes the correct order from the orders ArrayList
      return true;
    }
    
    // Print products by increasing price
    public void printByPrice()
    {
      ArrayList<Product> prod = new ArrayList<>(); //temporary arraylist to add products from map of products
      Set<String> prodKey = products.keySet();  // create a set to store the set of keys in the products map
      Iterator<String> keyIter = prodKey.iterator(); // creates iterator for the set of keys
      while (keyIter.hasNext())  //as long as there is more keys to iteratre through, you add the prouct objects associated with the key productId to the arraylist prod
      {
        prod.add(products.get(keyIter.next()));
      }
      Collections.sort(prod, new PriceCompare()); //use collections.sort and comparator interface (made in PriceCompare.java)
      for (Product sortedProd : prod)  // print all the products
      {
        sortedProd.print();
      }
    }
    
    
    // print products alphabetically by product name
    public void printByName()    // same comments as printByPrice apply here
    {
      ArrayList<Product> prod = new ArrayList<>();
      Set<String> prodKey = products.keySet();
      Iterator<String> keyIter = prodKey.iterator();
      while (keyIter.hasNext())
      {
        prod.add(products.get(keyIter.next()));
      }
      Collections.sort(prod);
      for (Product sortedProd : prod)
      {
        sortedProd.print();
      }
    }
    
    // Sort products alphabetically by product name
    public void sortCustomersByName()
    {
      Comparator<Customer> nameSortingCust = new Comparator<Customer>() 
      {
        public int compare(Customer customer1, Customer customer2)
        {
          return customer1.getName().compareTo(customer2.getName());
        }
      };
      Collections.sort(customers, nameSortingCust);
    }
    
    public void sortOrderCount()
    {
      ArrayList<Product> ord = new ArrayList<>(); //temporary arraylist to add products from map of products
      Set<Integer> ordKey = stats.keySet();  // create a set to store the set of keys in the products map
      Iterator<Integer> keyIter = ordKey.iterator(); // creates iterator for the set of keys
      while (keyIter.hasNext())  //as long as there is more keys to iteratre through, you add the prouct objects associated with the key productId to the arraylist prod
      {
        ord.add(products.get(keyIter.next()));
      }
      Collections.sort(ord, orderCountCompare()); //use collections.sort and comparator interface (made in PriceCompare.java)
      for (Product sortedOrdCount : ord) 
      {
        int countOrder = 0;
        if (orders.contains(sortedOrdCount))
        {
          countOrder ++;
          System.out.println(sortedOrdCount.getName() + sortedOrdCount.getId() + countOrder);
        }
        
      }
        
    }
  
  

    public String addCart(String productId, String customerId, String productOptions) throws UnknownProductException, UnknownCustomerException, InvalidProdOptionException
    {
      Customer currCust = null;    //Created a Customer object called currCust initially setting to null
      for (int i = 0; i< customers.size(); i++)
      {
        if (customers.get(i).getId().equals(customerId))  //similar process as above methods
        {
          currCust = customers.get(i);      // when it finds the right customer in the customers ArrayList, it sets the currCust variable to that
          break;
        }
      }
      if (currCust == null)         // if it didnt find the matching customer by the first if statement then that means it currCust is still null in
      {                             // which case we have to set error message and return null
        throw new UnknownCustomerException("Customer " + customerId + " Not Found");
      }
    	
    	// Check to see if product object with productId exists in array list of products
    
    	Product currProd = null;       // same approach as above but this time checking if product exists in the products ArrayList
      for (String prodId : products.keySet())  //for loop altered to support products map instead of array list
      {
        if (prodId.equals(productId))
        {
          currProd = products.get(prodId);
          break;
        }
      }
      if (currProd == null)
      {
        throw new UnknownProductException("Product " + productId + " Not Found"); 
      }
    	// Check if the options are valid for this product 
      if (currProd.validOptions(productOptions) == false) 
      {
        throw new InvalidProdOptionException("Product " + currProd.getName() + " ProductId " + productId + " Invalid Options: " + productOptions);
      }
      CartItem c = new CartItem(currProd, productOptions);  //creates a cart item object with the product object currProd and productOptions string as paramter
      currCust.custCart.addToCart(c);  // gets the cart of the customer we are working with and uses the method in cart.java to add the cart item to the cart
      return "\n" + currProd.getName() + " with ID " + currProd.getId() + " has been added to the cart of Customer #: " + currCust.getId();

    }
    public String removeFromCart(String productId, String customerId) throws UnknownProductException, UnknownCustomerException, CartItemDoesNotExistException
    {
      Customer currCust = null;    //Created a Customer object called currCust initially setting to null
      for (int i = 0; i< customers.size(); i++)
      {
        if (customers.get(i).getId().equals(customerId))  //similar process as above methods
        {
          currCust = customers.get(i);      // when it finds the right customer in the customers ArrayList, it sets the currCust variable to that
          break;
        }
      }
      if (currCust == null)         // if it didnt find the matching customer by the first if statement then that means it currCust is still null in
      {                             // which case we have to set error message and return null
        throw new UnknownCustomerException("Customer " + customerId + " Not Found");
      }
    	
    	// Check to see if product object with productId exists in array list of products
    
    	Product currProd = null;       // same approach as above but this time checking if product exists in the products ArrayList
      for (String prodId : products.keySet()) //for loop altered to support products map instead of array list
      {
        if (prodId.equals(productId))
        {
          currProd = products.get(prodId);
          break;
        }
      }
      if (currProd == null)
      {
        throw new UnknownProductException("Product " + productId + " Not Found");
      }
      CartItem c = new CartItem(currProd, "");  //creates temporary cart item object with currProd product and "" as parameters
      if (currCust.custCart.findInCart(c) == true)  // if product is in cart
      {
        currCust.custCart.removeFromCart(c);  //remove product from customer's cart
        return "\n" + currProd.getName() + " with ID " + currProd.getId() + " has been removed from the cart of Customer #: " + currCust.getId();
      }
      throw new CartItemDoesNotExistException("This item does not exist in the cart"); //otherwise throw an exception that it doesnt exist
    }
    public String printCart(String customerId) throws UnknownCustomerException
    {
      Customer currCust = null;    //Created a Customer object called currCust initially setting to null
      for (int i = 0; i< customers.size(); i++)
      {
        if (customers.get(i).getId().equals(customerId))  //similar process as above methods
        {
          currCust = customers.get(i);      // when it finds the right customer in the customers ArrayList, it sets the currCust variable to that
          break;
        }
      }
      if (currCust == null)         // if it didnt find the matching customer by the first if statement then that means it currCust is still null in
      {                             // which case we have to set error message and return null
        throw new UnknownCustomerException("Customer " + customerId + " Not Found");
      }
      ArrayList<CartItem> c = currCust.custCart.cart; //creates an array list with cart item objects which is equal to the cart items in the customer's cart
      if (c.size() == 0)
      {
        return "\nThis customer has no items in their cart.";
      }
      for (int i = 0; i < c.size(); i++) //iterate through array list and print out all the products in the cart
      {
        System.out.println("Product " + (i+1) + ": " + c.get(i).getProduct().getName() + " Product ID: " + c.get(i).getProduct().getId() + " Price: $" + c.get(i).getProduct().getPrice()); 
      }
      return "--------------------------";
    }
    public String orderCartItems(String customerId) throws UnknownCustomerException
    {
      Customer currCust = null;    //Created a Customer object called currCust initially setting to null
      for (int i = 0; i< customers.size(); i++)
      {
        if (customers.get(i).getId().equals(customerId))  //similar process as above methods
        {
          currCust = customers.get(i);      // when it finds the right customer in the customers ArrayList, it sets the currCust variable to that
          break;
        }
      }
      if (currCust == null)         // if it didnt find the matching customer by the first if statement then that means it currCust is still null in
      {                             // which case we have to set error message and return null
        throw new UnknownCustomerException("Customer " + customerId + " Not Found");
      }
      ArrayList<CartItem> c = currCust.custCart.cart;
      if (c.size() == 0)
      {
        return "There are no products in the cart.";
      }
      for (int i = 0; i <c.size(); i++)
      {
        Product p = c.get(i).getProduct(); // create a temporary product object and make that equal to the cart items you are iterating through in the cart array list
        String orderNumber = generateOrderNumber();  //made a String variable to store the order number that generateOrderNumber() function creates
        ProductOrder cartOrder = new ProductOrder(orderNumber, p, currCust, c.get(i).getProductOptions());  // created a new ProductOrder object that uses its  
        p.reduceStockCount(c.get(i).getProductOptions());                                           // appropriate parameters with the order number being the orderNumber variable
        orders.add(cartOrder);    // adds the ProductOrder object to orders ArrayList
      }
      return "The orders in this customer's cart have been placed!";
    }
    private ArrayList<Product> readFile(String filename) throws IOException 
{
  //private method to help with file i/o
  ArrayList<Product> prods = new ArrayList<Product>();
  String prodCat = "";  // String variable to store product category 
  String prodName = "";  // String variable to store product name 
  String prodPrice = "";  // String variable to store product price 
  String bookTitle = "";  // String variable to store title of book 
  String bookAuthor = "";  // String variable to store author of book
  String bookYear = "";    // String variable to store publication year of book
  String regularStock = "";  // String variable to store stock count of a non-book product
  String additionalInfo = ""; // String variable to store additional info -> for non-book product it would be blank line

  File file = new File(filename); // opens filename given in parameter
  Scanner s = new Scanner(file);  // creates scanner to read lines of file
  while (s.hasNextLine())   
  {
    prodCat = s.nextLine();  //reads category and stores it in the right variable
    prodName = s.nextLine();  //reads name and stores it in the right variable
    prodPrice = s.nextLine();  //reads price and stores it in the right variable
    if (prodCat.equals("BOOKS"))
    {
      int paperbackStock = s.nextInt();  //initializes int variable for paperback stock count for book and reads the first int on the line and stores it to this variable 
      String hardcoverStock = s.nextLine(); // initializes a string variable to store the next number on the line 
      hardcoverStock = hardcoverStock.trim(); // strips off the leading white space
      additionalInfo = s.nextLine();   // reads additional info line and stores it in variable
      Scanner in = new Scanner(additionalInfo);  // reads the additional info line
      in.useDelimiter("[^a-zA-Z0-9\u002E\u002C\u0021\s]"); // splits the line into different strings where ever there is a colon
      while (in.hasNext())
      {
        bookTitle = in.next();  // stores first string in the title variable
        bookAuthor = in.next();  // stores second string in the author variable
        bookYear = in.next();   // stores third string in the publication year variable
      }
      // adds this book product to temporary arraylist with the variables as the paramters
      prods.add(new Book(prodName, generateProductId(), Double.parseDouble(prodPrice), paperbackStock, Integer.parseInt(hardcoverStock), bookTitle, bookAuthor, bookYear));
    }
    // checks whether if the category is a non-book product
    else if (prodCat.equals("FURNITURE") || prodCat.equals("GENERAL") || prodCat.equals("COMPUTERS") || prodCat.equals("CLOTHING"))
    {
      regularStock = s.nextLine(); //reads stock count line and stores it in the right variable
      additionalInfo = s.nextLine();  //reads additional variable line (blank line) and stores it in the right variable
      Product.Category pCat = Product.Category.valueOf(prodCat); //converts string category variable to enum Product.Category
      // adds this product to temporary arraylist with the variables as the paramters
      prods.add(new Product(prodName, generateProductId(), Double.parseDouble(prodPrice), Integer.parseInt(regularStock), pCat));
    }
  }
  s.close(); //closes scanner
  return prods; //returns arraylist
}
}
class UnknownCustomerException extends RuntimeException
{
  UnknownCustomerException(String errorMsg)
  {
    super(errorMsg);
  }
}
class UnknownProductException extends RuntimeException
{
  UnknownProductException(String errorMsg)
  {
    super(errorMsg);
  }
}
class InvalidProdOptionException extends RuntimeException
{
  InvalidProdOptionException(String errorMsg)
  {
    super(errorMsg);
  }
}
class ProdOutOfStockException extends RuntimeException
{
  ProdOutOfStockException(String errorMsg)
  {
    super(errorMsg);
  }
}
class InvalidCustomerNameException extends RuntimeException
{
  InvalidCustomerNameException(String errorMsg)
  {
    super(errorMsg);
  }
}
class InvalidCustomerAddressException extends RuntimeException
{
  InvalidCustomerAddressException(String errorMsg)
  {
    super(errorMsg);
  }
}
class InvalidOrderNumberException extends RuntimeException
{
  InvalidOrderNumberException(String errorMsg)
  {
    super(errorMsg);
  }
}
class CartItemDoesNotExistException extends RuntimeException
{
  CartItemDoesNotExistException(String errorMsg)
  {
    super(errorMsg);
  }
}




