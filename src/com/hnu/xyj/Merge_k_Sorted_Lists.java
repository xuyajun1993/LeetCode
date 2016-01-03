package com.hnu.xyj;

/**
 * Created by hzxuyajun on 2015/10/15.
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * ������/�鲢����
 */
public class Merge_k_Sorted_Lists
{
	public ListNode mergeKLists(ListNode[] lists)
	{

		if (lists == null || lists.length == 0)
		{
			return null;
		}

		int lo = 0;
		int hi = lists.length - 1;

		merge(lists, lo, hi);

		return null;
	}

	private ListNode merge(ListNode[] lists, int lo, int hi)
	{
		ListNode resultNode = null;

		while (lo < hi)
		{
			int mid = lo + (hi - lo) / 2;

			resultNode = mergeTwoLists(merge(lists, lo, mid), merge(lists, mid + 1, hi));
		}
		return resultNode;
	}

	private ListNode mergeTwoLists(ListNode node1, ListNode node2)
	{
		ListNode head = new ListNode(0);
		ListNode node = head;
		while (node1 != null && node2 != null)
		{
			if (node1.val < node2.val)
			{
				node.next = node1;
				node1 = node1.next;
			}
			else
			{
				node.next = node2;
				node2 = node2.next;
			}
			node = node.next;
		}
		if (node1 != null)
			node.next = node1;
		else
			node.next = node2;

		return head.next;
	}
}

class ListNode
{
	int val;
	ListNode next;

	ListNode(int x)
	{
		val = x;
	}
}
