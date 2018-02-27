
https://www.cnblogs.com/waytobestcoder/p/5323130.html


http://blog.csdn.net/qq_25806863/article/details/71126867

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


三种构造函数
ThreadPoolExecutor(int corePoolSize,
                        int maximumPoolSize,
                        long keepAliveTime,
                        TimeUnit unit,
                        BlockingQueue<Runnable> workQueue)

ThreadPoolExecutor(int corePoolSize,
                        int maximumPoolSize,
                        long keepAliveTime,
                        TimeUnit unit,
                        BlockingQueue<Runnable> workQueue,
                        ThreadFactory threadFactory)

ThreadPoolExecutor(int corePoolSize,
                        int maximumPoolSize,
                        long keepAliveTime,
                        TimeUnit unit,
                        BlockingQueue<Runnable> workQueue,
                        RejectedExecutionHandler handler)

ThreadPoolExecutor(int corePoolSize,
                        int maximumPoolSize,
                        long keepAliveTime,
                        TimeUnit unit,
                        BlockingQueue<Runnable> workQueue,
                        ThreadFactory threadFactory,
                        RejectedExecutionHandler handler)

下面都假设任务队列没有大小限制：

如果线程数量<=核心线程数量，那么直接启动一个核心线程来执行任务，不会放入队列中。
如果线程数量>核心线程数，但<=最大线程数，并且任务队列是LinkedBlockingDeque的时候，超过核心线程数量的任务会放在任务队列中排队。
如果线程数量>核心线程数，但<=最大线程数，并且任务队列是SynchronousQueue的时候，线程池会创建新线程执行任务，这些任务也不会被放在任务队列中。这些线程属于非核心线程，在任务完成后，闲置时间达到了超时时间就会被清除。
如果线程数量>核心线程数，并且>最大线程数，当任务队列是LinkedBlockingDeque，会将超过核心线程的任务放在任务队列中排队。也就是当任务队列是LinkedBlockingDeque并且没有大小限制时，线程池的最大线程数设置是无效的，他的线程数最多不会超过核心线程数。
如果线程数量>核心线程数，并且>最大线程数，当任务队列是SynchronousQueue的时候，会因为线程池拒绝添加任务而抛出异常。
任务队列大小有限时

当LinkedBlockingDeque塞满时，新增的任务会直接创建新线程来执行，当创建的线程数量超过最大线程数量时会抛异常。
SynchronousQueue没有数量限制。因为他根本不保持这些任务，而是直接交给线程池去执行。当任务数量超过最大线程数时会直接抛异常。