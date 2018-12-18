package com.lee.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.lang.ArrayUtils;

/**
 * @author
 * @create 2018-12-17 11:11
 **/
public class TestCollectionAddOne {


  public static void main(String[] args) {
    int[] arr = new int[]{9,9};

    int[] result = plusOne(arr);
    for (int i = 0; i < result.length; i++) {
      System.out.println(result[i]);
    }
  }

  /**
   * 方法概述： 循环数组 i == digits.length -1 从数组最后一位开始+1 如果最后一位等于9，则向上进1 (jump = 1) 如果jump = 1 则 +1 否则 jump
   * = 0 循环到最后如果该下标 = 9 并且要 进1 ,则扩容数组 变成 1,0
   */
  public static int[] plusOne(int[] digits) {

    int jump = 0;
    for (int i = digits.length -1; i >= 0; i--) {

      if (digits.length > 1) {
        if (i == digits.length -1) {

          if ((digits[i] + 1) > 9) {
            digits[i] = 0;
            jump = 1;
            continue;
          } else {
            digits[i] += 1;
            jump = 0;
          }
        }

        if (jump == 1) {
//           else if (i == 0 && jump == 1) {

          if ((digits[i] + 1) > 9) {
            if (i == 0) {
              digits[i] = digits[i] + 1;
              String ss = String.valueOf(digits[i]);

              char[] chars = ss.toCharArray();

              if (chars.length > 1) {
                digits = Arrays.copyOf(digits, digits.length + chars.length - 1);
              }

              for (int j = 0; j < chars.length; j++) {
                digits[i + j] = Integer.valueOf(String.valueOf(chars[j]));
              }
            } else {
              digits[i] = 0;
              jump = 1;
            }
          } else {
            digits[i] = digits[i] + 1;
            jump = 0;
          }

        }

      } else {
        if ((digits[0] + 1) > 9) {
          digits[0] = digits[0] + 1;
          String ss = String.valueOf(digits[0]);

          char[] chars = ss.toCharArray();

          if (chars.length > 1) {
            digits = Arrays.copyOf(digits, digits.length + 1);
          }

          for (int j = 0; j < chars.length; j++) {
            digits[0 + j] = Integer.valueOf(String.valueOf(chars[j]));
          }
        } else {
          digits[0] = digits[0] + 1;
          jump = 0;
        }
      }

    }
    return digits;
  }


}
