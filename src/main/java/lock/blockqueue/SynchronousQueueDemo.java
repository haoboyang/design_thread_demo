package lock.blockqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author Dongfanger
 * @date 2020/9/23
 */
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();

        // A 存
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "put a");
                blockingQueue.put("a");

                System.out.println(Thread.currentThread().getName() + "put b");
                blockingQueue.put("b");

                System.out.println(Thread.currentThread().getName() + "put c");
                blockingQueue.put("c");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, "A").start();

        // B 取
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + blockingQueue.take());

                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + blockingQueue.take());

                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();
    }
}
