package com.hnu.xyj;

/**
 * Created by xyj on 15/11/19.
 * The count-and-say sequence is the sequence of integers beginning as follows:
 *  1, 11, 21, 1211, 111221, ...
 *  1 is read off as "one 1" or 11.
 */
public class Count_and_Say
{
	public  String countAndSay(int n)
	{
        String oldString = "1";
        while (--n > 0) {
            StringBuilder sb = new StringBuilder();
            char [] oldChars = oldString.toCharArray();

            for (int i = 0; i < oldChars.length; i++) {
                int count = 1;
                while ((i+1) < oldChars.length && oldChars[i] == oldChars[i+1]) {
                    count++;
                    i++;
                }
                sb.append(String.valueOf(count) + String.valueOf(oldChars[i]));
            }
            oldString = sb.toString();
//            System.out.println(oldString+"\n");
        }

        return oldString;
	}
}
