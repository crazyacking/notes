import java.util.Vector;
import java.util.Enumeration;
//�۲���
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

//Subject(����)�ӿڼ�ʵ���ࣺ
interface Subject{  
      
    /*���ӹ۲���*/  
    public void add(Observer observer);  
      
    /*ɾ���۲���*/  
    public void del(Observer observer);  
      
    /*֪ͨ���еĹ۲���*/  
    public void notifyObservers();  
      
    /*����Ĳ���*/  
    public void operation();  
}  

//�ؼ����۲���ģʽ�ؼ����ü��ϼ�¼����֪ͨ��ÿһ������
//������Ӻ�ɾ������
//һ���������ⷢ�ͱ仯���ͱ����۲���������ж���
//�����ù۲��ߵ�update�������и���
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
	//����������࣬ʵ���˳����࣬��������仯�ǣ��͵���operation()����
	//Ȼ�󴥷�(������)notifyObservers(); ��������ÿ���۲��߶�����и��²���
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