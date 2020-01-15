package org.cdkglobal.serviceTest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.cdkglobal.entity.CustomerType;
import org.cdkglobal.service.DiscountCalculatorServiceImpl;
import org.junit.Before;
import org.junit.Test;


public class DiscountCalculatorServiceTest {

	private DiscountCalculatorServiceImpl calculator = null;
    
	@Before
    public void init(){
        calculator = new DiscountCalculatorServiceImpl();
    }

    @Test
    public void testCalculateBillingAmountForRegularCustoner() {

    	CustomerType custType = CustomerType.REGULAR;
        assertAll(
                () -> assertEquals(0, calculator.calculateBillingAmount(custType, -1)),
                () -> assertEquals(1000, calculator.calculateBillingAmount(custType, 1000)),
                () -> assertEquals(5000, calculator.calculateBillingAmount(custType, 5000)),
                () -> assertEquals(9500, calculator.calculateBillingAmount(custType, 10000)),
                () -> assertEquals(13500, calculator.calculateBillingAmount(custType, 15000)),
                () -> assertEquals(17500, calculator.calculateBillingAmount(custType, 20000))

        );
    }
    
    @Test
    public void testCalculateBillingAmountForPremiumCustoner() {

    	CustomerType custType = CustomerType.PREMIUM;
        assertAll(
                () -> assertEquals(0, calculator.calculateBillingAmount(custType, 0)),
                () -> assertEquals(3600, calculator.calculateBillingAmount(custType, 4000)),
                () -> assertEquals(7000, calculator.calculateBillingAmount(custType, 8000)),
                () -> assertEquals(10200, calculator.calculateBillingAmount(custType, 12000)),
                () -> assertEquals(15800, calculator.calculateBillingAmount(custType, 20000))
        );
    }

}
