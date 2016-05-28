//经过极大优化后的单例模式
//考虑多种情况，如多线程访问、锁定问题、性能问题等后得到的程序
public class Singleton2 {  
  
    /* 私有构造方法，防止被实例化 */  
    private Singleton2() {  
    }  
  
    /* 此处使用一个内部类来维护单例，解决了多线程访问带来的锁定问题，又能满足性能需求 */  
    private static class SingletonFactory {  
        private static Singleton2 instance = new Singleton2();  
    }  
  
    /* 关键：创建单例，获取实例对象 */  
    public static Singleton2 getInstance() {  
        return SingletonFactory.instance;  
    }  
  
    /* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */  
    public Object readResolve() {  
        return getInstance();  
    }  
}