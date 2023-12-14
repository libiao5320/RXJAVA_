package com.lee.rx;

/**
 * Author :Lee
 * Since :2018/7/11下午11:37
 * Desc :TestCommand Do What ?
 */
public  class TestCommand implements ICommand {
    @Override
    public Object call() throws Exception {
        return null;
    }

//
//    private Function<W, R> function;
//    private W w ;
//
//    public TestCommand(Function function) {
//        this.function = function;
//    }
//
//
//    public TestCommand buildParams( W w )
//    {
//        this.w  = w;
//        return TestCommand.this;
//    }
//
//    @Override
//    public R execute() {
//
//        return function.apply(w);
//    }
}