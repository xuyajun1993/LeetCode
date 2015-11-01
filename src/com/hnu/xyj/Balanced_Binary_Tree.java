package com.hnu.xyj;

/**
 * Created by xyj on 15/11/1.
 * Given a binary tree, determine if it is height-balanced. 
 */
public class Balanced_Binary_Tree
{
	public boolean isBalanced(TreeNode root)
	{
		if (root == null)
			return true;

		if (check(root) == -1)
			return false;

		return true;
	}

	private int check(TreeNode root)
	{

		if (root == null)
			return 0;

		int left = check(root.left);
		int right = check(root.right);

		if (left == -1 || right == -1)
			return -1;

		if (Math.abs(left - right) > 1)
			return -1;

		return Math.max(left, right) + 1;
	}

}
