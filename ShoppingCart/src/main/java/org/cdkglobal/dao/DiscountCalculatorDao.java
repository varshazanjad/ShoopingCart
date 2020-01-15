package org.cdkglobal.dao;

import java.util.List;

import org.cdkglobal.entity.CustomerType;
import org.cdkglobal.entity.DiscountSlab;

public interface DiscountCalculatorDao {

	public List<DiscountSlab> getDiscountSlabs(CustomerType custType);
	
}
