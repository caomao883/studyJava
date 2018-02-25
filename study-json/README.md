https://www.cnblogs.com/leeplogs/p/5891861.html

1、List（有序、可重复）
List里存放的对象是有序的，同时也是可以重复的，List关注的是索引，拥有一系列和索引相关的方法，查询速度快。因为往list集合里插入或删除数据时，会伴随着后面数据的移动，所有插入删除数据速度慢。
2、Set（无序、不能重复）
Set里存放的对象是无序，不能重复的，集合中的对象不按特定的方式排序，只是简单地把对象加入集合中。
3、Map（键值对、键唯一、值不唯一）
Map集合中存储的是键值对，键不能重复，值可以重复。根据键得到值，对map集合遍历时先得到键的set集合，对set集合进行遍历，得到相应的值。
http://blog.csdn.net/qq_25868207/article/details/55259978
底层数据结构
Collection
List：
ArrayList：可变数组
  1. ArrayList是List接口的可变数组非同步实现，并允许包括null在内的所有元素。
  2. 底层使用数组实现
  3. 该集合是可变长度数组，数组扩容时，会将老数组中的元素重新拷贝一份到新的数组中，每次数组容量增长大约是其容量的1.5倍，这种操作的代价很高。
  4. 采用了Fail-Fast机制，面对并发的修改时，迭代器很快就会完全失败，而不是冒着在将来某个不确定时间发生任意不确定行为的风险
  5. remove方法会让下标到数组末尾的元素向前移动一个单位，并把最后一位的值置空，方便GC
LinkedList：双向链表

Set:
AbstractSet
HashSet：哈希表
TreeSet：红黑树数
LinkedHashSe
Map
AbstractMap
HashMap：哈希表，数组实现，数组中每一项是个单向链表，即数组和链表的结合体；当链表长度大于一定阈值时，链表转换为红黑树
Hashtable：哈希表的Map接口的同步实现
TreeMap：红黑树数
ConcurrentHashMap：允许多个修改操作并发进行，其关键在于使用了锁分离技术
LinkedHashMap




ArrayList和LinkedList
五、ArrayList和LinkedList
ArrayList和LinkedList在用法上没有区别，但是在功能上还是有区别的。LinkedList经常用在增删操作较多而查询操作很少的情况下，ArrayList则相反。
六、Map集合
实现类：HashMap、Hashtable、LinkedHashMap和TreeMap
HashMap 
HashMap是最常用的Map，它根据键的HashCode值存储数据，根据键可以直接获取它的值，具有很快的访问速度，遍历时，取得数据的顺序是完全随机的。因为键对象不可以重复，所以HashMap最多只允许一条记录的键为Null，允许多条记录的值为Null，是非同步的
Hashtable
Hashtable与HashMap类似，是HashMap的线程安全版，它支持线程的同步，即任一时刻只有一个线程能写Hashtable，因此也导致了Hashtale在写入时会比较慢，它继承自Dictionary类，不同的是它不允许记录的键或者值为null，同时效率较低。
ConcurrentHashMap
线程安全，并且锁分离。ConcurrentHashMap内部使用段(Segment)来表示这些不同的部分，每个段其实就是一个小的hash table，它们有自己的锁。只要多个修改操作发生在不同的段上，它们就可以并发进行。
LinkedHashMap
LinkedHashMap保存了记录的插入顺序，在用Iteraor遍历LinkedHashMap时，先得到的记录肯定是先插入的，在遍历的时候会比HashMap慢，有HashMap的全部特性。
TreeMap
TreeMap实现SortMap接口，能够把它保存的记录根据键排序，默认是按键值的升序排序（自然顺序），也可以指定排序的比较器，当用Iterator遍历TreeMap时，得到的记录是排过序的。不允许key值为空，非同步的；