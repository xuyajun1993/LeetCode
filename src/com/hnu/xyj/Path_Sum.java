package com.hnu.xyj;

/**
 * Created by xyj on 15/11/1.
 *  Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum. 
 */
public class Path_Sum
{
	public boolean hasPathSum(TreeNode root, int sum)
	{
		return dfs(root, sum, 0);
	}

	private boolean dfs(TreeNode root, int sum, int curSum)
	{
		if (root == null)
			return false;

		if (root.left == null && root.right == null)
			return curSum + root.val == sum;

		return dfs(root.left, sum, curSum + root.val) || dfs(root.right, sum, curSum + root.val);
	}
}
