package com.man1s.algorithm;

import org.apache.rocketmq.common.ThreadFactoryImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

public class StackContoller {
    public static void main(String[] args) {
        ThreadFactory factory = new ThreadFactoryImpl("");
        Executor executor  = new ScheduledThreadPoolExecutor(100);
        StackThread stackThread = new StackThread();
        for (int i = 0; i <3 ; i++) {
            stackThread = new StackThread();
            executor.execute(stackThread);
        }
        stackThread.interrupt();

    }

}
class  StackThread  extends   Thread{
    @Override
    public void run() {
        while (true){
            if (Thread.currentThread().isInterrupted()){
                break;
            }
            System.currentTimeMillis();
        }
    }
}
