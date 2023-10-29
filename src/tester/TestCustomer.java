package tester;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.code.Customer;
import static utils.RegistrationValidationRule.*;
import static utils.UserUtils.*;
import customException.*;
public class TestCustomer {

	public static void main(String[] args) {
	
		try(Scanner sc=new Scanner(System.in)){
			List<Customer>custlist=populateCustomer();
			boolean exit=false;
			while(!exit) {
			System.out.println("Options 1.Sign up\n"+"2.Sign In\n"+"3. Change Password\n"+"4.Un Subcribe Customer\n"
			+"5.Display"+"6. Exit");
			System.out.println("Please Enter your choice");
			int ch =sc.nextInt();
			try {
				switch(ch) {
				case 1:
					System.out.println("Enter firstName, lastName, email, password, registrationamt,  dob," + 
							"plan ");
					Customer cust = validateallinputs(sc.next(),sc.next(),sc.next(),sc.next(),sc.nextDouble(),sc.next(),sc.next(),custlist);							
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
					System.out.println("");
					break;
				case 4:
					System.out.println("Enter email address");
					boolean remove = custlist.remove(new Customer (sc.next()));
					if (remove) {
						System.out.println("Unsubscribed Successfully..");
					}else
						System.out.println("Inalid Input ...Please try again..");
					break;
				case 5:
					System.out.println("Show all customer details");
					for(Customer c:custlist) {
						System.out.println(c);
					}
					break;
				case 6:
					exit=true;
					break;
				}
				
			}catch(Exception e) {
				e.printStackTrace();
	}}
	}
	}
}
