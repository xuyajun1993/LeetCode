package com.hnu.xyj;

/**
 * Created by hzxuyajun on 2015/11/3.
 * Given a complete binary tree, count the number of nodes.
 */
public class Count_Complete_Tree_Nodes
{
	public int countNodes(TreeNode root)
	{
		if (root == null)
			return 0;
		int lh = getLeftHeight(root);
		int rh = getRightHeight(root);

		if (lh == rh)
			return (2 << lh - 1) - 1;

		return countNodes(root.left) + countNodes(root.right) + 1;
	}

	/**
	 * 得到左子树高
	 * @param root
	 * @return
	 */
	private int getLeftHeight(TreeNode root)
	{
		int h = 0;
		while (root != null)
		{
			h++;
			root = root.left;
		}
		return h;
	}

	/**
	 * 得到右子树高
	 * @param root
	 * @return
	 */
	private int getRightHeight(TreeNode root)
	{
		int h = 0;
		while (root != null)
		{
			h++;
			root = root.right;
		}
		return h;
	}
}
