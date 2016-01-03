package com.hnu.xyj;

import java.util.Set;

/**
 * Created by xyj on 15/12/3.
 *  Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

 For example, given
 s = "leetcode",
 dict = ["leet", "code"].

 Return true because "leetcode" can be segmented as "leet code". 
 */
public class Word_Break
{
	private int getMaxLength(Set<String> dict)
	{
		int maxLength = 0;
		for (String word : dict)
		{
			maxLength = Math.max(maxLength, word.length());
		}
		return maxLength;
	}

	public boolean wordBreak(String s, Set<String> wordDict)
	{
		if (s == null || s.length() == 0)
		{
			return true;
		}

		int maxLength = getMaxLength(wordDict);
		boolean[] canSegment = new boolean[s.length() + 1];

		canSegment[0] = true;
		for (int i = 1; i <= s.length(); i++)
		{
			canSegment[i] = false;
			for (int lastWordLength = 1; lastWordLength <= maxLength && lastWordLength <= i; lastWordLength++)
			{
				if (!canSegment[i - lastWordLength])
				{
					continue;
				}
				String word = s.substring(i - lastWordLength, i);
				if (wordDict.contains(word))
				{
					canSegment[i] = true;
					break;
				}
			}
		}

		return canSegment[s.length()];
	}

}
