package org.cdkglobal.service;

import java.util.List;

import org.cdkglobal.dao.DiscountCalculatorDao;
import org.cdkglobal.dao.DiscountCalculatorDaoImpl;
import org.cdkglobal.entity.CustomerType;
import org.cdkglobal.entity.DiscountSlab;

public class DiscountCalculatorServiceImpl {

	private DiscountCalculatorDao discountCalculatorDao = new DiscountCalculatorDaoImpl();
	
	public DiscountCalculatorDao getDiscountCalculatorDao() {
		return discountCalculatorDao;
	}

	public void setDiscountCalculatorDao(DiscountCalculatorDao discountCalculatorDao) {
		this.discountCalculatorDao = discountCalculatorDao;
	}

	/**
	 * calculate total discount amount on given purchase amount
	 * 
	 * @param purchaseAmount
	 * @param discountSlabList
	 * @return
	 */
	private double calculateDiscountAmount(double purchaseAmount, List<DiscountSlab> discountSlabList){
		discountSlabList.sort((s1, s2) -> Double.compare(s1.getSlabEndAmt(), s2.getSlabEndAmt()));
		double totalDiscount = 0;
		double balancePurchaseAmount= 0 ;
		for(DiscountSlab discountSlab : discountSlabList){
			if(purchaseAmount >= discountSlab.getSlabEndAmt()){
				totalDiscount += discountSlab.getDiscountPercent() * (discountSlab.getSlabEndAmt()- discountSlab.getSlabStartAmt());
				
			} else if(purchaseAmount > discountSlab.getSlabStartAmt() && purchaseAmount < discountSlab.getSlabEndAmt()){
				balancePurchaseAmount = purchaseAmount - discountSlab.getSlabStartAmt();
				totalDiscount += discountSlab.getDiscountPercent() * balancePurchaseAmount;
				break;
			}
		}
		return totalDiscount;
		
	}
	
	/**
	 * calculate discounted amount based on customer type
	 * 
	 * @param custType
	 * @param purchaseAmount
	 * @return
	 */
	public double calculateBillingAmount(CustomerType custType, double purchaseAmount){
		
		double discountAmount = 0 ;
		
		List<DiscountSlab> discountSlabList = discountCalculatorDao.getDiscountSlabs(custType);
		
		discountAmount = calculateDiscountAmount(purchaseAmount, discountSlabList);
		
		return (purchaseAmount - discountAmount);
		
	}
}
