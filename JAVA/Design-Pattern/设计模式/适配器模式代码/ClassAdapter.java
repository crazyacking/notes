//���������ģʽ
class Source{    				//ĳ��Դ��
    public void method1() {  
        System.out.println("this is original method!");  
    }  
} 

interface Targetable{    		//ĳ���ӿ�    
    public void method1();		//��ԭ���еķ�����ͬ
  
    public void method2();      //����ķ���
}

//�ؼ�����������Source���Targetable��method1�����ڵ���ʱ������ͳһ��һ������
class Adapter extends Source implements Targetable{  
    public void method2() {  
        System.out.println("this is the targetable method!");  
    }  
}  

//Adapter��̳�Source�࣬ʵ��Targetable�ӿڣ������ǲ����ࣺ
public class ClassAdapter{ 
    public static void main(String[] args) {  
        Targetable target = new Adapter();  
        target.method1();  
        target.method2();  
    }  
}