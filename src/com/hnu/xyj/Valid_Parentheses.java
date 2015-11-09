package com.hnu.xyj;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by hzxuyajun on 2015/11/9.
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class Valid_Parentheses
{
	public boolean isValid(String s)
	{
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');

		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++)
		{
			char ch = s.charAt(i);

			if (map.keySet().contains(ch))
			{
				stack.push(ch);
			}
			else if (map.values().contains(ch))
			{
				if (!stack.isEmpty() && map.get(stack.peek()) == ch)
				{
					stack.pop();
				}
				else
					return false;
			}
		}
		return stack.isEmpty();
	}
}
