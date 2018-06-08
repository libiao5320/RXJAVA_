package com.lee.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jdk.nashorn.internal.runtime.regexp.RegExp;
import jdk.nashorn.internal.runtime.regexp.RegExpMatcher;

/**
 * @author
 * @create 2018-05-09 9:24
 **/
public class StaticInfoTest {


    public static void main(String [] args)
    {

        String  s = "channelid=28020001&uuid=5AA755F3-B995-4B7B-9A85-A49405D1F7F3&clientpage=1060&osversion=iOS11.3.1&clientallid=000000100000000000283.5.4&userid=91384842460&usercode=18608404880&isfreeLimt=0";

//        List l = Arrays.asList(s.split("&"));
//
//        JSONObject jsonObject = (JSONObject) JSON.parse(l.toString());
//
//        System.out.println(jsonObject.toString());

        Pattern pattern = Pattern.compile("&userid=(.*?)&");

        Matcher matcher  = pattern.matcher(s) ;
        if(matcher.find()) {
          System.out.println(matcher.group(1));
        }


    }

}
