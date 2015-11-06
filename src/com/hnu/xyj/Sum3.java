package com.hnu.xyj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hzxuyajun on 2015/11/6.
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 */
public class Sum3
{
	public List<List<Integer>> threeSum(int[] nums)
	{

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (nums.length < 3)
			return result;

		// sort array
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++)
		{
			// //avoid duplicate solutions
			if (i == 0 || nums[i] > nums[i - 1])
			{

				int negate = -nums[i];

				int start = i + 1;
				int end = nums.length - 1;

				while (start < end)
				{
					//case 1
					if (nums[start] + nums[end] == negate)
					{
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(nums[i]);
						temp.add(nums[start]);
						temp.add(nums[end]);

						result.add(temp);
						start++;
						end--;
						//avoid duplicate solutions
						while (start < end && nums[end] == nums[end + 1])
							end--;

						while (start < end && nums[start] == nums[start - 1])
							start++;
						//case 2
					}
					else if (nums[start] + nums[end] < negate)
					{
						start++;
						//case 3
					}
					else
					{
						end--;
					}
				}

			}
		}

		return result;
	}
}
