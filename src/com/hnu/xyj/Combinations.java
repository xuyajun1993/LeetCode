package com.hnu.xyj;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hzxuyajun on 2015/11/6.
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n. 
 */
public class Combinations
{
	public List<List<Integer>> combine(int n, int k)
	{
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (n <= 0 || n < k)
			return result;

		ArrayList<Integer> item = new ArrayList<Integer>();
		dfs(n, k, 1, item, result); // because it need to begin from 1

		return result;
	}

	private void dfs(int n, int k, int start, ArrayList<Integer> item, List<List<Integer>> result)
	{
		if (item.size() == k)
		{
			result.add(new ArrayList<Integer>(item));
			return;
		}

		for (int i = start; i <= n; i++)
		{
			item.add(i);
			dfs(n, k, i + 1, item, result);
			item.remove(item.size() - 1);
		}
	}
}
