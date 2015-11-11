package com.hnu.xyj;

/**
 * Created by hzxuyajun on 2015/11/9.
 *  Find the contiguous subarray within an array (containing at least one number) which has the largest product.

 For example, given the array [2,3,-2,4],
 the contiguous subarray [2,3] has the largest product = 6.
 */
public class Maximum_Product_Subarray
{
	public int maxProduct(int[] nums)
	{
		int maxValue = nums[0];
		int minValue = nums[0];
		int global = nums[0];

		for (int i = 1; i < nums.length; i++)
		{
			int cur = nums[i];
			int temp = maxValue;
			maxValue = Math.max(Math.max(maxValue * cur, cur), minValue * cur);
			minValue = Math.min(Math.min(temp * cur, cur), minValue * cur);
			global = Math.max(maxValue, global);
		}
		return global;
	}
}
