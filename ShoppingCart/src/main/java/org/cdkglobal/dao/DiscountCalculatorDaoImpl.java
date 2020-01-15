package org.cdkglobal.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cdkglobal.entity.CustomerType;
import org.cdkglobal.entity.DiscountSlab;

public class DiscountCalculatorDaoImpl implements DiscountCalculatorDao{
	
	private static Map<CustomerType, List<DiscountSlab>> discountSlabs = new HashMap<>();
	
	/*
	 * Constructor
	 */
	public DiscountCalculatorDaoImpl() {
		populateDiscountSlabs();
	}
	private void populateDiscountSlabs() {
		List<DiscountSlab> regularDiscountSlabList = new ArrayList<>();
		List<DiscountSlab> premiumDiscountSlabList = new ArrayList<>();
		regularDiscountSlabList.add(new DiscountSlab(0, 5000, 0, CustomerType.REGULAR));
		regularDiscountSlabList.add(new DiscountSlab(10000, Double.MAX_VALUE, 0.20, CustomerType.REGULAR));
		regularDiscountSlabList.add(new DiscountSlab(5000, 10000, 0.10, CustomerType.REGULAR));
		
		premiumDiscountSlabList.add(new DiscountSlab(0, 4000, 0.10, CustomerType.PREMIUM));
		premiumDiscountSlabList.add(new DiscountSlab(8000, 12000, 0.20, CustomerType.REGULAR));
		premiumDiscountSlabList.add(new DiscountSlab(12000, Double.MAX_VALUE, 0.30, CustomerType.REGULAR));
		premiumDiscountSlabList.add(new DiscountSlab(4000, 8000, 0.15, CustomerType.REGULAR));
		
		discountSlabs.put(CustomerType.REGULAR, regularDiscountSlabList);
		discountSlabs.put(CustomerType.PREMIUM, premiumDiscountSlabList);
		
	}

	public List<DiscountSlab> getDiscountSlabs(CustomerType custType) {
		if(discountSlabs.containsKey(custType)){
			return discountSlabs.get(custType);
		}
		return null;
	}

}
