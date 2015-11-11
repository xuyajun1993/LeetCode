package com.hnu.xyj;

/**
 * Created by hzxuyajun on 2015/11/11.
 * There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 */
public class Median_of_Two_Sorted_Arrays
{
	public double findMedianSortedArrays(int[] nums1, int[] nums2)
	{
		int m = nums1.length;
		int n = nums2.length;

		if ((m + n) % 2 != 0) // odd
			return (double) findKth(nums1, nums2, (m + n) / 2, 0, m - 1, 0, n - 1);
		else
		{ // even
			return (findKth(nums1, nums2, (m + n) / 2, 0, m - 1, 0, n - 1)
					+ findKth(nums1, nums2, (m + n) / 2 - 1, 0, m - 1, 0, n - 1)) * 0.5;
		}
	}

	public int findKth(int A[], int B[], int k, int aStart, int aEnd, int bStart, int bEnd)
	{

		int aLen = aEnd - aStart + 1;
		int bLen = bEnd - bStart + 1;

		// Handle special cases
		if (aLen == 0)
			return B[bStart + k];
		if (bLen == 0)
			return A[aStart + k];
		if (k == 0)
			return A[aStart] < B[bStart] ? A[aStart] : B[bStart];

		int aMid = aLen * k / (aLen + bLen); // a's middle count
		int bMid = k - aMid - 1; // b's middle count

		// make aMid and bMid to be array index
		aMid = aMid + aStart;
		bMid = bMid + bStart;

		if (A[aMid] > B[bMid])
		{
			k = k - (bMid - bStart + 1);
			aEnd = aMid;
			bStart = bMid + 1;
		}
		else
		{
			k = k - (aMid - aStart + 1);
			bEnd = bMid;
			aStart = aMid + 1;
		}

		return findKth(A, B, k, aStart, aEnd, bStart, bEnd);
	}
}
