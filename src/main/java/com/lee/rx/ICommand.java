package com.lee.rx;

import java.util.concurrent.Callable;

/**
 * Author :Lee
 * Since :2018/7/11下午10:20
 * Desc :ICommand Do What ?
 */
@FunctionalInterface
public interface ICommand<T> extends Callable<T> {

     Object result = null;

     default
     <R> R getResult(){

        return (R) result;
    }



}
