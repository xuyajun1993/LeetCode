package com.hnu.xyj;

import java.util.List;

/**
 * Created by hzxuyajun on 2015/10/20.
 * Sort a linked list using insertion sort.
 */
public class Insertion_Sort_List
{
	public ListNode insertionSortList(ListNode head)
	{

		if (head == null)
			return null;

		ListNode helper = new ListNode(0);

		ListNode pre = helper;

		ListNode cur = head;

		while (cur != null)
		{
			ListNode next = cur.next;
			pre = helper;

			while (pre.next != null && pre.next.val < cur.val)
			{
				pre = pre.next;
			}

			cur.next = pre.next;
			pre.next = cur;
			cur = next;
		}

		return helper.next;
	}
}
