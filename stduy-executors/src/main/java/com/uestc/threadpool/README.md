
https://www.cnblogs.com/waytobestcoder/p/5323130.html


new ThreadPoolExecutor(2, 4, 3,TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3),new ThreadPoolExecutor.DiscardOldestPolicy())


第一个2：corePoolSize表示并行数
第二个2：最大并行数，如果队列满了以后，并行数变大来加快消费

第三个：表示时间，和第四个连用，第四个表示时间单元

当线程空闲时间达到keepAliveTime时，线程会退出，直到线程数量=corePoolSize
如果allowCoreThreadTimeout=true，则会直到线程数量=0

第五个：队列大小
第六个：rejectedExecutionHandler：任务拒绝处理器

第六个有这种类型

ThreadPoolExecutor类有几个内部实现类来处理这类情况：
AbortPolicy 丢弃任务，抛运行时异常
CallerRunsPolicy 执行任务
DiscardPolicy 忽视，什么都不会发生
DiscardOldestPolicy 从队列中踢出最先进入队列（最后一个执行）的任务