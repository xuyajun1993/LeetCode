package com.hnu.xyj;

import java.math.BigDecimal;

/**
 * Created by xyj on 15/11/17.
 * Given two numbers represented as strings, return multiplication of the numbers as a string.

 Note: The numbers can be arbitrarily large and are non-negative.
 */
public class Multiply_Strings
{
	public String multiply(String num1, String num2)
	{
		BigDecimal decimal1 = new BigDecimal(num1);
		BigDecimal decimal2 = new BigDecimal(num2);

		return decimal1.multiply(decimal2).toString();
	}

}
