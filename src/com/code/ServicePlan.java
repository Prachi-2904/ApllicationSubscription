package com.code;

public enum ServicePlan {
SILVER(1000),GOLD(2000),DIAMOND(5000),PALTINUM(10000);

private double charges;
	private ServicePlan(double charges) {
		//super(name.ordinal)
		this.charges=charges;
	}
	public double getCharges() {
		return this.charges;
	}
	public void setCharges(double charges) {
		this.charges=charges;
	}
	public String toString() {
		return " Plan:"+name().toUpperCase()+" Charges:"+charges;
	}
}
