package com.hnu.xyj;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by hzxuyajun on 2015/10/16.
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
 */
public class Contains_DuplicateII
{
	public boolean containsNearbyDuplicate(int[] nums, int k)
	{
		Set<Integer> appearedNum = new HashSet<Integer>();
		int start = 0, end = 0;
		for (int i = 0; i < nums.length; i++)
		{
			if (!appearedNum.contains(nums[i]))
			{
				appearedNum.add(nums[i]);
				end++;
			}
			else
				return true;
			if (end - start > k)
			{
				appearedNum.remove(nums[start]);
				start++;
			}
		}
		return false;
	}
}
