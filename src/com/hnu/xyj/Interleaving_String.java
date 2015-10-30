package com.hnu.xyj;

/**
 * Created by hzxuyajun on 2015/10/26.
 * Given s1, s2, s3Arr, find whether s3Arr is formed by the interleaving of s1 and s2.
 * dp[i+1][j+1]:��ʾs1[0...i]��s2[0...j]�ܷ����γ�s3[0...i+j+1]����
 *  ״̬ת�Ʒ���:
 dp[i+1][j+1] = (dp[i][j+1] && s1[i] == s3[i+j+1]) | (dp[i+1][j] && s2[j] == s3[i+j+1]); 
 */
public class Interleaving_String
{
	public boolean isInterleave(String s1, String s2, String s3)
	{
		char[] s1Arr = s1.toCharArray();
		char[] s2Arr = s2.toCharArray();
		char[] s3Arr = s3.toCharArray();
		int m = s1.length(), n = s2.length();
		if (m + n != s3.length())
			return false;
		boolean[][] dp = new boolean[m + 1][n + 1];
		dp[0][0] = true;
		//��ʼ���߽�.
		for (int i = 0; i < n; ++i)
			dp[0][i + 1] = dp[0][i] && s2Arr[i] == s3Arr[i];
		for (int i = 0; i < m; ++i)
			dp[i + 1][0] = dp[i][0] && s1Arr[i] == s3Arr[i];
		for (int i = 0; i < m; ++i)
			for (int j = 0; j < n; ++j)
				dp[i + 1][j + 1] = (dp[i][j + 1] && s1Arr[i] == s3Arr[i + j + 1])
						| (dp[i + 1][j] && s2Arr[j] == s3Arr[i + j + 1]);
		return dp[m][n];
	}
}
