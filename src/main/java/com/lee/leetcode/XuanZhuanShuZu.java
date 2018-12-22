package com.lee.leetcode;

/**
 *
 *
 *
 *
 * Author :Lee
 * Since :2018/12/11下午10:38
 * Desc :XuanZhuanShuZu Do What ?
 */
public class XuanZhuanShuZu {

    public static void main(String [] args)
    {



        int [] nums = new int [] {1,2,3,4,5,6,7};
        int k = 3;

        rotate(nums,k);
        for (int i = 0 ; i < nums.length; i++)
        {
            System.out.println("******" + nums[i]);
        }

    }

    /**
     * 旋转数组
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        for (int i = nums.length -1 ; i > 0 ; i --)
        {

            int l = ( i+k ) >= nums.length ? 0 + k : i+k;

            System.out.println(l);
            nums[0+k] = nums[l] ^ nums[0+k];
            nums[l] = nums[l] ^ nums[0+k];
            nums[0+k] = nums[l] ^ nums[0+k];


        }
    }
}