package com.hnu.xyj;

/**
 * Created by hzxuyajun on 2015/10/12.
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 * 二分法，抽屉原理
 */
public class Find_the_Duplicate_Number
{
	public static int findDuplicate(int[] nums)
	{
		int min = 1, max = nums.length - 1;

		while (min <= max)
		{
			int mid = min + (max - min) / 2;

			int cnt = 0;
			for (int i : nums)
			{
				if (i <= mid)
					cnt++;
			}
			if (cnt > mid)
				//如果小于mid的数量大于mid,则在前半段
				max = mid - 1;
			else
				min = mid + 1;
		}

		return min;
	}

	public static void main(String[] args)
	{
		int nums[] =
		{ 2, 1, 4, 3, 2 };
		System.out.println(findDuplicate(nums));
	}
}
