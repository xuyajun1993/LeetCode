package com.hnu.xyj;

/**
 * Created by hzxuyajun on 2015/11/5.
 * Given a linked list, determine if it has a cycle in it. 
 */
public class Linked_List_Cycle
{
	public boolean hasCycle(ListNode head)
	{
		ListNode ahead = head;
		ListNode behind = head;

		while (ahead != null && ahead.next != null)
		{
			ahead = ahead.next.next;
			behind = behind.next;

			if (ahead == behind)
				return true;
		}
		return false;
	}
}
