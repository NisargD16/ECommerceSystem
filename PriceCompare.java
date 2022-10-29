// Name: Nisarg Doshi
//Student #: 501109700
import java.util.Comparator; // this compare method implements comparator with type Product

public class PriceCompare implements Comparator<Product> //it compares two products using the CompareTo method
{
    public int compare(Product p1, Product p2) 
    {
        return new Double(p1.getPrice()).compareTo(p2.getPrice());
    }
}
