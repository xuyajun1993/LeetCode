package com.hnu.xyj;

/**
 * Created by hzxuyajun on 2015/10/30.
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 */
public class Validate_Binary_Search_Tree
{
	boolean result = true;

	public boolean isValidBST(TreeNode root)
	{
		return judge(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
	}

	private boolean judge(TreeNode root, double min, double max)
	{
		if (root == null)
			return true;
		if (root.val <= min || root.val >= max)
			return false;
		return judge(root.left, min, root.val) && judge(root.right, root.val, max);
	}

}
