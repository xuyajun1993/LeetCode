package com.hnu.xyj;

/**
 * Created by xyj on 15/11/17.
 *

 Follow up for "Find Minimum in Rotated Sorted Array":
 What if duplicates are allowed?

 Would this affect the run-time complexity? How and why?

 */
public class Find_Minimum_in_Rotated_Sorted_Array_II
{
	public int findMin(int[] num)
	{
		int min = num[0];
		for (int i = 1; i < num.length; i++)
		{
			if (num[i] < min)
				min = num[i];
		}
		return min;
	}

}
