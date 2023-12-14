package com.lee.rx;

import java.text.SimpleDateFormat;

public class CommandExecute {
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:ms");

    public synchronized static <R> R execute(ICommand command)  {
        try {
            return (R) command.call();
//            return (R) command.getResult();
        }
        catch (Exception ex)
        {

        }
        return null;
    }

}
