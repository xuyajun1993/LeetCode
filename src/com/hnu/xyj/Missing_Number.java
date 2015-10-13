package com.hnu.xyj;

/**
 * Created by hzxuyajun on 2015/10/13.
 * Òì»ò
 */
public class Missing_Number
{
	public int missingNumber(int[] nums)
	{
		int result = 0;

		for (int i : nums)
			result ^= i;

		for (int i = 0; i <= nums.length; i++)
		{
			result ^= i;
		}

		return result;
	}
}
