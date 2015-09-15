package com.hnu.xyj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by hzxuyajun on 2015/9/14.
 * 计算h_index:此位置是数组的第x个，其值为y，必须满足 y <= x;
 */
public class H_Index
{
	public int hIndex(int[] citations)
	{
		int result = 0;
		if (citations == null)
		{
			return result;
		}
		Arrays.sort(citations);

		for (int i = citations.length - 1; i >= 0; i--)
		{
			if (citations[i] <= citations.length - i)
			{
				result = citations[i];
				return result;
			}
		}
		return result;
	}

    public static void main(String args[])
    {
        H_Index test = new H_Index();
        int[] arr = new int[]{1,0,0};

        System.out.println(test.hIndex(arr));
    }
}
