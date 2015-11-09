package com.hnu.xyj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hzxuyajun on 2015/11/7.
 *  Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times. 
 */
public class Combination_Sum
{
	public List<List<Integer>> combinationSum(int[] candidates, int target)
	{
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (candidates == null || candidates.length == 0)
			return result;

		ArrayList<Integer> current = new ArrayList<Integer>();
		Arrays.sort(candidates);

		combinationSum(candidates, target, 0, current, result);

		return result;
	}

	private void combinationSum(int[] candidates, int target, int j, ArrayList<Integer> current,
			List<List<Integer>> result)
	{
		if (target == 0)
		{
			result.add(new ArrayList<Integer>(current));
			return;
		}

		for (int i = j; i < candidates.length; i++)
		{
			if (target < candidates[i])
				return;

			current.add(candidates[i]);
			combinationSum(candidates, target - candidates[i], i, current, result);
			current.remove(current.size() - 1);
		}
	}
}
