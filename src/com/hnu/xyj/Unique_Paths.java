package com.hnu.xyj;

/**
 * Created by hzxuyajun on 2015/11/10.
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

 The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

 How many possible unique paths are there?
 */
public class Unique_Paths
{
	int count = 0;

	public int uniquePaths(int m, int n)
	{
		//		dfs(0, 0, m - 1, n - 1);
		//		return count;
		if (m == 0 || n == 0)
			return 0;
		if (m == 1 || n == 1)
			return 1;

		int[][] dp = new int[m][n];

		//left column
		for (int i = 0; i < m; i++)
		{
			dp[i][0] = 1;
		}

		//top row
		for (int j = 0; j < n; j++)
		{
			dp[0][j] = 1;
		}

		//fill up the dp table
		for (int i = 1; i < m; i++)
		{
			for (int j = 1; j < n; j++)
			{
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}

		return dp[m - 1][n - 1];
	}

	/**
	 * time limit exceeded
	 * @param i
	 * @param j
	 * @param row
	 * @param column
	 */
	private void dfs(int i, int j, int row, int column)
	{
		if (i == row && j == column)
		{
			count++;
		}
		if (i < row && j < column)
		{
			dfs(i, j + 1, row, column);
			dfs(i + 1, j, row, column);
		}
		if (i < row)
		{
			dfs(i + 1, j, row, column);
		}
		if (j < column)
		{
			dfs(i, j + 1, row, column);
		}
	}
}