package com.lee.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Author :Lee
 * Since :2018/12/11下午3:30
 * Desc :RemoveDuplicates Do What ?
 */
public class RemoveDuplicates {


    public static void main(String []args )
    {

        int [] nums = new int []{1,1,2,5,6,3,3,2};


        int len=  removeDuplicates(nums);

        for ( int i = 0 ; i < len ; i ++)
        {
            System.out.println(nums[i]);
        }
    }


    /**
     * 移除数组中重复的数字
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        Map<Integer,Integer> m = new HashMap();

        int j = 0;
        for (int i = 0 ; i < nums.length ;i++)
        {
            if (null ==  m.get(nums[i])) {
                nums[j] = nums[i];
                m.put(nums[i], i);
                j++;
            }


        }

        return j;

    }
}