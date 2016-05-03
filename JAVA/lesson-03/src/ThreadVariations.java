/**
 * Created by crazyacking on 16-5-2.
 */

// using a named inner class;
class InnerThread1{
    private int countDown=5;
    private Inner inner;
    private class Inner extends Thread{
        Inner(String name){
            super(name);
            start();
        }
        public void run(){
            while(true){
                if(--countDown==0) return;
                try{
                    Thread.sleep((long)Math.random()%3000);
                } catch(InterruptedException e){
                    throw new RuntimeException(e);
                }
                System.out.println(this);
            }
        }
        public String toString(){
            return getName()+" : "+countDown;
        }
    }
    public InnerThread1(String name){
        inner=new Inner(name);
    }
}

// using a anonymous inner class;
class InnerThread2{
    private int countDown=5;
    private Thread t;
    public InnerThread2(String name){
        t=new Thread(name){
            public void run(){
                while(true){
                    if(--countDown==0) return;
                    try{
                        Thread.sleep((long)Math.random()%3000);
                    } catch(InterruptedException e){
                        throw new RuntimeException(e);
                    }
                    System.out.println(this);
                }
            }
            public String toString(){
                return Thread.currentThread().getName()+" : "+countDown;
            }
        };
        t.start();
    }
}

// Using a named Runnalbe implementation;
class InnerRunnable1{
    private int countDown=5;
    private Inner inner;
    private class Inner implements Runnable{
        Thread t;
        public Inner(String name){
            t=new Thread(this,name);
            t.start();
        }
        @Override
        public void run() {
            while(true){
                System.out.println(this);
                if(--countDown==0) return;
                try{
                    Thread.sleep((long)Math.random()%3000);
                } catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
            }
        }
        public String toString(){
            return Thread.currentThread().getName()+" : "+countDown;
        }
    }
    public InnerRunnable1(String name){
        inner = new Inner(name);
    }
}

// using an anonymous Runable implementation;
class InnerRunnable2{
    private int countDown=5;
    private Thread t;
    public InnerRunnable2(String name){
        t=new Thread(new Runnable(){
            public void run(){
                while(true){
                    System.out.println(this);
                    if(--countDown==0) return;
                    try{
                        Thread.sleep(1000);
                    } catch(InterruptedException e){
                        throw new RuntimeException(e);
                    }
                }
            }
            public String toString(){
                return Thread.currentThread().getName()+" : "+countDown;
            }
        },name);
        t.start();
    }
}


// A separate method to run some code as a thread;
class ThreadMethod{
    private int countDown=5;
    private Thread t;
    private String name;
    public ThreadMethod(String name){
        this.name=name;
    }

    public void runThread(){
        if(t==null){
            t=new Thread(name){
                public void run(){
                    while(true){
                        System.out.println(this);
                        if(--countDown==0) return;
                        try{
                            sleep(100);
                        } catch (InterruptedException e){
                            throw new RuntimeException(e);
                        }
                    }
                }
                public String toString(){
                    return getName() +" : "+countDown;
                }
            };
            t.start();
        }
    }
}


public class ThreadVariations {
    public static void main(String[] args){
        new InnerThread1("InnerThread1");
        new InnerThread2("InnerThread2");
        new InnerRunnable1("InnerRunnable1");
        new InnerRunnable2("InnerRunnable2");
        new ThreadMethod("ThreadMethod");
    }
}
