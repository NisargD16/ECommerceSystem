import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;


// Simulation of a Simple Eboo-Commerce System (like Amazon)
// Name: Nisarg Doshi
//Student #: 501109700
public class ECommerceUserInterface
{
	public static void main(String[] args)
	{
		// Create the system
		ECommerceSystem amazon = new ECommerceSystem();

		Scanner scanner = new Scanner(System.in);
		System.out.print(">");
		
		// Process keyboard actions
		while (scanner.hasNextLine())
		{
		try
		{
			String action = scanner.nextLine();
			
			if (action == null || action.equals("")) 
			{
				System.out.print("\n>");
				continue;
			}
			else if (action.equalsIgnoreCase("Q") || action.equalsIgnoreCase("QUIT"))
				return;

			else if (action.equalsIgnoreCase("PRODS"))	// List all products for sale
			{
				amazon.printAllProducts(); 
			}
			else if (action.equalsIgnoreCase("BOOKS"))	// List all books for sale
			{
				amazon.printAllBooks(); 
			}
			else if (action.equalsIgnoreCase("CUSTS")) 	// List all registered customers
			{
				amazon.printCustomers();	
			}
			else if (action.equalsIgnoreCase("ORDERS")) // List all current product orders
			{
				amazon.printAllOrders();	
			}
			else if (action.equalsIgnoreCase("SHIPPED"))	// List all orders that have been shipped
			{
				amazon.printAllShippedOrders();	
			}
			else if (action.equalsIgnoreCase("NEWCUST"))	// Create a new registered customer
			{
				String name = "";
				String address = "";
				
				System.out.print("Name: ");
				if (scanner.hasNextLine())
					name = scanner.nextLine();
				
				System.out.print("\nAddress: ");
				if (scanner.hasNextLine())
					address = scanner.nextLine();
				
				amazon.createCustomer(name, address);
			}
			else if (action.equalsIgnoreCase("SHIP"))	// ship an order to a customer
			{
				String orderNumber = "";
        
				System.out.print("Order Number: ");
				// Get order number from scanner
				orderNumber = scanner.nextLine();
				ProductOrder s = amazon.shipOrder(orderNumber);
				s.print(); 
					// Ship order to customer (see ECommerceSystem for the correct method to use
			}
			else if (action.equalsIgnoreCase("CUSTORDERS")) // List all the current orders and shipped orders for this customer id
			{
				String customerId = "";

				System.out.print("Customer Id: ");
				// Get customer Id from scanner
				customerId = scanner.nextLine();
				amazon.printOrderHistory(customerId);
	
				// Print all current orders and all shipped orders for this customer
			}
			else if (action.equalsIgnoreCase("ORDER")) // order a product for a certain customer
			{
				String productId = "";
				String customerId = "";

				System.out.print("Product Id: ");
			  // Get product Id from scanner
			  productId = scanner.nextLine();
				
				System.out.print("\nCustomer Id: ");
			  // Get customer Id from scanner
			  customerId = scanner.nextLine();
				
				// Order the product. Check for valid orderNumber string return and for error message set in ECommerceSystem
				String ord = amazon.orderProduct(productId, customerId, ""); 
				System.out.println(ord); 
        
				// Print Order Number string returned from method in ECommerceSystem
				
			}
			else if (action.equalsIgnoreCase("ORDERBOOK")) // order a book for a customer, provide a format (Paperback, Hardcover or EBook)
			{
				String productId = "";
				String customerId = "";
				String options = "";

				System.out.print("Product Id: ");
				// get product id
				productId = scanner.nextLine();

				System.out.print("\nCustomer Id: ");
				// get customer id
				customerId = scanner.nextLine();
				
				System.out.print("\nFormat [Paperback Hardcover EBook]: ");
				// get book forma and store in options string
				options = scanner.nextLine();
				String ordBook = amazon.orderProduct(productId, customerId, options);
				
				System.out.println(ordBook); 
				// Order product. Check for error mesage set in ECommerceSystem
				// Print order number string if order number is not null
			}
			else if (action.equalsIgnoreCase("ORDERSHOES")) // order shoes for a customer, provide size and color 
			{
				String productId = "";
				String customerId = "";
				String options = "";
				
				System.out.print("Product Id: ");
				// get product id
				productId = scanner.nextLine();

				System.out.print("\nCustomer Id: ");
				// get customer id
				customerId = scanner.nextLine();
				
				System.out.print("\nSize: \"6\" \"7\" \"8\" \"9\" \"10\": ");
				// get shoe size and store in options	
				options = scanner.nextLine();
				
				System.out.print("\nColor: \"Black\" \"Brown\": ");
				// get shoe color and append to options
				String optColour = "";    // created a String variable to store the colour
				optColour = scanner.nextLine(); // the variable will store the user input
				options = optColour + options;  								// the options variable holding the user input will have the colour appended with the size to make it the same format as the
				String ordShoes = amazon.orderProduct(productId, customerId, options); // String productOptions in Shoes.java
				System.out.println(ordShoes); 
				//order shoes
			}
			
			
			else if (action.equalsIgnoreCase("CANCEL")) // Cancel an existing order
			{
				String orderNumber = "";

				System.out.print("Order Number: ");
				// get order number from scanner
				orderNumber = scanner.nextLine();

				amazon.cancelOrder(orderNumber);
				
				// cancel order. Check for error
			}
			else if (action.equalsIgnoreCase("PRINTBYPRICE")) // print products sorted by price
			{
				amazon.printByPrice();
			}
			else if (action.equalsIgnoreCase("PRINTBYNAME")) // print products sorted by name (alphabetic)
			{
				amazon.printByName();
			}
			else if (action.equalsIgnoreCase("SORTCUSTS")) // sort products by name (alphabetic)
			{
				amazon.sortCustomersByName();
			}
			else if (action.equalsIgnoreCase("ADDTOCART"))
			{
				String productId = "";
				String customerId = "";
				String productOptions = "";

				System.out.print("Product Id: ");
				// get product id
				productId = scanner.nextLine();

				System.out.print("\nCustomer Id: ");
				// get customer id
				customerId = scanner.nextLine();

				System.out.print("\nProduct Option (if you are ordering a product that is not a shoe or book, enter nothing): ");
				productOptions = scanner.nextLine();
				
				String item = amazon.addCart(productId, customerId, productOptions);
				System.out.println(item); 
				
			}
			else if (action.equalsIgnoreCase("REMCARTITEM"))
			{
				String customerId = "";
				String productId = "";

				System.out.print("Product Id: ");
				// get product id
				productId = scanner.nextLine();

				System.out.print("\nCustomer Id: ");
				// get customer id
				customerId = scanner.nextLine();
				String item = amazon.removeFromCart(productId, customerId);
				System.out.println(item); 
			}
			else if (action.equalsIgnoreCase("PRINTCART"))
			{
				String customerId;

				System.out.print("Customer Id: ");
				// get customer id
				customerId = scanner.nextLine();
				String item = amazon.printCart(customerId);
				System.out.println(item); 
			}
			else if (action.equalsIgnoreCase("ORDERITEMS"))
			{
				String customerId;
				System.out.print("Customer Id: ");
				// get customer id
				customerId = scanner.nextLine();
				String item = amazon.orderCartItems(customerId);
				System.out.println(item); 
			}
			else if (action.equalsIgnoreCase("STATS"))
			{
				amazon.sortOrderCount();
			}
			System.out.print("\n>");
		}
		catch (UnknownCustomerException e)  // all these catch blocks catch each of the exceptions that were made in the classes at the bottom of ecomm system
		{
			System.out.println(e);
		}
		catch (UnknownProductException e)
		{
			System.out.println(e);
		}
		catch (InvalidProdOptionException e)
		{
			System.out.println(e);
		}
		catch (InvalidCustomerAddressException e)
		{
			System.out.println(e);
		}
		catch (InvalidCustomerNameException e)
		{
			System.out.println(e);
		}
		catch (ProdOutOfStockException e)
		{
			System.out.println(e);
		}
		catch (InvalidOrderNumberException e)
		{
			System.out.println(e);
		}
		catch (CartItemDoesNotExistException e)
		{
			System.out.println(e);
		}
		}
	}
}
