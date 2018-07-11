package com.lee.test;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * @author
 * @create 2018-06-08 16:30
 **/
public class MyHystrixCommand extends HystrixCommand<String> {




  public MyHystrixCommand(HystrixCommandGroupKey group) {
    super(group,1000);
  }

  @Override
  protected String run() throws Exception {

    return ""+_TESTGETTOMCATINFO.getTomcatPort();

  }

  protected String getFallback() {
    return "Fall back";
  }

}
