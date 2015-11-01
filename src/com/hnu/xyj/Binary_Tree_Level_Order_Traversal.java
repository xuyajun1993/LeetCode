package com.hnu.xyj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xyj on 15/10/31.
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * 使用链表保存节点，并保存每层的节点数BFS
 */
public class Binary_Tree_Level_Order_Traversal
{
	public List<List<Integer>> levelOrder(TreeNode root)
	{
		List<List<Integer>> resList = new ArrayList<List<Integer>>();

		LinkedList<TreeNode> linkedList = new LinkedList<TreeNode>();

		if (root == null)
			return resList;

		linkedList.add(root);

		int curLevCnt = 1;
		int nextLevCnt = 0;

		List<Integer> levList = new ArrayList<Integer>();

		while (!linkedList.isEmpty())
		{

			TreeNode node = linkedList.poll();

			curLevCnt--;
			levList.add(node.val);

			if (node.left != null)
			{
				linkedList.add(node.left);
				nextLevCnt++;
			}

			if (node.right != null)
			{
				linkedList.add(node.right);
				nextLevCnt++;
			}

			if (curLevCnt == 0)
			{
				curLevCnt = nextLevCnt;
				nextLevCnt = 0;
				resList.add(levList);
				levList = new ArrayList<Integer>();
			}
		}
		return resList;
	}
}
