package lock.concurrent;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Dongfanger
 * @date 2020/9/19
 */
public class ConcurrentList {
    public static void main(String[] args) {
//        concurrnetList();
        System.out.println(1<<4);
//        concurrentSet();
        concurrnetMap();
    }

    public static void concurrnetList() {
        //
        // ConcurrentModificationException new ArrayList 线程不安全会发生的异常
        // Arrays  Conllections  工具类
        // 1、 List<String> list = new Vector<>();
        // 2、 List<String> list = Collections.synchronizedList(new ArrayList<>());
        // 3、 List<String> list = new CopyOnWriteArrayList<>();
        //  copyonwirte  写入时复制，指针移动至最新位置
        //
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 1; i <=30; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0, 3));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }

    public static void concurrentSet() {
    // HashSet 底层实现是HashMap
//        Set<String> set = new CopyOnWriteArraySet<>();
        Set<String> set = Collections.synchronizedSet(new HashSet<>());
        for (int i = 1; i <=30 ; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 3));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }

    public static void concurrnetMap() {

        //  数据结构，链表转红黑树
        // 加载因子0.75f，容量 16
//        HashMap<String, String> map = new HashMap<>();
        Map<String, String> map = new ConcurrentHashMap<>();
        for (int i = 1; i <=31 ; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 3));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }

}
