package lock.blockqueue;

import com.sun.crypto.provider.BlowfishKeyGenerator;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author Dongfanger
 * @date 2020/9/23
 */
public class BlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);
        //1. java.lang.IllegalStateException: Queue full  超出容量会抛出异常
        blockingQueue.add("A");
        blockingQueue.add("B");
        blockingQueue.add("C");
//        blockingQueue.add("D");
//        System.out.println(blockingQueue.element()); //校验第一分参数
//        System.out.println(blockingQueue.peek()); //校验第一分参数
//
//        blockingQueue.remove("A");
//        blockingQueue.remove("B");
//        blockingQueue.remove("C");
//        blockingQueue.remove("D");

        // 2.  不会返回异常，返回一个boolean值，取值为null
//        System.out.println(blockingQueue.offer("A"));
//        System.out.println(blockingQueue.offer("B"));
//        System.out.println(blockingQueue.offer("C"));
//        System.out.println(blockingQueue.offer("D", 3L, TimeUnit.SECONDS)); //3.  尝试等待3秒，就会失败！ 返回false
//
//        System.out.println("==========================");
//
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());

        //  4. 如果队列满了，一直等，并且阻塞请求
//        blockingQueue.put("A");
//        blockingQueue.put("B");
//        blockingQueue.put("C");
//        blockingQueue.put("D");  //队列满了，一直等，并且阻塞请求

        System.out.println("==========");

        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take()); //队列满了，一直等，并且阻塞请求


    }
}
