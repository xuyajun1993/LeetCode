package com.hnu.xyj;

/**
 * Created by hzxuyajun on 2015/11/10.
 * Follow up for "Unique Paths":

 Now consider if some obstacles are added to the grids. How many unique paths would there be?

 An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 */
public class Unique_Paths_II
{
	public int uniquePathsWithObstacles(int[][] obstacleGrid)
	{
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;

		if (m == 0 || n == 0)
			return 0;

		int[][] dp = new int[m][n];

		//left column
		for (int i = 0; i < m; i++)
		{
			if (obstacleGrid[i][0] == 1)
				break;
			else
				dp[i][0] = 1;
		}

		//top row
		for (int j = 0; j < n; j++)
		{
			if (obstacleGrid[0][j] == 1)
				break;
			else
				dp[0][j] = 1;
		}

		//fill up the dp table
		for (int i = 1; i < m; i++)
		{
			for (int j = 1; j < n; j++)
			{
				dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1];
			}
		}

		return dp[m - 1][n - 1];

	}
}
