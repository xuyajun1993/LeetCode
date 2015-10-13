package com.hnu.xyj;

/**
 * Created by hzxuyajun on 2015/10/13.
 */
public class Find_Bad_Version
{
	public int firstBadVersion(int n)
	{
		int min = 1;
		int max = n;
		while (min <= max)
		{
			int mid = min + (max - min) / 2;

			if (isBadVersion(mid))
				max = mid - 1;
			else
				min = mid + 1;
		}
		return min;
	}

    boolean isBadVersion(int n){
        return true;
    }
}
