package com.lee.rx;

/**
 * Author :Lee
 * Since :2018/7/11下午10:20
 * Desc :ICommand Do What ?
 */
public interface ICommand<R, W> {


    public abstract R execute();

}
