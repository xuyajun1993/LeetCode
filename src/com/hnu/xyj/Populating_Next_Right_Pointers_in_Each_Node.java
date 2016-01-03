package com.hnu.xyj;

/**
 * Created by xyj on 15/11/4.
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 */
public class Populating_Next_Right_Pointers_in_Each_Node
{
	public void connect(TreeLinkNode root)
	{
		if (root == null)
			return;
		TreeLinkNode curNode;
		while (root.left != null)
		{
			curNode = root;
			while (curNode != null)
			{
				curNode.left.next = curNode.right;
				if (curNode	.next != null)
				{
					curNode.right.next = curNode.next.left;
				}
				curNode = curNode.next;
			}
			root = root.left;
		}
	}
}

class TreeLinkNode
{
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x)
	{
		val = x;
	}
}
