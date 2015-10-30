package com.hnu.xyj;

import java.util.Stack;

/**
 * Created by hzxuyajun on 2015/10/30.
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 */
public class Kth_Smallest_Element_in_a_BST
{
	Stack<TreeNode> stack = new Stack<TreeNode>();

	public int kthSmallest(TreeNode root, int k)
	{
		int result = 0;
		while (root != null || !stack.isEmpty())
		{
			if (root != null)
			{
				stack.push(root);
				root = root.left;
			}
			else
			{
				TreeNode node = stack.pop();
				k--;
				if (k == 0)
					result = node.val;
				root = node.right;
			}
		}
		return result;
	}
}
