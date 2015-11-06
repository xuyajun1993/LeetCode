package com.hnu.xyj;

/**
 * Created by hzxuyajun on 2015/11/5.
 *  A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

 Return a deep copy of the list.
 */
public class Copy_List_with_Random_Pointer
{
	public RandomListNode copyRandomList(RandomListNode head)
	{
		if (head == null)
			return head;
		/*��һ��:��OldList��ÿ���ڵ���涼����һ��copyNode(��������Ľ��)*/
		RandomListNode nowNode = head;
		while (nowNode != null)
		{
			RandomListNode copyNode = new RandomListNode(nowNode.label);
			copyNode.random = nowNode.random;
			copyNode.next = nowNode.next;
			nowNode.next = copyNode;
			nowNode = nowNode.next.next;
		}

		/*�ڶ���:ȷ��NewList��ÿ���ڵ�,������������Random������ĸ���
		 * 		��Ϊ��һ���Ѿ�������NewList�ϵĽ�㶼������*/
		nowNode = head;
		while (nowNode != null)
		{
			if (nowNode.random != null)
			{
				nowNode.next.random = nowNode.random.next;
			}
			nowNode = nowNode.next.next;
		}

		/*����������ԭOldList��nextΪһ��ʼ��next���
		 * 		��ƴ��NewList��next����������Ӧ�ù�����next���
		 * 		��������������OldList���䣬ƴ��������NewList��
		 * */
		RandomListNode pHead = new RandomListNode(0);
		pHead.next = head;
		RandomListNode newlist = pHead;

		nowNode = head;
		while (nowNode != null)
		{
			pHead.next = nowNode.next;
			nowNode.next = pHead.next.next;
			pHead = pHead.next;
			nowNode = nowNode.next;
		}
		return newlist.next;
	}
}

class RandomListNode
{
	int label;
	RandomListNode next, random;

	RandomListNode(int x)
	{
		this.label = x;
	}
};
