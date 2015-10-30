package com.hnu.xyj;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by hzxuyajun on 2015/10/29.
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * "{1,2,3,#,#,4,#,#,5}"
 */
public class Binary_Tree_Inorder_Traversal
{
	List<Integer> list = new ArrayList<Integer>();

	public List<Integer> inorderTraversal(TreeNode root)
	{
		Stack<TreeNode> stack = new Stack<TreeNode>();

		while (!stack.isEmpty() || root != null)
		{

			if (root != null)
			{
				stack.push(root);
				root = root.left;
			}
			else
			{
				TreeNode node = stack.pop();
				list.add(node.val);
				root = node.right;
			}
		}
		return list;
	}

//    /**
//     * the recursive solution
//     * @param node
//     */
//	public void helper(TreeNode node)
//	{
//		if (node.left != null)
//		{
//			helper(node.left);
//		}
//		list.add(node.val);
//		if (node.right != null)
//		{
//			helper(node.right);
//		}
//	}
}
