package com.lee.test;

import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

/**
 * @author
 * @create 2018-05-17 14:09
 **/
public class ArrayToListTest {



  public static void main(String [] args)
  {
//    List filterContentIndexList = new ArrayList();
//    Collections.addAll(filterContentIndexList, new String [] {"a","b","c"});
//
//    System.out.println(String.format("result is %s",filterContentIndexList.toString()));

     boolean flag = Pattern.compile("pcc/rest/sns/dynamic4portal/queryDynamicList/[0-9]/[0-9]").matcher("/pcc/rest/sns/dynamic4portal/queryDynamicList/9/0").find();

     boolean _flag = Pattern.compile("pcc/rest/sns/profile/uploadAvatar").matcher("/pcc/rest/sns/profile/uploadAvatar/").find();
     System.out.println(_flag);

//    Predicate.isEqual()
  }
}
