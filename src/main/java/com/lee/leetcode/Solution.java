package com.lee.leetcode;

/**
 * Author :Lee
 * Since :2018/12/11下午5:07
 * Desc :Solution Do What ?
 */
public class Solution {
    public static void main(String[] args) {
        int[] prices = new int[]{1,20,2,4,99,100,200};
        System.out.println(getBestSum(prices));
    }
    public static int getBestSum(int[] prices) {
        int sum = 0;
        for (int i = 0; i < prices.length; i++) {
            if ((i + 1) != prices.length && prices[i + 1] - prices[i] > 0  ) {
                sum += prices[i + 1] - prices[i];
            }
        }
        return sum;
    }
}