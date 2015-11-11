package com.hnu.xyj;

/**
 * Created by hzxuyajun on 2015/11/9.
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

 If the last word does not exist, return 0.
 */
public class Length_of_Last_Word
{
	public int lengthOfLastWord(String s)
	{
		int length = 0;
		int preLen = 0;
		for (char ch : s.toCharArray())
		{
			if (ch == ' ')
			{
				preLen = length == 0 ? preLen : length;
				length = 0;
			}
			else
				length++;
		}
		return length == 0 ? preLen : length;
	}
}
