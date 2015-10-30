package com.hnu.xyj;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hzxuyajun on 2015/10/30.
 * Given a binary tree, return the preorder traversal of its nodes' values.
 */
public class Binary_Tree_Preorder_Traversal
{
	List<Integer> list = new ArrayList<Integer>();

	public List<Integer> preorderTraversal(TreeNode root)
	{
		preorder(root);
		return list;
	}

	private void preorder(TreeNode root)
	{
		if (root == null)
			return;
		list.add(root.val);
		if (root.left != null)
			preorder(root.left);
		if (root.right != null)
			preorder(root.right);
	}
}
