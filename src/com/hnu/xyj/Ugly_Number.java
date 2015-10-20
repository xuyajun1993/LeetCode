package com.hnu.xyj;

import java.util.Vector;

/**
 * Created by hzxuyajun on 2015/10/14.
 *  Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7. 
 */
public class Ugly_Number
{
	public boolean isUgly(int num)
	{

        if (num>Integer.MAX_VALUE/5)
            return false;

		Vector<Integer> vector = new Vector();
		vector.add(0);
		vector.add(1);

		int two = 0, three = 0, five = 0;//2倍刚好d大于最大值的
        boolean isTwo,isThree,isFive;
		while (vector.lastElement() < num)
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
			//比较最小
			int min = min(two, three, five);
			vector.add(min);
			System.out.println(min);
		}

		if (vector.lastElement().equals(num))
			return true;
		else
			return false;
	}

	private int min(int two, int three, int five)
	{
		int min = two < three ? two : three;
		return min < five ? min : five;
	}

	public static void main(String[] args)
	{
		Ugly_Number ugly_number = new Ugly_Number();
		System.out.println(ugly_number.isUgly(1500));
	}
}
