//经过极大优化后的比Singleton2的实现更简易，但效果也较好的单例模式
public class Singleton3 {  
  
    private static Singleton3 instance = null;  
  
    private Singleton3() {  
    }  
  
  	//解决锁定问题，性能也能满足需求
    private static synchronized void syncInit() {  
        if (instance == null) {  
            instance = new Singleton3();  
        }  
    }  
  
  	//创建单例
    public static Singleton3 getInstance() {  
        if (instance == null) {  
            syncInit();  
        }  
        return instance;  
    }  
}