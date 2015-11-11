package com.hnu.xyj;

/**
 * Created by hzxuyajun on 2015/11/9.
 * What if the citations array is sorted in ascending order? Could you optimize your algorithm? 
 */
public class H_Index_II
{
	public int hIndex(int[] citations)
	{
		int n = citations.length;

		int low = 0, high = n - 1;

		while (low <= high)
		{
			int mid = low + (high - low) / 2;
			if (citations[mid] == n - mid)
				return n - mid;
			else if (citations[mid] < n - mid)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return n - low;
	}
}
