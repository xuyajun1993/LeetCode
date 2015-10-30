package com.hnu.xyj;

/**
 * Created by hzxuyajun on 2015/10/27.
 * Given an unsorted integer array, find the first missing positive integer.
 * [3,4,-1,1] return 2.
 */
public class First_Missing_Positive
{
	public int firstMissingPositive(int[] nums)
	{

		int len = nums.length;

		int i = 0;
		for (; i < len;)
		{

			if (nums[i] <= 0 || nums[i] == i + 1 || nums[i] > len || nums[i] == nums[nums[i] - 1])
				i++;
			else
				swap(nums, i, nums[i] - 1);
		}

		int j = 0;
		for (j = 0; j < len; j++)
		{
			if (nums[j] != j + 1)
				break;
		}
		return j + 1;
	}

	private void swap(int[] nums, int i, int i1)
	{
		int temp = nums[i];
		nums[i] = nums[i1];
		nums[i1] = temp;
	}
}
