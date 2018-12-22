package com.lee.test;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.GetResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author
 * @create 2018-06-14 0:50
 **/
public class ConsumerMongoDbBake {


  public static void main(String[] args) {

    try {
      new Cosumer("Test",1000).work();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }


  static class Cosumer

  {

    private static final String QUEUE_NAME = "findAndModifyQueue";

    private String name;

    private int sleepTime;

    public Cosumer(String name, int sleepTime) {
      this.name = name;
      this.sleepTime = sleepTime;
    }

    public void work() throws Exception {
      ConnectionFactory factory = new ConnectionFactory();
      factory.setHost("192.168.100.6");
      factory.setUsername("zxin10");
      factory.setPassword("Zxin1#10");
      Connection connection = factory.newConnection();
      Channel channel = connection.createChannel();

      channel.queueDeclare(QUEUE_NAME, true, false, false, null);

//      Consumer consumer = new DefaultConsumer(channel) {
//        @Override
//        public void handleDelivery(String consumerTag, Envelope envelope,
//            AMQP.BasicProperties properties, byte[] body)
//            throws IOException {
//          String message = new String(body, "UTF-8");
//          System.out.printf(" [    %2$s<===](%1$s) %3$s\n", name, QUEUE_NAME, message);
//          try {
//            TimeUnit.MILLISECONDS.sleep(sleepTime);
//          } catch (InterruptedException e) {
//          }
//        }
//      };
      GetResponse getResponse = channel.basicGet(QUEUE_NAME, true);


      System.out.println(new String (getResponse.getBody(),"utf-8"));
    }
  }

}
