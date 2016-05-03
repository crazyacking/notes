/**
 * Created by crazyacking on 16-5-2.
 */
public class RunnableThread implements Runnable{
    private int countDown=5;
    final static int MAX_Thread=4;
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep((long) Math.random()%3000);
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            System.out.println(toString()+" "+countDown);
            if(--countDown==0) return;
        }
    }
    public String toString(){
        return "#"+" "+getClass();
    }

    public static void main(String[] args){
        for(int i=0;i<MAX_Thread;++i){
            new Thread( new RunnableThread(),""+i ).start();
        }
    }
}
