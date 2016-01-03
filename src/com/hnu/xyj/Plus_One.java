package com.hnu.xyj;

/**
 * Created by xyj on 15/11/17.
 * Given a non-negative number represented as an array of digits, plus one to the number.

 The digits are stored such that the most significant digit is at the head of the list.
 */
public class Plus_One
{
	public int[] plusOne(int[] digits)
	{
		int carry = 1; // 进位标志，下一位来的进位标志
		int tmp;
		for (int i = digits.length - 1; i >= 0; i--)
		{
			tmp = digits[i];
			digits[i] = (tmp + carry) % 10; // 计算当前位的新值
			carry = (tmp + carry) / 10; // 计算新的进位
		}

		if (carry == 1)
		{ // 最后还有一个进位
			int[] result = new int[digits.length + 1];
			System.arraycopy(digits, 0, result, 1, digits.length);
			result[0] = carry;
			return result;
		}
		else
		{
			return digits;
		}
	}
}
