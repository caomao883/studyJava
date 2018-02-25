ExecutorService executors =  Executors.newFixedThreadPool(3);
List<MyTask> tasks = new ArrayList<MyTask>(); //MyTask实现了Callable<Integer>接口的实现类,call方法的返回类型为Integer
List<Future<Integer>> futures= new ArrayList<Future<Integer>>(); //call返回的Integer类型根据tasks进入的顺序返回
futures = executors.invokeAll(tasks,5L,TimeUnit.SECONDS);

超过5秒，提前结束

添加了返回结果类型，并且invokeAll没有执行完，主线程也不会走了