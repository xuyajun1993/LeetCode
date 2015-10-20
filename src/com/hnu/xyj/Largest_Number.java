package com.hnu.xyj;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by hzxuyajun on 2015/10/14.
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * ¿¼ÂÇ¡¾0,0¡¿¡¾121,12¡¿
 */
public class Largest_Number
{
	public String largestNumber(int[] nums)
	{

		String[] strArr = new String[nums.length];

		boolean isZero = false;
		for (int i = 0; i < nums.length; i++)
		{
			if (nums[i] != 0)
				isZero = true;
			strArr[i] = String.valueOf(nums[i]);
		}

		if (!isZero)
			return "0";

		Arrays.sort(strArr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2)
			{
				int len = o1.length() < o2.length() ? o1.length() : o2.length();
				for (int i = 0; i < len; i++)
				{
					if ((int) o1.charAt(i) > (int) o2.charAt(i))
					{
						return -1;
					}
					else if ((int) o1.charAt(i) < (int) o2.charAt(i))
					{
						return 1;
					}
				}
				if (o1.length() > o2.length())
					return compare(o1.substring(o2.length(), o1.length()), o2);
				else if (o1.length() < o2.length())
					return compare(o1, o2.substring(o1.length(), o2.length()));

				return 0;
			}
		});

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < strArr.length; i++)
		{
			sb.append(strArr[i]);
		}
		return sb.toString();
	}

	public static void main(String[] args)
	{
		Largest_Number largest_number = new Largest_Number();
		System.out.println(largest_number.largestNumber(new int[]
		{ 128, 12 }));
	}
}
