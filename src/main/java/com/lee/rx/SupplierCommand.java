package com.lee.rx;

import java.util.function.Supplier;


public class SupplierCommand implements ICommand {

    private Supplier supplier;

    public SupplierCommand(Supplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public Object call() throws Exception {
        return supplier.get();
    }

//    @Override
//    public <R> R execute() {
//        return Optional.ofNullable((R) supplier.get()).orElse(null);
//    }

//    @Override
//    public void run() {
//
//    }
}
