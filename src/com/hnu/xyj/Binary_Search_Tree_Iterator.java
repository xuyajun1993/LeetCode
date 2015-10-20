package com.hnu.xyj;

import java.util.Stack;

/**
 * Created by hzxuyajun on 2015/10/19.
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 */
public class Binary_Search_Tree_Iterator
{
	private Stack<TreeNode> stack = new Stack<TreeNode>();
	private int nextMin;

	public Binary_Search_Tree_Iterator(TreeNode root)
	{
		while (root != null)
		{
			stack.add(root);
			root = root.left;
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext()
	{
		if (stack.isEmpty())
			return false;

		TreeNode node = stack.pop();

		nextMin = node.val;

		TreeNode right = node.right;
		if (right != null)
		{
			stack.push(right);
			TreeNode left = right.left;
			while (left != null)
			{
				stack.push(left);
				left = left.left;
			}
		}
		return true;
	}

	/** @return the next smallest number */
	public int next()
	{
		return nextMin;
	}
}

/**
 * Definition for binary tree
 */
class TreeNode
{
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x)
	{
		val = x;
	}
}
