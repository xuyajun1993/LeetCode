package com.hnu.xyj;

import java.util.List;

/**
 * Created by hzxuyajun on 2015/10/21.
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
   return 1->4->3->2->5->NULL.
 */
public class Reverse_Linked_List_II
{
	public ListNode reverseBetween(ListNode head, int m, int n)
	{
		if (m == n)
			return head;

		ListNode preHead = new ListNode(0);
		preHead.next = head;

		ListNode firstTail = preHead;

		int k = m - 1;

		while (k-- > 0)
		{
			firstTail = firstTail.next;
		}

		ListNode secondTail = firstTail.next;

		ListNode tmpHead = null;
		ListNode tmpNext = null;

		ListNode node = firstTail.next;

		k = n - m + 1;

		while (k-- > 0)
		{
			tmpHead = node;
			node = node.next;

			tmpHead.next = tmpNext;
			tmpNext = tmpHead;
		}

		firstTail.next = tmpHead;
		secondTail.next = node;

		return preHead.next;

	}
}
