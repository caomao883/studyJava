1.lock.lock()后，其他线程会在这里阻塞掉
2.lock.lock后不会自动释放，必须手动在finally lock.unlock();释放，否则会死锁
3.lock是对象