package custom_ordering;

import java.util.Comparator;

import com.code.Customer;

public class DobComparator implements Comparator<Customer> {

	public int compare(Customer o1, Customer o2) {
		return o1.getDob().compareTo(o2.getDob());
		}
}
