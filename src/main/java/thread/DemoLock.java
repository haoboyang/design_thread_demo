package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Dongfanger
 * @date 2020/9/18
 */
public class DemoLock {
    public static void main(String[] args) {
        Data2 data2 = new Data2();

        new Thread(() -> {
            for (int i = 1; i <=5 ; i++) {
                data2.print5();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 1; i <= 10 ; i++) {
                data2.print10();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 1; i <=15 ; i++) {
                data2.print15();
            }
        }, "C").start();
    }
}

class Data2 {
    private final Lock lock = new ReentrantLock();
    private int number = 1;
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void print5() {
        lock.lock();
        try {
            while (number != 1) {
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            number = 2;
            condition2.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10() {
        lock.lock();
        try {
            while (number != 2) {
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            number = 3;
            condition3.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15() {
        lock.lock();
        try {
            while (number != 3) {
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            number = 1;
            condition1.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
