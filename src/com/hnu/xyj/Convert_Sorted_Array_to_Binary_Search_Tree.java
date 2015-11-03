package com.hnu.xyj;

/**
 * Created by hzxuyajun on 2015/11/2.
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class Convert_Sorted_Array_to_Binary_Search_Tree
{
	int index = 0;

	public TreeNode sortedArrayToBST(int[] nums)
	{
		if (nums != null)
			return sortedArrayToBST(0, nums.length - 1, nums);
		return null;
	}

	private TreeNode sortedArrayToBST(int start, int end, int[] nums)
	{
		if (start > end)
			return null;
		int mid = (start + end) / 2;

		TreeNode left = sortedArrayToBST(start, mid - 1, nums);

		TreeNode root = new TreeNode(nums[index]);
		index++;

		TreeNode right = sortedArrayToBST(mid + 1, end, nums);

		root.left = left;
		root.right = right;
		return root;
	}
}
