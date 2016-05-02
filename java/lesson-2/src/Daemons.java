///**
// * Created by crazyacking on 16-5-2.
// */
//public class Daemons {
//    public static void main(String[] args)throws Exception{
//        Thread d=new Daemon();
//        System.out.println("d.isDaemon()="+d.isDaemon());
//        Thread.sleep(1000);
//    }
//}
//
//class Daemon extends Thread{
//    private Thread[] t=new Thread[10];
//    public Daemon(){
//        setDaemon(true);
//        start();
//    }
//    public void run(){
//        for(int i=0;i<t.length;++i){
//            t[i]=new DaemonSpawn(i);
//        }
//        for(int i=0;i<t.length;++i){
//            System.out.println("t["+i+"].isDaemon()=" + t[i].isDaemon());
//        }
//        while(true)
//            yield();
//    }
//}
//
//class DaemonSpawn extends Thread{
//    public DaemonSpawn(int i){
//        start();
//        System.out.println("DaemonSpawn "+i+"started");
//    }
//    public void run(){
//        while(true)
//            yield();
//    }
//}


public class Daemons{
    public static void main(String[]args){
        for(int i=0;i<6;++i)
            new Daemon("crazyacking");

    }
}

class Daemon extends Thread{
    private String name="Devin";
    public Daemon(String name){
        this.name=name;
        setDaemon(true);
        start();
    }

    public void run(){
        System.out.println(this.name);
        return ;
    }
}