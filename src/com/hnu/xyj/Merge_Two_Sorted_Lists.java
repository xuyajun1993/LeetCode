package com.hnu.xyj;

/**
 * Created by hzxuyajun on 2015/10/16.
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 */
public class Merge_Two_Sorted_Lists
{
	public ListNode mergeTwoLists(ListNode l1, ListNode l2)
	{
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		ListNode node = null;

		if (l1.val < l2.val)
		{
			node = l1;
			node.next = mergeTwoLists(l1.next, l2);
		}
		else
		{
			node = l2;
			node.next = mergeTwoLists(l1, l2.next);
		}
		return node;
	}
}
