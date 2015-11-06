package com.hnu.xyj;

/**
 * Created by hzxuyajun on 2015/11/5.
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node. 
 */
public class Delete_Node_in_a_Linked_List
{
	public void deleteNode(ListNode node)
	{
		node.val = node.next.val;
		node.next = node.next.next;
	}
}
