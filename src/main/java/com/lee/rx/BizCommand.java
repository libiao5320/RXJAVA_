package com.lee.rx;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * Author :Lee
 * Since :2018/7/11下午11:52
 * Desc :BizCommand Do What ?
 */
public class BizCommand extends HystrixCommand {

    private static final String groupName =  "test";
    private ICommand command;


    protected BizCommand(ICommand command) {

        super(HystrixCommandGroupKey.Factory.asKey(groupName));
        this.command = command;
    }

    @Override
    public Object run() throws Exception {
         return command.call();
//        return command.getResult();
    }


    @Override
    public Object getFallback(){
        return null;
    }


}