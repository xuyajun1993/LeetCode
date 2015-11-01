package com.hnu.xyj;

/**
 * Created by xyj on 15/10/31.
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 */
public class Majority_Element
{
	public int majorityElement(int[] nums)
	{

		int candidate = 0;

		int count = 0;
		for (int i : nums)
		{

			if (count == 0)
			{
				candidate = i;
				count++;
			}
			else
			{
				if (candidate == i)
				{
					count++;
				}
				else
				{
					count--;
				}
			}
		}
		return candidate;
	}
}
