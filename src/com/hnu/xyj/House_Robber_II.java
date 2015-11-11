package com.hnu.xyj;

/**
 * Created by hzxuyajun on 2015/11/9.
 * After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street. 
 */
public class House_Robber_II
{
	public int rob(int[] nums)
	{
		if (nums == null || nums.length == 0)
			return 0;

		int n = nums.length;

		if (n == 1)
		{
			return nums[0];
		}
		if (n == 2)
		{
			return Math.max(nums[1], nums[0]);
		}

		//include 1st element, and not last element
		int[] dp = new int[n];
		dp[0] = 0;
		dp[1] = nums[0];

		for (int i = 2; i < n; i++)
		{
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
		}

		//not include frist element, and include last element
		int[] dr = new int[n];
		dr[0] = 0;
		dr[1] = nums[1];

		for (int i = 2; i < n; i++)
		{
			dr[i] = Math.max(dr[i - 1], dr[i - 2] + nums[i]);
		}

		return Math.max(dp[n - 1], dr[n - 1]);
	}
}
