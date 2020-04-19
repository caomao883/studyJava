学习网站wait和notify
http://www.importnew.com/21089.html
wait当前线程暂停，直到wait的对象调用notify或者notifyAll

 notify()和notifyAll()的区别：
 notify随机唤醒单个线程
 notifyAll唤醒所有线程。
 
 wait 和notify,notifyall 必须放在synchroized里面，否则会抛Exception