// Name: Nisarg Doshi
//Student #: 501109700
import java.util.ArrayList;

public class Cart 
{
    ArrayList<CartItem> cart = new ArrayList<CartItem>();  //initialized an ArrayList of cart item objects

    public void addToCart(CartItem i)  //helps addCart method in system add cart item to cart
	{
		cart.add(i);
    }

    public boolean findInCart(CartItem c)  //custom made method to help check if cart item is in cart before removing it
    {
        for (int i = 0; i<cart.size(); i++)
        {
            if (cart.get(i).equals(c))
            {
                return true;
            }
        }
        return false;
    }

    public void removeFromCart(CartItem i)  //helps removeCart method in system remove cart item from cart
    {
        if (findInCart(i) == true)
        {
            cart.remove(i);
        }
    }

    public ArrayList<String> orderCartItems() //helps order the cart items in cart
    {
        ArrayList<String> cartOrders = new ArrayList<>();  //temp array list of type string
        while (cartOrders.size()>0)  // as long as cart is not empty
        {
            cartOrders.add(cart.get(0).getProduct().getId());  //adds the product id of the first cart item in cart to the array list
            cartOrders.add(cart.get(0).getProductOptions());  //adds the productoptions of the first cart item in cart to the array list
            cart.remove(0);  // removes the item from the cart since it is already ordered
        }
        return cartOrders;  //returns array list
    }

    public void print() //print method for cart
    {
        for (CartItem i: cart) //iterates through cart items in cart and prints them out
        {
            i.getProduct().print();
            System.out.print(" Product Option: " + i.getProductOptions());
        }
    }


}
