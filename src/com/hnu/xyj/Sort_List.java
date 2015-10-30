package com.hnu.xyj;

import java.util.List;

/**
 * Created by hzxuyajun on 2015/10/20.
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class Sort_List
{
	public ListNode sortList(ListNode head)
	{
		if (head == null)
			return head;

		return mergeSort(head, null);
	}

	private ListNode mergeSort(ListNode head, ListNode tail)
	{
		if (head.next == tail)
		{
			head.next = null;
			return head;
		}

		ListNode itr = head, mid = head;
		while (itr != tail)
		{
			itr = itr.next;

			if (itr != tail)
			{
				itr = itr.next;
			}
			mid = mid.next;
		}

		ListNode lhalf = mergeSort(head, mid);
		ListNode rhalf = mergeSort(mid, tail);

		return merge(lhalf, rhalf);
	}

	private ListNode merge(ListNode lhalf, ListNode rhalf)
	{
		ListNode head = new ListNode(0);
		ListNode iter = head;

		while (lhalf != null && rhalf != null)
		{
			if (lhalf.val < rhalf.val)
			{
				iter.next = lhalf;
				iter = lhalf;
				lhalf = lhalf.next;
			}
			else
			{
				iter.next = rhalf;
				iter = rhalf;
				rhalf = rhalf.next;
			}
		}

		if (lhalf != null)
			iter.next = lhalf;
		else if (rhalf != null)
			iter.next = rhalf;

		return head.next;
	}
}
