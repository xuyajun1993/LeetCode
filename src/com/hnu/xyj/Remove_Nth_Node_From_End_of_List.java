package com.hnu.xyj;

/**
 * Created by hzxuyajun on 2015/11/5.
 * Given a linked list, remove the nth node from the end of list and return its head.

 For example,

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.

 */
public class Remove_Nth_Node_From_End_of_List
{
	public ListNode removeNthFromEnd(ListNode head, int n)
	{
		if (head == null)
			return head;
		ListNode ahead = head;
		ListNode behind = head;

		while (n > 0)
		{
			ahead = ahead.next;
			n--;
		}
		if (ahead == null)
			return head.next;
		while (ahead.next != null)
		{
			ahead = ahead.next;
			behind = behind.next;
		}
		behind.next = behind.next.next;
		return head;
	}
}
