package com.hnu.xyj;

/**
 * Created by xyj on 15/7/6.
 * Given an integer, write a function to determine if it is a power of two.
 * 最简单的是：将该数减1然后与自己做&运算看结果是否为0
 */
public class Power_of_Two {
    public boolean isPowerOfTwo(int n) {
        return (n>0)&&((n&(n-1))==0);
    }
}


