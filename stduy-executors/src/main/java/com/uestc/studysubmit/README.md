1.主线程卡
submit主线程有时候卡顿，是因为调用了线程的join
调用exec.submit(aCallable).get();（返回线程结果）可能会主塞主线程

2.
