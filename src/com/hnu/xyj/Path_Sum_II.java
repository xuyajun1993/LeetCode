package com.hnu.xyj;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xyj on 15/11/1.
 *  Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum. 
 */
public class Path_Sum_II
{
	public List<List<Integer>> pathSum(TreeNode root, int sum)
	{
		List<List<Integer>> resList = new ArrayList<List<Integer>>();
		List<Integer> pathList = new ArrayList<Integer>();

		dfs(root, sum, resList, pathList, 0);

		return resList;
	}

	private void dfs(TreeNode root, int sum, List<List<Integer>> resList, List<Integer> pathList, int count)
	{
		if (root == null)
			return;
		count += root.val;
		pathList.add(root.val);
		/**
		* leaf node
		*/
		if (root.left == null && root.right == null)
		{
			if (sum == count)
				//必须用拷贝
				resList.add(new ArrayList(pathList));
			return;
		}

		if (root.left != null)
		{
			dfs(root.left, sum, resList, pathList, count);
			pathList.remove(pathList.size() - 1);
			//			count -= root.left.val;(值传递和引用传递，基本类型和对象)
		}
		if (root.right != null)
		{
			dfs(root.right, sum, resList, pathList, count);
			pathList.remove(pathList.size() - 1);
			//			count -= root.right.val;
		}

	}
}
