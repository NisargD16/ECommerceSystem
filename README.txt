CPS 209 - Assignment 2

Name: Nisarg Doshi

Student #: 501109700

In my assignment, all the aspects seem to be working.

New Cart and CartItem classes have all the required methods they need for cart functionalities. All the commands required including
ADDTOCART, REMCARTITEM, PRINTCART and ORDERCARTITEMS have all been implemented in ECommerceUserInterface.java and the methods that 
support each command has also been successfully implemented in ECommerceSystem.java.

NOTE: For the functionality of ADDTOCART, the user enters a productId and customerId as expected. However, there will be a third input
asking for a productOptions. For this if the product that you are trying to add in cart is A NON-BOOK PRODUCT, do not type anything for productOptions
and press enter on it blank. However, if it is A BOOK PRODUCT OR SHOE PRODUCT, then you would specify the correct product option (for example, brown8 for shoes
or hardcover for books).

I have succesfully added the seven required exception classes on the bottom of ECommerceSystem.java and have thrown exceptions for every method in the file.
Each method's errMsg has been replaced with an exception and in ECommerceUserInterface.java I implemented the try-catch block successfully to make 
the program run with those exceptions.

NOTE: I have also added an eighth exception class known as CartItemDoesNotExistException. This is thrown in the removeFromCart() method when it first checks if the 
cart item that we want to remove exists. If it does not, then this exception is thrown.

I have successfully made the file i/o step work by creating a method on the bottom of EcommerceSystem as suggested (however its public instead of private)
which reads the file lines from a string filename paramater and stores the information in variables and uses those variables in the parameters of the product objects
when we add them to the temporary array list we initialized in that method. It returns the array list which is the list of products.
On top of EcommerceSystem, I have succesfully created a try-catch block which calls the said method and uses it to read products.txt file.
I have changed the products arraylist that was originally there to a TreeMap so this try block also adds all the product's id's as the key of the TreeMap and the product
object as the values. The catch block catches the IOException.

For question 3f, I was unable to print out a formatted list of each product name, its id and the number of times it was ordered in order from most number of orders to least.
HOWEVER, I have wrote code on the top of EcommerceSystem with all the other initialized array lists to create a HashMap for the stats products. I have also incldued in the try block
in the constructor code that makes all the keys in this map set to 0 and all the values said to the productId.
ALSO, I have attempted to write the code for the method that supports STATS command in EcommerceSystem by using a similar technique as printByPrice() where I 
initialize an array list and create a set which takes all the keys of that array list and create an iterator which iterates through them and while there is a next key, 
it adds the product associated with that key to the temp array list. I used collections.sort with parameters as the array list and a comparator method i made In
another java file orderCountCompare(). I also made a counter to iterate through the array list and increment the counter to count each product and print the appropriate 
string the assignment asks. However my comparator method i made has an error when i use it in the sort method in EcommerceSystem.

*I have not attempted the BONUS step*