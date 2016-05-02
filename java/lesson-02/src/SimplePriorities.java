/**
 * Created by crazyacking on 16-5-2.
 */
public class SimplePriorities extends Thread { // 继承了Thread类
    private int countDown=5;// 每个线程最多输出5次
    private volatile double d=0; // 设置为volatile，确保不会被优化
    public SimplePriorities(int priority){ //类构造函数
        super.setPriority(priority);// 调用Thread中的setPriority方法来设置该线程的优先级
        start(); // 初始化线程，并调用run方法
    }
    public String toString(){ // overrides toString function
        return super.getName()+"  "+"priority:"+ super.getPriority()+":"+countDown;
    }
    public void run(){ // overrides run fucntion to achieve multiThread
        while(true){
            // An expensive,interruptable operation;
            for(int i=0;i<5;++i)
                d=d+(Math.PI+Math.E)/(double)i;
            System.out.println(this);
            if(--countDown<=0) return;
        }
    }
    public static void main(String []args){
        new SimplePriorities(Thread.MAX_PRIORITY);
        for(int i=0;i<5;++i){
            new SimplePriorities(Thread.MIN_PRIORITY);
        }
    }
}

//
//public class SimplePriorities extends Thread{
//    private int countDown=5;
//    public SimplePriorities(int priority,String name){
//        super.setPriority(priority);
//        super.setName(name);
//        start();
//    }
//    public SimplePriorities(String name){
//        super.setName(name);
//        start();
//    }
//
//    public void run(){
//        while(true){
//            System.out.println(this.getName());
//            if(--countDown==0) return;
//        }
//    }
//    public static void main(String[] args) throws InterruptedException {
//        for(int i=0;i<5;++i){
//            new SimplePriorities("what's your name?").join();
//            new SimplePriorities("my name is Devin.").join();
//        }
//    }
//}