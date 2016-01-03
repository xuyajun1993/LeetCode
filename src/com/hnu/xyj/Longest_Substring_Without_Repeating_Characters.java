package com.hnu.xyj;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xyj on 15/11/17.
 * Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class Longest_Substring_Without_Repeating_Characters
{
	public int lengthOfLongestSubstring(String s)
	{
		if (s == null || s.length() == 0)
		{
			return 0;
		}

		Set<Character> set = new HashSet<Character>();

		int leftBound = 0, max = 0;
		for (int i = 0; i < s.length(); i++)
		{
			if (set.contains(s.charAt(i)))
			{
				while (leftBound < i && s.charAt(leftBound) != s.charAt(i))
				{
					set.remove(s.charAt(leftBound));
					leftBound++;
				}
				leftBound++;
			}
			else
			{
				set.add(s.charAt(i));
				max = Math.max(max, i - leftBound + 1);
			}
		}

		return max;
	}
}
