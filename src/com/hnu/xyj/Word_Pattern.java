package com.hnu.xyj;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hzxuyajun on 2015/10/12.
 * pattern = "abba", str = "dog cat cat dog" should return true.
 */
public class Word_Pattern
{
	public static boolean wordPattern(String pattern, String str)
	{
		String[] splitArr = str.split(" ");
		if (pattern.length() != splitArr.length)
			return false;
		Map<Character, String> map = new HashMap<Character, String>();

		for (int i = 0; i < pattern.length(); i++)
		{
			if (!map.containsKey(pattern.charAt(i)))
			{
				if (map.containsValue(splitArr[i]))
					return false;
				map.put(pattern.charAt(i), splitArr[i]);
			}
			else
			{
				if (!map.get(pattern.charAt(i)).equals(splitArr[i]))
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args)
	{
		String pattern = "abba";
		String str = "dog fasd cat dog";
		System.out.println(wordPattern(pattern, str));
	}
}
