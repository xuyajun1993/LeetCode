package com.hnu.xyj;

/**
 * Created by hzxuyajun on 2015/10/27.
 * Given an array of integers, every element appears three times except for one. Find that single one.
 */
public class Single_Number_II
{
	public int singleNumber(int[] nums)
	{
		int ones = 0, twos = 0, threes = 0;
		for (int i = 0; i < nums.length; i++)
		{
			twos |= ones & nums[i];
			ones ^= nums[i];// ���3�� �� ��� 1�εĽ����һ����
			//����ones �� twos �ѳ�����3�ε�λ������Ϊ0 ��ȡ��֮��1��λ��Ϊ0��
			threes = ones & twos;
			ones &= ~threes;
			twos &= ~threes;
		}
		return ones;
	}
}
