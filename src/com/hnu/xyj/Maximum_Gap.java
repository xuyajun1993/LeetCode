package com.hnu.xyj;

import java.util.Arrays;

/**
 * Created by hzxuyajun on 2015/10/22.
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 * 桶排序
 * (计数排序可以看做是桶大小为1的桶排序，但由于桶数目太多导致遍历时间过长。)  最大gap肯定是出现在后一个有效桶的min与前一个有效桶的max之间。
 */
public class Maximum_Gap
{
	public int maximumGap(int[] nums)
	{
		if (nums == null || nums.length < 2)
			return 0;
		// get the max and min value of the array
		int min = nums[0];
		int max = nums[0];
		for (int i : nums)
		{
			min = Math.min(min, i);
			max = Math.max(max, i);
		}
		// the minimum possibale gap, ceiling of the integer division
		int gap = (int) Math.ceil((double) (max - min) / (nums.length - 1));
		int[] bucketsMIN = new int[nums.length - 1]; // store the min value in that bucket
		int[] bucketsMAX = new int[nums.length - 1]; // store the max value in that bucket
		Arrays.fill(bucketsMIN, Integer.MAX_VALUE);
		Arrays.fill(bucketsMAX, Integer.MIN_VALUE);
		// put numbers into buckets
		for (int i : nums)
		{
			if (i == min || i == max)
				continue;
			int idx = (i - min) / gap; // index of the right position in the buckets
			bucketsMIN[idx] = Math.min(i, bucketsMIN[idx]);
			bucketsMAX[idx] = Math.max(i, bucketsMAX[idx]);
		}
		// scan the buckets for the max gap
		int maxGap = Integer.MIN_VALUE;
		int previous = min;
		for (int i = 0; i < nums.length - 1; i++)
		{
			if (bucketsMIN[i] == Integer.MAX_VALUE && bucketsMAX[i] == Integer.MIN_VALUE)
				// empty bucket
				continue;
			// min value minus the previous value is the current gap
			maxGap = Math.max(maxGap, bucketsMIN[i] - previous);
			// update previous bucket value
			previous = bucketsMAX[i];
		}
		maxGap = Math.max(maxGap, max - previous); // updata the final max value gap
		return maxGap;
	}
}
