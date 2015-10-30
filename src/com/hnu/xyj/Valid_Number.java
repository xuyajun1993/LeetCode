package com.hnu.xyj;

/**
 * Created by hzxuyajun on 2015/10/26.
 * Validate if a given string is numeric.
 */
public class Valid_Number
{
	public boolean isNumber(String s)
	{
		if (s.trim().isEmpty())
		{
			return false;
		}
		String regex = "[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?";
		if (s.trim().matches(regex))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
