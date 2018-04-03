问：简单谈谈你对 CAS 的认识和理解？
--
答：CAS（compare and swap）实质就是比较交换策略，设计并发算法时常用到的一种技术，java.util.concurrent 包基本都建立在 CAS 之上，现代的处理器基本都支持 CAS，只是不同厂商实现不同而已；
CAS 有内存值V、旧的预期值A、要修改的值B三个操作数，当且仅当预期值A和内存值V相同时才会将内存值修改为B并返回true，否则什么也不做且返回 false。

CAS 是通过 Unsafe 类来实现的，Unsafe 提供了硬件级别的原子操作，关于 CAS 的方法主要是 native 的 compareAndSwapObject、compareAndSwapInt、compareAndSwapLong，其比较交换是一组原子操作，因为是硬件级别的操作，所以效率会高一些。

CAS 最常见和基础的使用地方在 java.util.concurrent.atomic 包下面，譬如 AtomicInteger 使用 CAS 的实质如下（基于JDK 1.8之前，1.8开始已经再次优化了，看不见阻塞的逻辑了）：

```
public class AtomicInteger extends Number implements java.io.Serializable {
    //Unsafe 是 CAS 的核心类
    private static final sun.misc.Unsafe unsafe = sun.misc.Unsafe.getUnsafe();
    //valueOffset 在 static 代码块中通过 Unsafe 获取 value 变量在内存中的偏移地址。
    //因为 Unsafe 是通过 valueOffset 内存偏移地址来获取数据的原始值的。
    private static final long valueOffset;
    static { 
         //获取变量的偏移地址
         try{
             valueOffset = unsafe.objectFieldOffset(AtomicInteger.class.getDeclaredField("value"));    
         }catch(ReflectiveOperationException e){ 
             throw new Error(e);     
         }
    }  
    //volatile修饰保证了 value 变量的可见性和有序性
    private volatile int value;
        
    public final int incrementAndGet(){
        //原子更新成功为止才返回      
        for(;;){         
            int current = get();
            int next = current + 1;
            if(compareAndSet(current,next))
                return next;       
            }
        }
    }
}
```

可以发现基于 CAS 可以实现乐观的非阻塞算法的 Java atomic 原子变量，除此之外还可以实现悲观阻塞式算法，譬如锁机制等。
CAS 策略算法其实有个致命的 ABA 问题，如果一个变量 V 初次读取时值为 A，并且在准备赋值时检查到仍然是 A，而这时候又在多线程的场景下我们是无法确认这段时间之内是否值被其他线程先修改为 B 接着改回了 A，所以 CAS 就会在这种场景下误认为变量从来没被修改过，也就是 ABA 问题了，这个问题一般是没啥影响的，
如果程序逻辑需要处理 ABA 场景就可以使用 AtomicStampedReference，在修改值的同时传入一个唯一标记（譬如时间戳），只有值和标记都相等才进行修改，使用 AtomicMarkableReference 也可以，只不过标记是 boolean 类型。