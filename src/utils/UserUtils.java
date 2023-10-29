package utils;

import java.time.LocalDate;
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
		cust.add(new Customer("Prachi","Agrawal","p@gmai.com","pracs",2000,LocalDate.parse("2023-03-05"),ServicePlan.GOLD));
		cust.add(new Customer("Prachi","Agrawal","pa@gmai.com","prac1",1000,LocalDate.parse("2020-08-10"),ServicePlan.SILVER));
		cust.add(new Customer("Prachi","Agrawal","pfa@gmai.com","prac2",5000,LocalDate.parse("2021-11-25"),ServicePlan.DIAMOND));
		cust.add(new Customer("Prachi","Agrawal","pra@gmai.com","prac3",10000,LocalDate.parse("2019-03-15"),ServicePlan.PALTINUM));
		cust.add(new Customer("Prachi","Agrawal","prp@gmai.com","prac4",1000,LocalDate.parse("2023-03-05"),ServicePlan.SILVER));
	
		return cust;
	}
	
	}
	

