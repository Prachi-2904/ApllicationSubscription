package tester;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.code.Customer;
import static utils.RegistrationValidationRule.*;
import static utils.UserUtils.*;
import customException.*;
import custom_ordering.*;

public class TestCustomer {

	public static void main(String[] args) {
	
		try(Scanner sc=new Scanner(System.in)){
			List<Customer>custlist=populateCustomer();
			boolean exit=false;
			while(!exit) {
			System.out.println("Options 1.Sign up\n"+"2.Sign In\n"+"3. Change Password\n"+"4.Un Subcribe Customer\n"
			+"5.Display\n"+"6.Sort by email \n"+"7. Sort by Date of Birth\n"+"8. Sort by date and Last Name\n"+"9. To Pay registration/Subscription Amount\n"
					+"10. Display all customer who have not paid from 3 months\n"
			+"11. Remove customer who's subscription amut is pending from 6 months\n"+"12. Exit\n");
			System.out.println("Please Enter your choice");
			int ch =sc.nextInt();
			try {
				switch(ch) {
				case 1:
					System.out.println("Enter firstName, lastName, email, password, registrationamt,  dob," + 
							"plan ");
					Customer cust = validateallinputs(sc.next(),sc.next(),sc.next(),sc.next(),sc.nextDouble(),sc.next(),sc.next(),sc.next(),custlist);							
					custlist.add(cust);
					System.out.println("Signed Up Successfully...!!!");
					break;
				case 2:
					System.out.println("Enter email , password");
					findbyLoginDetails(sc.next(),sc.next(),custlist);
					System.out.println("You have successfully Logged In");
					break;
				case 3:
					System.out.println("Enter email , password,new password");
					changePassword(sc.next(), sc.next(),sc.next(),custlist);
					break; 
				case 4:
					System.out.println("Enter email address");
					boolean remove = custlist.remove(new Customer (sc.next()));
					if (remove) {
						System.out.println("Unsubscribed Successfully..");
					}else
						System.out.println("Inalid email ...Please try again..");
					break;
				case 5:
					System.out.println("Show all customer details");
					for(Customer c:custlist) {
						System.out.println(c);
					}
					break;
				case 6:
					Collections.sort(custlist);
					System.out.println("List Sorted on basis of email");
					break;
				case 7:
					Collections.sort(custlist,new DobComparator());
					System.out.println("List sorted according to date of birth");
					break;
				case 8:
				  Collections.sort(custlist, new Comparator<Customer>(){
					  public int compare(Customer o1,Customer o2) {
						int result = o1.getDob().compareTo(o2.getDob());
						if(result==0)
						 return o1.getLastName().compareTo(o2.getLastName());
						return result;
					  }
				  });
				  System.out.println("List sorted according to DOB and Lastname");
				  break;
				case 9:
					break;
				case 10:
					for(Customer c :custlist){
					Long months = periodDuration(c);
					//Long month=Period.between(itrcust.next().getLoginDate(),date).toTotalMonths();
					if(months >=3){
					System.out.println(c.getFirstName()+c.getLastName());	
					System.out.println("Month ="+months);
					}
					}
					break;
				case 11:
					Iterator<Customer>itrcust=custlist.iterator();	
					while(itrcust.hasNext()) {
						
						Long month=periodDuration(itrcust.next());
						//Long month=Period.between(itrcust.next().getLoginDate(),date).toTotalMonths();
						if(month >=6) {
						System.out.println("Month="+month);
						itrcust.remove();
					}
						System.out.println("Successfully removed;");
					}
					break;
				  case 12:
					 exit=true;
					  break;
					  
				  }
				  }catch(Exception e) { 
					  sc.nextLine();
						e.printStackTrace();
					  
				
				}
				
	}}
	}
	}
