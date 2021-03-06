import com.lee.test.MyHystrixCommand;
import com.lee.test._TESTGETTOMCATINFO;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.Test;
import rx.Observable;
import rx.Observer;


/**
 * @author
 * @create 2018-06-08 16:32
 **/


public class TestCenter {


  @Test
  public void test_1() {

    Observable observable = new MyHystrixCommand(HystrixCommandGroupKey.Factory.asKey("www")).observe();

    Future ff = new MyHystrixCommand(HystrixCommandGroupKey.Factory.asKey("www")).observe().toBlocking().toFuture();


//     HystrixCommand hystrixCommand = new HystrixCommand(HystrixCommandGroupKey.Factory.asKey("www"),5000) {
//       @Override
//       protected Object run() throws Exception {
//
//
//         Thread.currentThread().sleep(2000);
//         return ""+ _TESTGETTOMCATINFO.getTomcatPort();
//       }
//     };


//     System.out.println(hystrixCommand.execute());


//    try {
//      Thread.sleep(3000);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }




//    final List s = new ArrayList();
//    observable.subscribe(new Observer() {
//      @Override
//      public void onCompleted() {
//        System.out.println("***********************" + s);
//      }
//      @Override
//      public void onError(Throwable throwable) {
//        System.out.println(throwable.getMessage());
//      }
//
//      @Override
//      public void onNext(Object o) {
//        s.add(o);
////        System.out.println(10 / 0);
//      }
//    });
//

    try {

      Thread.currentThread().sleep(2000);
      System.out.println(" ----------" + ff.get());

    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    }
  }

}
