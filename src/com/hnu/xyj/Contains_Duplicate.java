package com.hnu.xyj;

import java.util.HashMap;

/**
 * Created by hzxuyajun on 2015/10/16.
 * Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct. 
 */
public class Contains_Duplicate
{
	public boolean containsDuplicate(int[] nums)
	{
		if (nums == null || nums.length == 0)
			return false;

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i : nums)
		{
			if (!map.containsKey(i))
			{
				map.put(i, null);
			}
			else
			{
				return true;
			}
		}
		return false;
	}
}
