package com.hnu.xyj;

/**
 * Created by hzxuyajun on 2015/11/9.
 * ind the contiguous subarray within an array (containing at least one number) which has the largest sum.

 For example, given the array [?2,1,?3,4,?1,2,1,?5,4],
 the contiguous subarray [4,?1,2,1] has the largest sum = 6. 
 */
public class Maximum_Subarray
{
	public int maxSubArray(int[] nums)
	{
		int max = Integer.MIN_VALUE;
		int total = 0;
		for (int i : nums)
		{
			total += i;

			if (max < total)
				max = total;
			if (total <= 0)
			{
				total = 0;
			}
		}

		return max;
	}
}
