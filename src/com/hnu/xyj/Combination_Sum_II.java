package com.hnu.xyj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by hzxuyajun on 2015/11/7.
 *  Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 Each number in C may only be used once in the combination. 
 */
public class Combination_Sum_II
{
	public List<List<Integer>> combinationSum2(int[] candidates, int target)
	{
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (candidates == null || candidates.length == 0)
			return result;

		ArrayList<Integer> current = new ArrayList<Integer>();
		Arrays.sort(candidates);

		combinationSum(candidates, target, 0, current, result);

		HashSet<List<Integer>> set = new HashSet<List<Integer>>(result);
		//remove duplicate lists
		result.clear();
		result.addAll(set);
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
			combinationSum(candidates, target - candidates[i], i + 1, current, result);
			current.remove(current.size() - 1);
		}
	}
}
