package com.hnu.xyj;

/**
 * Created by hzxuyajun on 2015/10/14.
 * There are N children standing in a line. Each child is assigned a rating value.
 */
public class Candy
{
	public int candy(int[] ratings)
	{

		if (ratings.length == 1 || ratings.length == 0)
			return 1;

		int total = 1;
		int count = 1; //记录遍历到的位置给的糖果数
		int down_length = 0; //递减的长度

		for (int i = 0; i < ratings.length - 1; i++)
		{
			//如果递减
			if (ratings[i + 1] < ratings[i])
			{
				down_length++;
				if (count > 1)
				{
					count--;
					total = total + count;
					//如果到了结尾
					if (i == ratings.length - 2)
					{
						total = total - down_length * (count - 1);
						count = 1;
					}
				}
				else
				{
					total = total + down_length + count; //加上当前的和之前的增量
				}
			}
			//相等就加1
			if (ratings[i + 1] == ratings[i])
			{
				//如果之前是递减并且最后一个数大于1，则补偿
				if (down_length > 0 && count > 1)
					total = total - down_length * (count - 1);

				down_length = 0;

				count = 1;
				total += 1;
			}
			//如果递增，先检查当前数是不是1，如果不是，补偿之前递减
			if (ratings[i + 1] > ratings[i])
			{
				//如果之前是递减并且最后一个数大于1，则补偿
				if (count > 1 && down_length > 0)
				{
					total = total - down_length * (count - 1);
					count = 1;
				}

				down_length = 0;

				count++;

				total = total + count;
			}
		}

		return total;
	}

}
