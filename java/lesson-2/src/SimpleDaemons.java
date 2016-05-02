/**
 * Created by crazyacking on 16-5-2.
 */

// Daemon threads don't prevent the program from ending.
public class SimpleDaemons extends Thread{
    public SimpleDaemons(){
        setDaemon(true);
        start();
    }

    public void run(){
        while(true){
            try{
                sleep(100);
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }
            System.out.println();
        }
    }

    public String toString(){
        return this.getName()+" "+this.getId();
    }

    public static void main(String []args){
        for(int i=0;i<5;++i){
            new SimpleDaemons();
        }
    }
}
