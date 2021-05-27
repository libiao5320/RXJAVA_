package com.lee.test;


public class TestFindAlert {





  public static void main(String [] args )
  {

      String s = "湖南省衡阳市衡南噢噢噢哦哦陌陌现在收13786354682";

      String ss = "";


      String[] arr = ss.split("\\|");


      for( int i = 0 ; i < arr.length ;i++)
      {


          if (s.contains(arr[i]) )
          {
            System.out.println("找到敏感词" + arr[i]);
          }



      }



  }
}
