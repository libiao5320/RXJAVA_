package com.lee.test;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestLambdaSortGroup {

    public static void main(String[] args) {

        A  a1 = new A(5,"a");
        A  a2= new A(1,"a");
        A  a3 = new A(4,"a");


        A  a4 = new A(1,"b");
        A  a5 = new A(2,"b");

        List<A> list = Arrays.asList(a1,a2,a3,a4,a5);

        Map<String, List<A>> groupByReportNoMap = list.stream().sorted(
                Comparator.comparing(A::getIndex)).collect(Collectors.groupingBy(A::getName));
        List l = Lists.reverse(groupByReportNoMap.get("a"));
//        System.out.println(Lists.reverse(l));
        groupByReportNoMap.values().stream().map(Lists::reverse);
        System.out.println(groupByReportNoMap);
    }


    static class A {
        A(Integer index,String name)
        {
            this.index = index;
            this.name = name;
        }
        Integer index;
        String name;

        public Integer getIndex() {
            return index;
        }

        public void setIndex(Integer index) {
            this.index = index;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
