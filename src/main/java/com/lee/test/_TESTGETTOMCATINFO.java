package com.lee.test;

import java.lang.management.ManagementFactory;
import java.util.Set;
import java.util.function.Predicate;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.Query;

/**
 * @author
 * @create 2018-05-24 15:12
 **/
public class _TESTGETTOMCATINFO {

  public static void main(String [] args )
  {
    try {
      System.out.println(getTomcatPort());
    } catch (MalformedObjectNameException e) {
      e.printStackTrace();
    }
  }



  public static int getTomcatPort() throws MalformedObjectNameException, NullPointerException {
    String port = null;
    MBeanServer beanServer = ManagementFactory.getPlatformMBeanServer();
    Set<ObjectName> objectNames = beanServer.queryNames(new ObjectName("*:type=Connector,*"),
        Query.match(Query.attr("protocol"), Query.value("HTTP/1.1")));
    if ( null != objectNames && objectNames.size() > 0 )
      port= objectNames.iterator().next().getKeyProperty("port");

    return null == port ? Integer.valueOf(0):Integer.valueOf(port);
  }

}
