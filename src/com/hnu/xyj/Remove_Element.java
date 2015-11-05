package com.hnu.xyj;

/**
 * Created by hzxuyajun on 2015/11/5.
 * Given an array and a value, remove all instances of that value in place and return the new length.

 The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class Remove_Element
{
	public int removeElement(int[] nums, int val)
	{
		int i = 0;
		int j = 0;

		while (j < nums.length)
		{
			if (nums[j] != val)
			{
				nums[i] = nums[j];
				i++;
			}

			j++;
		}

		return i;
	}
}
