package utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

import com.code.Customer;
import com.code.ServicePlan;

import customException.SubscriptionPlanException;

public class UserUtils {

	@SuppressWarnings("unlikely-arg-type")
	public static Customer findbyLoginDetails(String email,String passwd,List<Customer>custlist) throws SubscriptionPlanException{
		Customer c =new Customer(email);
		int index = custlist.indexOf(c);
		if(index!=-1) {
			if(passwd.equals(custlist.get(index).getPassword())){
				return custlist.get(index);
		}else 
			throw new SubscriptionPlanException("Invalid password");
		
		}else
			throw new SubscriptionPlanException("Invalid Email");
		}
	
	
	public static void changePassword(String email,String oldPsswd,String newPsswd,List<Customer>custlist)throws SubscriptionPlanException  {
		Customer cust=findbyLoginDetails(email,oldPsswd,custlist);
		cust.setPassword(newPsswd);
		System.out.println("Password changed Successfully");
	}
	
	public static List<Customer> populateCustomer() {
		List<Customer> cust =new ArrayList<>();
		//String firstName, String lastName, String email, String password, double registrationamt, LocalDate dob,
		//ServicePlan plan
		cust.add(new Customer("Prachi","Agrawal","p@gmail.com","pracs",2000,LocalDate.parse("1996-04-29"),LocalDate.parse("2023-04-05"),ServicePlan.GOLD));
		cust.add(new Customer("Suchita","Mahajan","suma@gmail.com","prac1",1000,LocalDate.parse("1999-12-12"),LocalDate.parse("2022-03-15"),ServicePlan.SILVER));
		cust.add(new Customer("Pearl","Desoza","pdz@gmail.com","prac2",5000,LocalDate.parse("2001-11-25"),LocalDate.parse("2022-06-25"),ServicePlan.DIAMOND));
		cust.add(new Customer("Prajyot","Agrawal","pfa@gmail.com","prac3",10000,LocalDate.parse("2000-03-15"),LocalDate.parse("2023-09-05"),ServicePlan.PALTINUM));
		cust.add(new Customer("Pratik","Bhosale","p@gmail.com","prac4",1000,LocalDate.parse("1997-03-05"),LocalDate.parse("2023-11-05"),ServicePlan.SILVER));
	
		return cust;
	}
	public static Long periodDuration(Object o) {
		Long period=null;
		if(o instanceof Customer)
		{
			
		Period duration=Period.between(((Customer) o).getLastPaidDate(),LocalDate.now());
		 period= duration.toTotalMonths();
	}
		return period;
	}}
	

