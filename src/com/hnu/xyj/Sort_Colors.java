package com.hnu.xyj;

/**
 * Created by hzxuyajun on 2015/10/15.
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue. 
 */
public class Sort_Colors
{
	public void sortColors(int[] nums)
	{
		if (nums == null || nums.length == 0)
			return;
		int left = 0;
		int right = nums.length - 1;
		int cur = left;

		while (cur <= right)
		{
			if (nums[cur] == 0)
			{
				swap(nums, left++, cur);
				cur = (cur <= left) ? left : cur;
			}
			else if (nums[cur] == 2)
			{
				swap(nums, right--, cur);
			}
			else
			{
				cur++;
			}
		}
	}

	private void swap(int[] nums, int lo, int hi)
	{
		int temp = nums[lo];
		nums[lo] = nums[hi];
		nums[hi] = temp;
	}
}
