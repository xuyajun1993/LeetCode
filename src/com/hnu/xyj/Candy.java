package com.hnu.xyj;

/**
 * Created by hzxuyajun on 2015/10/14.
 * There are N children standing in a line. Each child is assigned a rating value.
 */
public class Candy
{
	public int candy(int[] ratings)
	{

		if (ratings.length == 1 || ratings.length == 0)
			return 1;

		int total = 1;
		int count = 1; //��¼��������λ�ø����ǹ���
		int down_length = 0; //�ݼ��ĳ���

		for (int i = 0; i < ratings.length - 1; i++)
		{
			//����ݼ�
			if (ratings[i + 1] < ratings[i])
			{
				down_length++;
				if (count > 1)
				{
					count--;
					total = total + count;
					//������˽�β
					if (i == ratings.length - 2)
					{
						total = total - down_length * (count - 1);
						count = 1;
					}
				}
				else
				{
					total = total + down_length + count; //���ϵ�ǰ�ĺ�֮ǰ������
				}
			}
			//��Ⱦͼ�1
			if (ratings[i + 1] == ratings[i])
			{
				//���֮ǰ�ǵݼ��������һ��������1���򲹳�
				if (down_length > 0 && count > 1)
					total = total - down_length * (count - 1);

				down_length = 0;

				count = 1;
				total += 1;
			}
			//����������ȼ�鵱ǰ���ǲ���1��������ǣ�����֮ǰ�ݼ�
			if (ratings[i + 1] > ratings[i])
			{
				//���֮ǰ�ǵݼ��������һ��������1���򲹳�
				if (count > 1 && down_length > 0)
				{
					total = total - down_length * (count - 1);
					count = 1;
				}

				down_length = 0;

				count++;

				total = total + count;
			}
		}

		return total;
	}

}
