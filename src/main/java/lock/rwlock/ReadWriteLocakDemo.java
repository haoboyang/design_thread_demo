package lock.rwlock;

import java.util.HashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Dongfanger
 * @date 2020/9/21
 */
public class ReadWriteLocakDemo {


    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 1; i < 30; i++) {
            final int tempId = i;
            new Thread(() -> {
                myCache.write(String.valueOf(tempId));
            }, String.valueOf(tempId)).start();
        }

        for (int i = 1; i < 30; i++) {
            final int tempId = i;
            new Thread(() -> {
                myCache.read(String.valueOf(tempId));
            }, String.valueOf(tempId)).start();

        }
    }

}

class MyCache {
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private volatile HashMap<String, Object> map = new HashMap<>();


    //  read
    public void read(String key) {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "-- key = " + key );
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName() + "-- value = " + o);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    // write
    public void write(String key) {
        readWriteLock.writeLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + "开始写入" + key);
            map.put(key, key);
            System.out.println(Thread.currentThread().getName() + " --ok");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }
}


