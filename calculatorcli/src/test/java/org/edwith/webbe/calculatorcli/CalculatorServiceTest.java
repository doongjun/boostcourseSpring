package org.edwith.webbe.calculatorcli;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public class CalculatorServiceTest {
	@Autowired
	CalculatorService calculatorService;
	/*
	@Before
	public void init() {
		this.calculatorService = new CalculatorService(); 
	}
	*/
	
	@Test
	public void plus() throws Exception {
		int value1 = 10;
		int value2 = 5;
		
		int result = calculatorService.plus(value1, value2);
		
		Assert.assertEquals(15, result);
	}
	
	@Test
	public void divide() throws Exception{
		int value1 = 10;
		int value2 = 5;
		
		int result = calculatorService.divide(value1, value2);
		
		Assert.assertEquals(2, result);
	}
	
	@Test
	public void divideExceptionTest() throws Exception{
		int value1 = 10;
		int value2 = 0;
		
		try {
			calculatorService.divide(value1, value2);
		}catch(ArithmeticException ae) {
			Assert.assertTrue(true);
			return;
		}
		Assert.fail();
		//Assert.assertFalse(false);
	}
}
