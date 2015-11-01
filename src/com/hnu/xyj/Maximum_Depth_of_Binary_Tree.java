package com.hnu.xyj;

/**
 * Created by xyj on 15/10/31.
 * Given a binary tree, find its maximum depth.
 */
public class Maximum_Depth_of_Binary_Tree
{
	public int maxDepth(TreeNode root)
	{

		if (root == null)
			return 0;
		if (root.left == null)
			return maxDepth(root.right) + 1;
		if (root.right == null)
			return maxDepth(root.left) + 1;

		return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
	}
}
