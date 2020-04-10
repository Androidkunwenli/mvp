package com.zyk.baselibrary.manager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: KK
 * @时间: 2020/4/10 9:21
 * @描述: 线程池
 */
public class ThreadPoolManager {
    private static final ThreadPoolManager S_THREAD_POOL_MANAGER = new ThreadPoolManager();
    private ExecutorService mThreadPool;

    private ThreadPoolManager() {
        int coreNum = Runtime.getRuntime().availableProcessors();
        mThreadPool = Executors.newFixedThreadPool(coreNum);
    }

    public static ThreadPoolManager getInstance() {
        return S_THREAD_POOL_MANAGER;
    }

    /*
     * 向线程池中添加任务方法
     */
    public void submit(Runnable task) {
        mThreadPool.execute(task);
    }

    /*
     * 关闭线程池，不在接受新的任务，会把已接受的任务执行玩
     */
    public void shutdown() {
        mThreadPool.shutdown();
    }
}
