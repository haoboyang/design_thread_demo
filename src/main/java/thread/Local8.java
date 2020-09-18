package thread;

import java.util.concurrent.TimeUnit;

/**
 * @author Dongfanger
 * @date 2020/9/18
 */
public class Local8 {
    public static void main(String[] args) {
        Animal animal = new Animal();
        new Thread(() ->{
            try {
                animal.call();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();
        new Thread(() -> {
            animal.run();
        }, "B").start();
    }
}

class Animal {
    public synchronized void call() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        System.out.println(Thread.currentThread().getName() + "\t" + "CALL");
    }

    public static synchronized void run() {
        // 类方法最先执行，不按照顺序执行
        System.out.println(Thread.currentThread().getName() + "\t" + "RUN");
    }
}
