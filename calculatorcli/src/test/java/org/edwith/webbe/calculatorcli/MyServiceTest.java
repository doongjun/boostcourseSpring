package org.edwith.webbe.calculatorcli;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MyServiceTest {
	@InjectMocks
	MyService myService;
	
	@Mock
	CalculatorService calculatorService;
	
	@Test
	public void execute() throws Exception{
		int value1 = 5;
		int value2 = 10;
		given(calculatorService.plus(5, 10)).willReturn(15);
		
		int result = myService.execute(value1, value2);
		
		verify(calculatorService).plus(anyInt(), anyInt());
		Assert.assertEquals(30, result);
	}
}
