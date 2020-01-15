package org.cdkglobal.main;

import org.cdkglobal.entity.CustomerType;
import org.cdkglobal.service.DiscountCalculatorServiceImpl;

public class DiscountCalculator {

	public static void main(String[] args) {

		DiscountCalculatorServiceImpl service = new DiscountCalculatorServiceImpl();
		double purchaseAmount = 4000;
		double billingAmount = 0;
		billingAmount = service.calculateBillingAmount(CustomerType.PREMIUM, purchaseAmount);
		System.out.println("Purchase Amount: " + purchaseAmount + " - Billing Amount : " + billingAmount);

	}

}
