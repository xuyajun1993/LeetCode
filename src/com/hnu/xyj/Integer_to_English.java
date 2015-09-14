package com.hnu.xyj;

/**
 * Created by hzxuyajun on 2015/9/13.
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 2^31 - 1(2147483647).
 * eg:1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 */
public class Integer_to_English
{

	public static void main(String args[])
	{
		Integer_to_English test = new Integer_to_English();
		System.out.println(test.numberToWords(10));
	}

	public String numberToWords(int num)
	{
		if (num == 0)
			return "Zero";
		//判断这个整数位数
		int length = String.valueOf(num).length();

		StringBuilder sb = new StringBuilder();

		if (length > 9)
		{
			int billion_num = num / (int) (Math.pow(10, 9));
			convertOneNumToEng(billion_num, sb);
			sb.append("Billion ");
			num = num % (int) (Math.pow(10, 9));
		}
		if (length > 6)
		{
			int million_num = num / (int) (Math.pow(10, 6));
			convertThreeNumToEng(million_num, sb);
			sb.append("Million ");
			num = num % (int) (Math.pow(10, 6));
		}
		if (length > 3)
		{
			int thousand_num = num / (int) (Math.pow(10, 3));
			convertThreeNumToEng(thousand_num, sb);
			sb.append("Thousand ");
			num = num % (int) (Math.pow(10, 3));
		}
		convertThreeNumToEng(num, sb);

		return sb.toString();
	}

	private void convertThreeNumToEng(int num, StringBuilder sb)
	{
		int hundred = num / 100;
		if (hundred != 0)
		{
			convertOneNumToEng(hundred, sb);
			sb.append("Hundred ");
			num = num % 100;
		}
		convertTwoNumToEng(num, sb);
	}

	private void convertTwoNumToEng(int num, StringBuilder sb)
	{

		int tens = num / 10;
		if (tens == 1)
		{
			switch (num)
			{
				case 10:
					sb.append("Ten ");break;
				case 11:
					sb.append("Eleven ");break;
				case 12:
					sb.append("Twelve ");break;
				case 13:
					sb.append("Thirteen ");break;
				case 14:
					sb.append("Fourteen ");break;
				case 15:
					sb.append("Fifteen ");break;
				case 16:
					sb.append("Sixteen ");break;
				case 17:
					sb.append("Seventeen ");break;
				case 18:
					sb.append("Eighteen ");break;
				case 19:
					sb.append("Nineteen ");break;
			}
		}
		else
		{
			switch (tens)
			{
				case 2:
					sb.append("Twenty ");break;
				case 3:
					sb.append("Thirty ");break;
				case 4:
					sb.append("Forty ");break;
				case 5:
					sb.append("Fifty ");break;
				case 6:
					sb.append("Sixty ");break;
				case 7:
					sb.append("Seventy ");break;
				case 8:
					sb.append("Eighty ");break;
				case 9:
					sb.append("Ninety ");break;
			}
			int bit = num % 10;
			convertOneNumToEng(bit, sb);
		}
	}

	private void convertOneNumToEng(int num, StringBuilder sb)
	{
		switch (num)
		{
			case 1:
				sb.append("One ");break;
			case 2:
				sb.append("Two ");break;
			case 3:
				sb.append("Three ");break;
			case 4:
				sb.append("Four ");break;
			case 5:
				sb.append("Five ");break;
			case 6:
				sb.append("Six ");break;
			case 7:
				sb.append("Seven ");break;
			case 8:
				sb.append("Eight ");break;
			case 9:
				sb.append("Nine ");break;
		}
	}
}
