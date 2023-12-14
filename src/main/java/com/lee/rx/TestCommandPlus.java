package com.lee.rx;

public class TestCommandPlus {

        public static void main(String[] args) {
//            String result = new SupplierCommand(() -> {
//                return "1";
//            }).execute();
//            System.out.println(result);
//
           String ss =  CommandExecute.execute(()->{
//                return "1";
                System.out.println("aaaa");
                return "ssss";
            });
            System.out.println(ss);
        }


}
