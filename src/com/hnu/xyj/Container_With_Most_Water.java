package com.hnu.xyj;

/**
 * Created by hzxuyajun on 2015/11/10.
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 */
public class Container_With_Most_Water
{
	public int maxArea(int[] height)
	{
		int max = 0;
		int left = 0;
		int right = height.length - 1;

		while (left < right)
		{
			max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
			if (height[left] < height[right])
				left++;
			else
				right--;
		}
		return max;
	}
}
