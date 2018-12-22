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
//
//     boolean flag = Pattern.compile("pcc/rest/sns/dynamic4portal/queryDynamicList/[0-9]/[0-9]").matcher("/pcc/rest/sns/dynamic4portal/queryDynamicList/9/0").find();
//
//     boolean _flag = Pattern.compile("pcc/rest/sns/profile/uploadAvatar").matcher("/pcc/rest/sns/profile/uploadAvatar/").find();
//     System.out.println(_flag);

//    Predicate.isEqual()


      System.out.println(unescape("\\u514d\\u8d39"));
  }


    public static String escape(String src) {
        int i;
        char j;
        StringBuffer tmp = new StringBuffer();
        tmp.ensureCapacity(src.length() * 6);
        for (i = 0; i < src.length(); i++) {
            j = src.charAt(i);
            if (Character.isDigit(j) || Character.isLowerCase(j)
                    || Character.isUpperCase(j))
                tmp.append(j);
            else if (j < 256) {
                tmp.append("%");
                if (j < 16)
                    tmp.append("0");
                tmp.append(Integer.toString(j, 16));
            } else {
                tmp.append("%u");
                tmp.append(Integer.toString(j, 16));
            }
        }
        return tmp.toString();
    }

    public static String unescape(String src) {
        StringBuffer tmp = new StringBuffer();
        tmp.ensureCapacity(src.length());
        int lastPos = 0, pos = 0;
        char ch;
        while (lastPos < src.length()) {
            pos = src.indexOf("%", lastPos);
            if (pos == lastPos) {
                if (src.charAt(pos + 1) == 'u') {
                    ch = (char) Integer.parseInt(src
                            .substring(pos + 2, pos + 6), 16);
                    tmp.append(ch);
                    lastPos = pos + 6;
                } else {
                    ch = (char) Integer.parseInt(src
                            .substring(pos + 1, pos + 3), 16);
                    tmp.append(ch);
                    lastPos = pos + 3;
                }
            } else {
                if (pos == -1) {
                    tmp.append(src.substring(lastPos));
                    lastPos = src.length();
                } else {
                    tmp.append(src.substring(lastPos, pos));
                    lastPos = pos;
                }
            }
        }
        return tmp.toString();
    }
}
