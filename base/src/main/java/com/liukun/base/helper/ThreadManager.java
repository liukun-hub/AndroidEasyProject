package com.liukun.base.helper;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Author: liukun on 2020/7/29.
 * Mail  : 3266817262@qq.com
 * Description:  线程池管理  用到多线程的地方不要直接new Thread（）
 */
public class ThreadManager {

    private static ThreadPool sThreadPool;

    public static ThreadPool getThreadPool(int corePoolSize) {
        if (sThreadPool == null) {
            synchronized (ThreadManager.class) {
                if (sThreadPool == null) {
                    int count = Runtime.getRuntime().availableProcessors();
                    int maximumPoolSize = count + 1;
                    int corePoolSizeTemp = 0;
                    corePoolSizeTemp = Math.min(corePoolSize, maximumPoolSize);
                    sThreadPool = new ThreadPool(corePoolSizeTemp, maximumPoolSize);
                }
            }
        }
        return sThreadPool;
    }

    public static class ThreadPool {

        private int corePoolSize;
        private int maximumPoolSize;
        private long keepAliveTime;
        private BlockingQueue<Runnable> workQueue;
        private RejectedExecutionHandler handler;
        private ThreadPoolExecutor threadPoolExecutor;

        public ThreadPool(int corePoolSize, int maximumPoolSize) {
            this(corePoolSize, maximumPoolSize, 1L, null, null);
        }

        public ThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime,
                          BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
            this.corePoolSize = corePoolSize;
            this.maximumPoolSize = maximumPoolSize;
            this.keepAliveTime = keepAliveTime;
            this.workQueue = workQueue != null ? workQueue : new LinkedBlockingDeque<Runnable>();
            this.handler = handler != null ? handler : new ThreadPoolExecutor.DiscardOldestPolicy();
        }


        public void execute(Runnable runnable) {

            if (threadPoolExecutor == null) {
                threadPoolExecutor =
                        new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime,
                                TimeUnit.MILLISECONDS, workQueue, handler);

                threadPoolExecutor.execute(runnable);
            }
        }

        public void cancel(Runnable runnable) {
            if (threadPoolExecutor != null) {
                threadPoolExecutor.getQueue().remove(runnable);
            }
        }

    }

}
