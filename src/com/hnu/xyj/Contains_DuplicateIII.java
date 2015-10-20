package com.hnu.xyj;

import java.util.TreeSet;

/**
 * Created by hzxuyajun on 2015/10/16.
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k. 
 */
public class Contains_DuplicateIII
{
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t)
	{
		if (k < 1 || t < 0)
			return false;
		TreeSet<Integer> set = new TreeSet<Integer>();
		for (int i = 0; i < nums.length; i++)
		{
			int n = nums[i];
			if (set.floor(n) != null && n <= t + set.floor(n) || set.ceiling(n) != null && set.ceiling(n) <= t + n)
				return true;
			set.add(n);
			if (i >= k)
				set.remove(nums[i - k]);
		}
		return false;
	}

}
