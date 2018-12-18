package com.lee.test;

/**
 * @author
 * @create 2018-12-17 8:52
 **/
public class TestBestSum {

  public static void main(String[] args) {

    int[] lll = new int[]{1,5,1,8,12};
    System.out.println(sum(lll));
  }

  private static int sum(int[] prices) {
    int sum = 0;
    for (int i = 0; i < prices.length; i++) {
      if ((i + 1) < prices.length && prices[i + 1] - prices[i] > 0) {
        sum += prices[i + 1] - prices[i];
      }
    }
    return sum;

  }

}
