package com.hnu.xyj;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xyj on 15/7/7.
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
 * 最多只有两个数符合要求，用candidate1，candidate2分别代表着两个数，count1，count2代表着两个数的个数
 * 先找出出现次数最多的两个数，然后统计这两个数的个数，最后判断这两个数个数是否大于n/3
 */
public class Majority_Element_II {
    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = 0, candidate2 = 0, count1 = 0, count2 = 0;
        int length = nums.length;

        //先找出出现次数最多的两个数
        for (int i = 0; i < length; i++) {
            if (candidate1 == nums[i]) {
                count1++;
            } else if (candidate2 == nums[i]) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = count2 = 0;

        //然后统计这两个数的个数
        for (int i = 0; i < length; i++) {
            if (nums[i] == candidate1)
                count1++;
            else if (nums[i] == candidate2)
                count2++;
        }

        List<Integer> list = new ArrayList<Integer>();

        //最后判断这两个数个数是否大于n/3
        if (count1 > length / 3)
            list.add(candidate1);
        if (count2 > length / 3)
            list.add(candidate2);
        return list;
    }
}
