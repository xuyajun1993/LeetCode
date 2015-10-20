package com.hnu.xyj;

/**
 * Created by hzxuyajun on 2015/10/14.
 */
public class Number_of_Islands
{
	public int numIslands(char[][] grid)
	{
		// ����У��
		if (grid == null || grid.length == 0 || grid[0].length == 0)
		{
			return 0;
		}

		// Ԫ��Ĭ��ֵ��false
		boolean[][] visited = new boolean[grid.length][grid[0].length];

		int result = 0;
		for (int i = 0; i < grid.length; i++)
		{
			for (int j = 0; j < grid[0].length; j++)
			{
				// �����λ��û�б����ʹ������Ҵ�λ���ǵ�������¹�����ȱ���
				if (!visited[i][j] && grid[i][j] == '1')
				{
					result++;
					bfs(grid, visited, i, j);
				}
			}
		}
		return result;
	}

	/**
	 * �����������
	 * @param grid ����
	 * @param visited ���ʱ�Ǿ���
	 * @param row ������
	 * @param col ������
	 */
	private void bfs(char[][] grid, boolean[][] visited, int row, int col)
	{

		if (row >= 0 && row < grid.length // �кϷ�
				&& col >= 0 && col < grid[0].length // �кϷ�
				&& !visited[row][col] // û�з��ʹ�
				&& grid[row][col] == '1')
		{ // �ǵ���½��

			// ��Ǵ�λ���Ѿ����ʹ���
			visited[row][col] = true;

			// ��
			bfs(grid, visited, row - 1, col);
			// ��
			bfs(grid, visited, row, col + 1);
			// ��
			bfs(grid, visited, row + 1, col);
			// ��
			bfs(grid, visited, row, col - 1);

		}
	}
}
