package com.lee.rx;

import java.util.function.Supplier;

public class LambadaTest {

    public static void main(String[] args) {
        Supplier supplier = new Supplier() {
            @Override
            public Object get() {
                return null;
            }
        };

        System.out.println(supplier.get());
    }
}
