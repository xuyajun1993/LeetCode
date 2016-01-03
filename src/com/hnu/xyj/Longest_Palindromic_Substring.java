package com.hnu.xyj;

/**
 * Created by xyj on 15/11/17.
 * Given a string S, find the longest palindromic substring(回文串) in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 */
public class Longest_Palindromic_Substring
{
	public String longestPalindrome(String s)
	{
		if (s == null || s.length() == 0)
		{
			return "";
		}

		int length = s.length();
		int max = 0;
		String result = "";
		for (int i = 1; i <= 2 * length - 1; i++)
		{
			int count = 1;
			while (i - count >= 0 && i + count <= 2 * length && get(s, i - count) == get(s, i + count))
			{
				count++;
			}
			count--; // there will be one extra count for the outbound #
			if (count > max)
			{
				result = s.substring((i - count) / 2, (i + count) / 2);
				max = count;
			}
		}

		return result;
	}

	private char get(String s, int i)
	{
		if (i % 2 == 0)
			return '#';
		else
			return s.charAt(i / 2);
	}

}
