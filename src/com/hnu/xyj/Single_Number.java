package com.hnu.xyj;

/**
 * Created by hzxuyajun on 2015/10/27.
 * Given an array of integers, every element appears twice except for one. Find that single one.
 */
public class Single_Number
{
	public int singleNumber(int[] nums)
	{
		int result = 0;
		for (int i : nums)
		{
			result ^= i;
		}
		return result;
	}
}
