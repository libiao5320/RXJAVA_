package com.lee.rx;

import java.util.function.Function;

/**
 * Author :Lee
 * Since :2018/7/11下午11:37
 * Desc :TestCommand Do What ?
 */
public  class TestCommand<R, W> implements ICommand<R, W> {


    private Function<W, R> function;
    private W w ;

    public TestCommand(Function function) {
        this.function = function;
    }


    public TestCommand buildParams( W w )
    {
        this.w  = w;
        return TestCommand.this;
    }

    @Override
    public R execute() {

        return function.apply(w);
    }
}