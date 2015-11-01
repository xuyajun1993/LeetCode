package com.hnu.xyj;

/**
 * Created by xyj on 15/10/31.
 * Given a binary tree, find its minimum depth.
 */
public class Minimum_Depth_of_Binary_Tree
{
	public int minDepth(TreeNode root)
	{

		if (root == null)
			return 0;

		if (root.left == null)
			return minDepth(root.right) + 1;
		if (root.right == null)
			return minDepth(root.left) + 1;
		return Math.min(minDepth(root.left) + 1, minDepth(root.right) + 1);
	}

}
