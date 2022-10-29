// Name: Nisarg Doshi
//Student #: 501109700
import java.util.Comparator;// this compare method implements comparator with type Integer
public class orderCountCompare implements Comparator<Integer>
{
    public int compare(Integer ordCount1, Integer ordCount2) //it compares two integers using the CompareTo method
    {
        return new Integer(ordCount1).compareTo(ordCount2);
    }
}

