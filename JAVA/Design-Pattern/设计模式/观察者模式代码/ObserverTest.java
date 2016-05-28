import java.util.Vector;
import java.util.Enumeration;
//观察者
interface Observer {  
    public void update();  
} 

class Observer1 implements Observer {  
    public void update() {  
        System.out.println("observer1 has received!");  
    }  
}  

class Observer2 implements Observer {  
    public void update() {  
        System.out.println("observer2 has received!");  
    }    
}  

//Subject(主题)接口及实现类：
interface Subject{  
      
    /*增加观察者*/  
    public void add(Observer observer);  
      
    /*删除观察者*/  
    public void del(Observer observer);  
      
    /*通知所有的观察者*/  
    public void notifyObservers();  
      
    /*自身的操作*/  
    public void operation();  
}  

//关键：观察者模式关键，用集合记录将被通知的每一个对象，
//可以添加和删除对象
//一旦发现主题发送变化，就遍历观察者类的所有对象，
//并调用观察者的update方法进行更新
abstract class AbstractSubject implements Subject{    
    private Vector<Observer> vector = new Vector<Observer>();  
    
    public void add(Observer observer) {  
        vector.add(observer);  
    } 
    
    public void del(Observer observer) {  
        vector.remove(observer);  
    }
    
    public void notifyObservers() {  
        Enumeration<Observer> enumo = vector.elements();  
        while(enumo.hasMoreElements()){  
            enumo.nextElement().update();  
        }  
    }    
    
}  

class MySubject extends AbstractSubject{ 
	//具体的主体类，实现了抽象类，当自身发身变化是，就调用operation()方法
	//然后触发(即调用)notifyObservers(); 方法，对每个观察者对象进行更新操作
    public void operation() {  			
        System.out.println("update self!");  
        notifyObservers();  			
    }    
}  

public class ObserverTest{ 
    public static void main(String[] args){  
        Subject sub = new MySubject();  
        sub.add(new Observer1());  
        sub.add(new Observer2());  
          
        sub.operation();  
    } 
}  