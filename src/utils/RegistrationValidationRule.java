package utils;

import customException.SubscriptionPlanException;

import java.time.LocalDate;
import java.util.List;

import com.code.*;

public class RegistrationValidationRule {
//add a method parse and validate service plan;
	private static ServicePlan parseandvalidate(String plan) throws IllegalAccessException{
		return ServicePlan.valueOf(plan.toUpperCase());
}
	public static void ValidatePlanAmount(ServicePlan plan , double regcharges) throws SubscriptionPlanException {
		if(plan.getCharges() != regcharges) {
			throw new SubscriptionPlanException("Invalid registration charges");
		}
		
	}
	public static void checkForDup(String email,List<Customer>cust) throws SubscriptionPlanException {
		Customer cst=new Customer(email);
		if(cust.contains(cst)) {
			throw new SubscriptionPlanException("Duplicate Email address");
	}}
	public static LocalDate parseDate(String date) {
		LocalDate dt =LocalDate.parse(date);
		return dt;
	}
	//check all validation rules
	public static Customer validateallinputs(String firstName, String lastName, String email, String password, double registrationamt, String dob,
		String plan,List<Customer>cst) throws IllegalAccessException,SubscriptionPlanException{
	
	ServicePlan	sub =parseandvalidate(plan);
	ValidatePlanAmount(sub,registrationamt);
	checkForDup(email,cst);
	LocalDate dtt = parseDate(dob);
		return new Customer(firstName,lastName,email,password,registrationamt,dtt,sub);
	}
}