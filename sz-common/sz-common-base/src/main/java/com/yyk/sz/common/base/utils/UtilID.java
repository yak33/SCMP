package com.yyk.sz.common.base.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by xujiashuai on 2016/9/7.
 *
 * 可以做到单机每秒并发100万，如果部署到多台机器，一定要设置server的id！
 */
public class UtilID {
    /**
     * 序列号
     */
    private static final AtomicInteger UNIQUE_ID = new AtomicInteger(0);
    /**
     * 1毫秒以内最大的并发数 = 序列号的最大值
     */
    private static final int MAX_ID = 999;
    /**
     * 随机
     */
    private static final Random RND = new Random();

    public enum Biz{
        Order(1, "订单"),
        PAY_SN(2, "支付业务中的流水号");
        private int biz;
        private String desc;
        private Biz(int biz, String desc){
            this.biz = biz;
            this.desc = desc;
        }
        public int getBiz(){
            return this.biz;
        }
    }

    public static String getPaySN(int server){
        return getId(Biz.PAY_SN, server);
    }

    public static String getOrderId(int server){
        return getId(Biz.Order, server);
    }

    private static String getId(Biz biz, int server) {
        String datestr = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());//毫秒数
        String bizStr = String.format("%02d", biz.getBiz());//业务线，99
        String serverStr = String.format("%03d", server);   //机器号，3位
        String concurrent = String.format("%03d", getSN()); //毫秒内的并发 ，3位
        String rnd = UtilRandom.randomNumberString(4);      //随机，没有任何意义
        return datestr+bizStr+serverStr+concurrent+rnd;
    }

    private static int getSN() {
        int num = UNIQUE_ID.incrementAndGet();
        if (num == MAX_ID) {
            num = RND.nextInt(10);
            UNIQUE_ID.set(num);
        }
        return num;
    }

    public static int concurrentTest(int threadCount)throws Exception{
        long start = System.currentTimeMillis();
        final ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>();
        final CountDownLatch endLatch = new CountDownLatch(threadCount);
        final CountDownLatch startLatch = new CountDownLatch(1);
        Thread[] arr = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            arr[i] = new Thread(new Runnable() {
                public void run() {
                    try {
                        startLatch.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    String num = getOrderId(1);
                    //System.out.println(num);
                    map.put(num, num);
                    endLatch.countDown();
                }
            });
        }
        for (int i = 0; i < threadCount; i++) {
            arr[i].start();
        }
        startLatch.countDown();
        endLatch.await();
        System.out.println(map.size());
        long end = System.currentTimeMillis();
        System.out.println("use:" + (end - start));
        return map.size();
    }

    public static void main2(String[] args) throws Exception {
//        int num = 0;
//        for(int i=0; i<100; i++){//跑100次
//            int result = concurrentTest(10000);
//            if(result == 10000){
//                num ++;
//            }
//        }
//        System.out.println(num);
        System.out.println(getPaySN(1));
    }
}
