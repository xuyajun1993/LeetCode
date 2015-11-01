package com.hnu.xyj;

import java.util.Arrays;

/**
 * Created by xyj on 15/10/31.
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sortedorder, not the kth distinct element.
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 */
public class Kth_Largest_Element_in_an_Array
{
	public int findKthLargest(int[] nums, int k)
	{
		/**
		 * 转为寻找第几小的数
		 */
		return getNumber(nums, 0, nums.length - 1, nums.length - k + 1);
	}

	private int getNumber(int[] nums, int start, int end, int k)
	{

		int pivot = nums[end];
		int left = start;
		int right = end;

		while (true)
		{
			while (left < right && nums[left] < pivot)
				left++;

			while (right > left && nums[right] >= pivot)
				right--;

			if (left == right)
				break;

			swap(nums, left, right);

		}

		swap(nums, left, end);

		if (k == left + 1)
		{
			return pivot;
		}
		else if (k < left + 1)
		{
			return getNumber(nums, start, left - 1, k);
		}
		else
		{
			return getNumber(nums, left + 1, end, k);
		}

	}

	private void swap(int[] nums, int start, int end)
	{
		int tmp = nums[start];
		nums[start] = nums[end];
		nums[end] = tmp;
	}
}
