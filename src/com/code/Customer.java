package com.code;

import java.time.LocalDate;

public class Customer implements Comparable<Customer> {
private int customerId;
private String firstName,lastName,email,password;
private double registrationamt;
private LocalDate dob;
private ServicePlan plan;
private static int counterId;

static {
	counterId=100;
}

public Customer(String firstName, String lastName, String email, String password, double registrationamt, LocalDate dob,
		ServicePlan plan) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.password = password;
	this.registrationamt = registrationamt;
	this.dob = dob;
	this.plan = plan;
	this.customerId=++counterId;
	
}
public Customer(String email) {
	super();
	this.email=email;
}

@Override
public String toString() {
	return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
			+ email +" ,registrationamt=" + registrationamt + ", dob=" + dob + ", plan="
			+ plan + "]";
}

public boolean equals(Object obj){
	System.out.println("in equals");
	if(obj instanceof Customer) {
//		return this.email.equals(((Customer) obj).email);
		Customer custobj=(Customer)obj;
		return this.email.equals(custobj.email);
	}
	return false;
}

public double getRegistrationamt() {
	return registrationamt;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public LocalDate getDob() {
	return dob;
}
public void setDob(LocalDate dob) {
	this.dob = dob;
}
public ServicePlan getPlan() {
	return plan;
}
public void setPlan(ServicePlan plan) {
	this.plan = plan;
}
@Override
public int compareTo(Customer o) {
	return this.email.compareTo(o.email);
}




}
