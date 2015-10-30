package com.hnu.xyj;

/**
 * Created by hzxuyajun on 2015/10/21.
 * Reverse a singly linked list.
 */
public class Reverse_Linked_List
{
	public ListNode reverseList(ListNode head)
	{
		if (head == null || head.next == null)
			return head;

		ListNode pre = head;
		ListNode next = head.next;
		pre.next = null;
		ListNode nxt;
		while (next != null)
		{
			nxt = next.next;
			next.next = pre;
			pre = next;
			next = nxt;
		}
		return pre;
	}
}
