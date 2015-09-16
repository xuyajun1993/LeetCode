package com.hnu.xyj;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by hzxuyajun on 2015/9/15.
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * 取定一个点，计算其他点与其的斜率，统计相同的个数
 * 边界情况：数组为空，数组大小为1or2，是否是同一个点，纵坐标相同
*/
public class Max_Points
{
	public int maxPoints(Point[] points)
	{
		int result = 0;
		if (points == null)
		{
			return result;
		}
		int size = points.length;
		if (size == 1 || size == 2)
			return size;

		//讨论个数为3及以上的情况

		Map<Double, Integer> map;
		for (int i = 0; i < size; i++)
		{
			map = new HashMap<Double, Integer>();
			for (int j = 0; j < size; j++)
			{
				if (i == j)
					continue;

				if (points[i].x == points[j].x && points[i].y == points[j].y)
				{
					//同一个点就视为最小值
					if (map.get((double) Integer.MIN_VALUE) == null)
						map.put((double) Integer.MIN_VALUE, 1);
					else
						map.put((double) Integer.MIN_VALUE, map.get((double) Integer.MIN_VALUE) + 1);
					continue;
				}
				//计算斜率:注意斜率不存在（视为最大值）
				double slope = points[i].x == points[j].x ? Integer.MAX_VALUE
						: (double) (points[j].y - points[i].y) / (points[j].x - points[i].x);
				if (map.get(slope) == null)
					map.put(slope, 1);
				else
					map.put(slope, map.get(slope) + 1);
			}
			//找出map中值最大的,存在count
			int max = 0;
			for (Map.Entry entry : map.entrySet())
			{
				int value = Integer.parseInt(entry.getValue().toString());
				if (max < value)
					max = value;
			}
			if (max > result)
				result = max;
		}
		return result + 1;
	}

	public static void main(String args[])
	{
		Max_Points test = new Max_Points();
		Point point1 = new Point(1, 1);
		Point point2 = new Point(1, 1);
		Point point3 = new Point(1, 1);

		System.out.println(test.maxPoints(new Point[]
		{ point1, point2, point3 }));

	}
}

class Point
{
	int x;
	int y;

	Point()
	{
		x = 0;
		y = 0;
	}

	Point(int a, int b)
	{
		x = a;
		y = b;
	}
}
