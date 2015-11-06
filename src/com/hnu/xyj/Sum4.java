package com.hnu.xyj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by hzxuyajun on 2015/11/6.
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 */
public class Sum4
{
	public List<List<Integer>> fourSum(int[] nums, int target)
	{
		Arrays.sort(nums);

		HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		for (int i = 0; i < nums.length; i++)
		{
			for (int j = i + 1; j < nums.length; j++)
			{
				int k = j + 1;
				int l = nums.length - 1;

				while (k < l)
				{
					int sum = nums[i] + nums[j] + nums[k] + nums[l];

					if (sum > target)
					{
						l--;
					}
					else if (sum < target)
					{
						k++;
					}
					else if (sum == target)
					{
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(nums[i]);
						temp.add(nums[j]);
						temp.add(nums[k]);
						temp.add(nums[l]);

						//≈–∂œ «∑Ò÷ÿ∏¥
						if (!hashSet.contains(temp))
						{
							hashSet.add(temp);
							result.add(temp);
						}

						k++;
						l--;
					}
				}
			}
		}

		return result;
	}
}
