package com.lee.test;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author
 * @create 2018-06-07 16:52
 **/
public class __TestFindNotIn {


  private static int[] ss = new int[]{
      1, 2, 3, 4, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30
  };
  static int _length = 15;
  static int _start = 13;

  public static void main(String[] args) {

    int[] sss = new int[]{2, 3, 4, 15, 16, 17, 20};
    int[] sss1 = new int[]{8, 9, 10};

    IntStream stream = Arrays.stream(ss);
    stream.filter(_s -> {

      boolean flag = true;

      if (_s > _start) {
        for (int i = 0; i < sss.length; i++) {
          if (_s == sss[i]) {
            flag = false;
            break;
          }
        }
        for (int i = 0; i < sss1.length; i++) {
          if (_s == sss1[i]) {
            flag = false;
            break;
          }
        }
      } else {
        flag = false;
      }

      return flag;

    }).map(dd -> {
      _length--;
      if (_length >= 0) {
        return dd;
      } else {
        return 0;
      }


    }).filter((_ii) -> _ii != 0).forEach(_oo -> System.out.println(_oo));


  }

}
