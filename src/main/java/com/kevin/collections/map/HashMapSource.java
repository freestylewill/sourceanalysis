package com.kevin.collections;

/**
 * @author caonanqing
 * @version 1.0
 * @description     HashMap源码分析
 * @createDate 2019/12/2
 */
public class HashMapSource {

    /**
     *
     * HashMap采用key/value存储结构，每个key对应唯一的value，查询和修改的速度都很快，能达到O(1)的平均时间复杂度。
     * 它是非线程安全的，且不保证元素存储的顺序；
     * 在Java中，HashMap的实现采用了（数组 + 链表 + 红黑树）的复杂结构，数组的一个元素又称作桶。
     *
     * 1、HashMap是一种散列表，采用（数组+链表+红黑树）的存储结构。
     * 2、HashMap的默认初始容量为16（1<<4），默认装载因子为0.75f，容量总是2的n次方；
     * 3、HashMap扩容时每次容量变为原来的两倍；
     * 4、当桶的数量小于64时不会进行树化，只会扩容；
     * 5、当桶的数量大于64且单个桶中元素的数量大于8时，进行树化；
     * 6、当单个桶中元素数量小于6时，进行反树化；
     * 7、HashMap是非线程安全的容器；
     * 8、HashMap查找添加元素的时间复杂度都为O(1)；
     *
     * 红黑树具备以下5种性质：
     * 1、节点是红色或黑色。
     * 2、根节点是黑色。
     * 3、每个叶节点（NIL节点、空节点）是黑色的。
     * 4、每个红色节点的两个子节点都是黑色。（从每个叶子到根的所有路径上都不能有两个连续的红色节点）。
     * 5、从任一节点到其每个叶子的所有路径都包含相同数目的黑色节点。
     *
     * 红黑树的使劲复杂度为O(log n)，与树的高度成正比。
     * 红黑树每次的插入、删除操作都需要做平衡，平衡时有可能会改变根节点的位置，颜色转换，左旋，右旋等。
     *
     * put()
     *     计算key的hash值，如果桶的数据量是0，则初始化桶，如果key所在的桶没有元素，则直接插入，
     *     如果第一个元素是树节点，则调用树节点的方式插入元素，否则，遍历桶对应的链表查找key是否存在链表中，
     *     找到对应的key，则判断是否需要替换旧值，并且返回旧值。如果没有找到对应的key，需要在链表的最后插入一个新节点并判断是否需要树化。
     *
     * get()
     *     计算key的hash值，找到key所在的桶以及第一个元素，如果第一个是则直接返回，如果第一个元素是树节点，则以树的方式查找，否则以链表的方式查找。
     *
     * remove()
     *      先查找元素所在节点，如果找到的节点是树节点，则按树的移除节点处理，如果找到的节点是桶的第一个节点，则把第二个节点移到第一的位置，否则按链表删除节点处理，修改size，调用移除节点后置处理等。
     *
     * resize()
     *     如果使用的是默认构造器，则第一次插入元素时初始化默认值， 容量为16，扩容门槛为12
     *     如果使用非默认构造器，则第一次插入元素时初始化容量等于扩容门槛，扩容门槛在构造方法中等于传入容量向上最近的2的n次方
     *     如果旧容量大于0，则新容量等于旧容量的2倍，但不超过最大容量2的30次方，新扩容门槛的2倍
     *     创建一个新的容量的桶，搬移元素，原链表分化成两个链表，低位链表存储在原来桶的位置，高位链表搬移到原来桶的位置加旧容量的位置。
     *
     * 存储结构：数组+链表+红黑树
     *
     */

}