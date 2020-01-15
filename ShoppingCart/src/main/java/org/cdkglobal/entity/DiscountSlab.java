package org.cdkglobal.entity;

public class DiscountSlab {

	private double slabStartAmt;
	
	private double slabEndAmt;
	
	private double discountPercent;
	
	private CustomerType customerType;

	public DiscountSlab(double slabStartAmt, double slabEndAmt, double discountPercent, CustomerType customerType) {
		super();
		this.slabStartAmt = slabStartAmt;
		this.slabEndAmt = slabEndAmt;
		this.discountPercent = discountPercent;
		this.customerType = customerType;
	}

	public double getSlabStartAmt() {
		return slabStartAmt;
	}

	public void setSlabStartAmt(double slabStartAmt) {
		this.slabStartAmt = slabStartAmt;
	}

	public double getSlabEndAmt() {
		return slabEndAmt;
	}

	public void setSlabEndAmt(double slabEndAmt) {
		this.slabEndAmt = slabEndAmt;
	}

	public double getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(double discountPercent) {
		this.discountPercent = discountPercent;
	}

	public CustomerType getCustomerType() {
		return customerType;
	}

	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}
	
}
