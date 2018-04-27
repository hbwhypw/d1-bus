package test.com.tmtc.util;

import com.tmtc.utils.IdWorker;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * Creater: hbwhypw
 * Date: 2015/9/18 11:46
 * Function:
 */
public class IdWorkerTest {

    StringBuilder sb = new StringBuilder();

    public static void main(String []args){
        IdWorkerTest test = new IdWorkerTest();
        test.test2();
    }

    public void test2(){
//        final IdWorker w = new IdWorker(10,2);
//        final CyclicBarrier cdl = new CyclicBarrier(100);
//
//
//
//
//        for(int i = 0; i < 1000; i++){
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
////                    try {
//////                        cdl.await();
////                    } catch (InterruptedException e) {
////                        e.printStackTrace();
////                    } catch (BrokenBarrierException e) {
////                        e.printStackTrace();
////                    }
//                    System.out.println(w.nextId());
//
////                    sb.append(w.nextId()+"\n");
//
//                }
//            }).start();
//        }
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }
}
