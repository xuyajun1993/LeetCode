package com.hnu.xyj;

/**
 * Created by hzxuyajun on 2015/10/30.
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class Convert_Sorted_List_to_Binary_Search_Tree
{
	ListNode h;

	public TreeNode sortedListToBST(ListNode head)
	{
		if (head == null)
			return null;
		h = head;

		int length = getLength(h);

		return sortedListToBST(0, length - 1);
	}

	private TreeNode sortedListToBST(int low, int high)
	{
		if (low > high)
			return null;
		int middle = (high + low) / 2;

		TreeNode left = sortedListToBST(low, middle - 1);
		TreeNode root = new TreeNode(h.val);
		h = h.next;
		TreeNode right = sortedListToBST(middle + 1, high);
		root.left = left;
		root.right = right;

		return root;
	}

	private int getLength(ListNode h)
	{
		int size = 0;
		while (h != null)
		{
			size++;
			h = h.next;
		}
		return size;
	}
}
