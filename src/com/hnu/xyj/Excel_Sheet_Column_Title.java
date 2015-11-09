package com.hnu.xyj;

/**
 * Created by hzxuyajun on 2015/11/9.
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 *  1 -> A
 2 -> B
 3 -> C
 ...
 26 -> Z
 27 -> AA
 28 -> AB 
 */
public class Excel_Sheet_Column_Title
{
	public static String convertToTitle(int n)
	{
		if (n <= 0)
		{
			throw new IllegalArgumentException("Input is not valid!");
		}

		StringBuilder sb = new StringBuilder();

		while (n > 0)
		{
			n--;
			char ch = (char) (n % 26 + 'A');
			n /= 26;
			sb.append(ch);
		}

		sb.reverse();
		return sb.toString();
	}
    
    public static void main(String[] args){
		System.out.println(Excel_Sheet_Column_Title.convertToTitle(260));
    }
}
