package com.hnu.xyj;

/**
 * Created by hzxuyajun on 2015/11/9.
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 *     A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28
 */
public class Excel_Sheet_Column_Number
{
	public int titleToNumber(String s)
	{
		if (s == null || s.length() == 0)
		{
			throw new IllegalArgumentException("Input is not valid!");
		}

		int result = 0;
		int i = s.length() - 1;
		int t = 0;
		while (i >= 0)
		{
			char curr = s.charAt(i);
			result = result + (int) Math.pow(26, t) * (curr - 'A' + 1);
			t++;
			i--;
		}

		return result;
	}
}
