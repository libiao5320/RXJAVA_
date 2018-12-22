package com.lee.leetcode;

/**
 * Author :Lee
 * Since :2018/12/10下午4:05
 * Desc :BitOperation Do What ?
 */
public class BitOperation {


    private static int yihuo(int p1, int p2) {

        return p1 ^ p2;
    }


    public static void main(String[] args) {



        int a = 5;
        int b = 6;

        a = yihuo(a,b);


        System.out.println(a);
        b = yihuo(a,b);

        System.out.println(b);
        a = yihuo(a,b);

        System.out.println(a);

        System.out.println(Integer.parseInt("10100111",2));
        System.out.println(yihuo(10, 6));

        System.out.println(a);

        System.out.println(b);


        String binaryString =Integer.toBinaryString(5) ;



        System.out.println(binaryString);
    }

}