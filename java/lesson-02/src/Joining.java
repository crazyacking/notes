import javax.print.attribute.standard.JobName;
import java.util.InputMismatchException;

/**
 * Created by crazyacking on 16-5-2.
 */

class Sleeper extends Thread{
    private int duration; // 睡眠时间
    public Sleeper(String name,int sleepTime){
        super(name); // 线程名称
        duration=sleepTime;
        start();
    }
    public void run(){
        try  {
            sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName()+"has awakened");
    }
}

class Joiner extends Thread{
    private Sleeper sleeper;
    public Joiner(String name,Sleeper sleeper){
        super(name);
        this.sleeper=sleeper;
        start();
    }
    public void run(){
        try{
            sleeper.join();
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        System.out.println(getName() + "join completed");
    }
}

public class Joining{
    private static void main(String[] args) throws InterruptedException {
        Sleeper sleepy=new Sleeper("Sleepy",63444);
        Sleeper grumpy=new Sleeper("Grumpy",74232);
        Joiner dopey=new Joiner("Dopey",sleepy);
        Joiner doc=new Joiner("Doc",grumpy);
        grumpy.interrupt();
    }
}