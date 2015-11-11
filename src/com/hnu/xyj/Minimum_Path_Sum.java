package com.hnu.xyj;

/**
 * Created by hzxuyajun on 2015/11/9.
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 */
public class Minimum_Path_Sum
{
	public int minPathSum(int[][] grid)
	{
		//		return dfs(0, 0, grid);
		if (grid == null || grid.length == 0)
			return 0;

		int m = grid.length;
		int n = grid[0].length;

		int[][] dp = new int[m][n];
		dp[0][0] = grid[0][0];

		// initialize top row
		for (int i = 1; i < n; i++)
		{
			dp[0][i] = dp[0][i - 1] + grid[0][i];
		}

		// initialize left column
		for (int j = 1; j < m; j++)
		{
			dp[j][0] = dp[j - 1][0] + grid[j][0];
		}

		// fill up the dp table
		for (int i = 1; i < m; i++)
		{
			for (int j = 1; j < n; j++)
			{
				if (dp[i - 1][j] > dp[i][j - 1])
				{
					dp[i][j] = dp[i][j - 1] + grid[i][j];
				}
				else
				{
					dp[i][j] = dp[i - 1][j] + grid[i][j];
				}
			}
		}

		return dp[m - 1][n - 1];
	}

	/**
	 * time limit exceeded
	 * @param i 代表行
	 * @param j 代表列
	 * @param grid
	 * @return
	 */
	private int dfs(int i, int j, int[][] grid)
	{
		if (i == grid.length - 1 && j == grid[0].length - 1)
		{
			return grid[i][j];
		}
		if (i < grid.length - 1 && j < grid[0].length - 1)
		{
			int right = grid[i][j] + dfs(i, j + 1, grid);
			int down = grid[i][j] + dfs(i + 1, j, grid);
			return Math.min(right, down);
		}
		if (i < grid.length - 1)
		{
			return grid[i][j] + dfs(i + 1, j, grid);
		}
		if (j < grid[0].length - 1)
		{
			return grid[i][j] + dfs(i, j + 1, grid);
		}

		return 0;
	}
}
