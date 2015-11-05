package com.hnu.xyj;

/**
 * Created by hzxuyajun on 2015/11/5.
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 */
public class Linked_List_Cycle_II
{
	public ListNode detectCycle(ListNode head)
	{
		ListNode ahead = head;
		ListNode behind = head;

		while (ahead != null && ahead.next != null)
		{
			ahead = ahead.next.next;
			behind = behind.next;

			if (ahead == behind)
			{
				//ahead节点从head开始
				ahead = head;

				while (behind != ahead)
				{
					ahead = ahead.next;
					behind = behind.next;
				}
				return ahead;
			}
		}
		return null;
	}
}
