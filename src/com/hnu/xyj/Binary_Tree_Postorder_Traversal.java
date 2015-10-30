package com.hnu.xyj;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hzxuyajun on 2015/10/30.
 * Given a binary tree, return the postorder traversal of its nodes' values.
 */
public class Binary_Tree_Postorder_Traversal
{
	List<Integer> list = new ArrayList<Integer>();

	public List<Integer> postorderTraversal(TreeNode root)
	{
		if (root != null)
			postorder(root);

		return list;
	}

	private void postorder(TreeNode root)
	{
		if (root.left != null)
			postorderTraversal(root.left);
		if (root.right != null)
			postorderTraversal(root.right);

		list.add(root.val);
	}
}
