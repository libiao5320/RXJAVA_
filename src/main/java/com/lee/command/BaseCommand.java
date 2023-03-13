package com.lee.command;

public interface BaseCommand<R> {

        void execute();
        <R> R call();

}
