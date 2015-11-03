package com.hnu.xyj;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by hzxuyajun on 2015/10/30.
 *  Given a sorted linked list, delete all duplicates such that each element appear only once.

 For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3.
 */
public class Remove_Duplicates_from_Sorted_List
{
	public ListNode deleteDuplicates(ListNode head)
	{
		List<Integer> list = new ArrayList<Integer>();
		ListNode index = head;
		ListNode start = head;
		while (start != null)
		{
			if (!list.contains(start.val))
			{
				list.add(start.val);
				index = start;
			}
			else
			{
				index.next = start.next;
			}
			start = start.next;
		}
		return head;
	}
}
