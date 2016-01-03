package com.hnu.xyj;

/**
 * Created by xyj on 15/11/18.
 *  Implement strStr().

 Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
判断一个字符串是否是另一个字符串的子串 ，经典的算法应该是KMP算法

 */
public class Implement_strStr
{
	public int strStr(String haystack, String needle)
	{
        if (haystack == null || needle == null) {
            return -1;
        }

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            int j = 0;
            for (j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            // finished loop, needle found
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
	}

}
