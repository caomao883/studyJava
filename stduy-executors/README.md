
invokeAll方法学习
com.uestc.executors

submit
com.uestc.studysumit


notify,wait,join
com.uestc.wait

submit 和invokeAll区别
submit参数使一个Callable
invokeAll是多个
关于具体看里面的README.md


ExecutorService中submit和execute的区别有三点：
1、接收的参数不同
2、submit有返回值，而execute没有
用到返回值的例子，比如说应用中有很多个做validation的task，用户希望所有的task执行完，然后每个task告诉主程序执行结果，是成功还是失败，如果是失败，原因是什么。然后就可以把所有失败的原因综合起来发给调用者。
3、submit方便Exception处理，而execute处理异常比较麻烦。


ThreadPoolExecutor
com.uestc.threadpool



