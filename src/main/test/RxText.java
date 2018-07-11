import com.lee.rx.ICommand;
import com.lee.rx.TestCommand;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import org.junit.Test;

import java.util.function.Function;

/**
 * Author :Lee
 * Since :2018/7/11下午10:24
 * Desc :RxText Do What ?
 */
public class RxText {


    @Test
    public void rxtest() {


        HystrixCommand hystrixCommand = new HystrixCommand(HystrixCommandGroupKey.Factory.asKey("test")) {
            @Override
            protected Object run() throws Exception {
                return null;
            }
        };


        Object _test = hystrixCommand.execute();
        System.out.println(_test);


        TestCommand<String,String> testCommand = new TestCommand((s)->{
            System.out.println(s);
            return s;
        });

        testCommand.buildParams("ww111w");
        String result = testCommand.execute();

    }


    private void printsome(String a)
    {
        System.out.println(a);
    }
}