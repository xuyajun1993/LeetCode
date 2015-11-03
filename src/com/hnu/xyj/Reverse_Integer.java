package com.hnu.xyj;

import org.omg.PortableInterceptor.INACTIVE;

import java.text.DecimalFormat;

/**
 * Created by hzxuyajun on 2015/10/30.
 * Reverse digits of an integer.

 Example1: x = 123, return 321
 Example2: x = -123, return -321 
 */
public class Reverse_Integer
{
	DecimalFormat decimalFormat = new DecimalFormat("###0.00");//格式化设置,避免double使用科学计数法表示

	public int reverse(int x)
	{
		Double result = 0.0;
		while (x != 0)
		{
			result = result * 10.00 + x % 10;
			x = x / 10;
		}
		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
			return 0;
		else
		{
			String s = String.valueOf(decimalFormat.format(result));
			System.out.println(s);
			return Integer.parseInt(s.substring(0, s.indexOf(".")));
		}
	}

	public static void main(String[] args)
	{
		Reverse_Integer demo = new Reverse_Integer();
		System.out.println(demo.reverse(-21474412));
	}
}
