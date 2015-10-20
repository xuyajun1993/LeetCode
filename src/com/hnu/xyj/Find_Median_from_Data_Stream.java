package com.hnu.xyj;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by hzxuyajun on 2015/10/19.
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
 */
public class Find_Median_from_Data_Stream
{

	private PriorityQueue<Integer> maxHeap;
	private PriorityQueue<Integer> minHeap;

	public Find_Median_from_Data_Stream()
	{
		maxHeap = new PriorityQueue<Integer>(11, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2)
			{
				return o2 - o1;
			}
		});

		minHeap = new PriorityQueue<Integer>();
	}

	// Adds a number into the data structure.
	public void addNum(int num)
	{

		//如果最大堆为空或者要加入的数不大于最大堆堆顶，则加入最大堆
		if (maxHeap.size() == 0 || num <= maxHeap.peek())
		{
			// 如果最大堆大小超过最小堆，则要平衡一下
			if (maxHeap.size() > minHeap.size())
			{
				minHeap.offer(maxHeap.poll());
			}
			maxHeap.offer(num);
		}
		else if (minHeap.size() == 0 || num > minHeap.peek())
		{
			if (minHeap.size() > maxHeap.size())
			{
				maxHeap.offer(minHeap.poll());
			}
			minHeap.offer(num);

		}
		else
		{// 数字在两个堆顶之间的情况
			if (maxHeap.size() <= minHeap.size())
			{
				maxHeap.offer(num);
			}
			else
			{
				minHeap.offer(num);
			}
		}
	}

	// Returns the median of current data stream
	public double findMedian()
	{
		// 返回大小较大的那个堆堆顶，如果大小一样说明是偶数个，则返回堆顶均值
		if (maxHeap.size() > minHeap.size())
		{
			return maxHeap.peek();
		}
		else if (maxHeap.size() < minHeap.size())
		{
			return minHeap.peek();
		}
		else if (maxHeap.isEmpty() && minHeap.isEmpty())
		{
			return 0;
		}
		else
		{
			return (maxHeap.peek() + minHeap.peek()) / 2.0;
		}
	}
}
