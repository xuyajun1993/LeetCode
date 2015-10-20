package com.hnu.xyj;

import java.util.Vector;

/**
 * Created by hzxuyajun on 2015/10/14.
 */
public class Ugly_Number_II
{
	public int nthUglyNumber(int n)
	{
		Vector<Integer> vector = new Vector();
		vector.add(0);
		vector.add(1);

		int two = 0, three = 0, five = 0;//2���պ�d�������ֵ��
		boolean isTwo, isThree, isFive;
		while (vector.size()-1 < n)
		{
			isFive = false;
			isThree = false;
			isTwo = false;
			for (int i = 0; i < vector.size() - 1; i++)
			{
				if (!isTwo && 2 * vector.get(i) <= vector.lastElement() && 2 * vector.get(i + 1) > vector.lastElement())
				{
					two = vector.get(i + 1) * 2;
					isTwo = true;
				}
				if (!isThree && 3 * vector.get(i) <= vector.lastElement()
						&& 3 * vector.get(i + 1) > vector.lastElement())
				{
					three = vector.get(i + 1) * 3;
					isThree = true;
				}
				if (!isFive && 5 * vector.get(i) <= vector.lastElement()
						&& 5 * vector.get(i + 1) > vector.lastElement())
				{
					five = vector.get(i + 1) * 5;
					isFive = true;
				}
			}
			//�Ƚ���С
			int min = min(two, three, five);
			vector.add(min);

		}
		return vector.lastElement();
	}

	private int min(int two, int three, int five)
	{
		int min = two < three ? two : three;
		return min < five ? min : five;
	}

}
