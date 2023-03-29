package Customer;
import java.util.Comparator;

public class ComparatorById implements Comparable<Customer>{
    @Override
    public int compare(Customer o1, Customer o2) {
        if (o1.getId() > o2.getId()) {
            return 1;
        } else if (o1.getId() == o2.getId()) {
            return 0;
        }
        else {
            return -1;
        }
    }
}
