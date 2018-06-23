# springboot-personalLearn
springboot个人学习测试小demo

下载下来之后把  根目录下的.idea和.mvn/wrapper删除.
第一次使用git,仅供尝试使用下github和记录一下




下面是多线程情况下i++ 保证原子操作的解决方案伪代码，主要使用AtomicInteger的原子加，原子减。(csdn账号密码忘了 就先在此记录一下)
 public class IncTest {
    private volatile static AtomicInteger i=new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread() {
            @Override
            public void run() {
                for( int j = 0 ; j < 100000 ; j++ ) i.incrementAndGet();
            }
        };
        a.start();
        Thread b = new Thread() {
            @Override
            public void run() {
                for( int j = 0 ; j < 100000 ; j++ ) i.decrementAndGet();
            }
        };
        b.start();
        a.join();
        b.join();
        System.out.println(i);
    }
}

1、volatile只能保证多线程情况下变量的可见性，不能保证原子操作
2、不能使用synchronized等锁操作，这样会变得很慢，不符合多线程应用环境




