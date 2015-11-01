package com.hnu.xyj;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xyj on 15/11/1.
 */
public class Binary_Tree_Paths
{

	List<String> res = new ArrayList<String>();

	public List<String> binaryTreePaths(TreeNode root)
	{
		if (root != null)
			findPaths(root, String.valueOf(root.val));
		return res;
	}

	private void findPaths(TreeNode n, String path)
	{
		if (n.left == null && n.right == null)
			res.add(path);
		if (n.left != null)
			findPaths(n.left, path + "->" + n.left.val);
		if (n.right != null)
			findPaths(n.right, path + "->" + n.right.val);

	}
}
