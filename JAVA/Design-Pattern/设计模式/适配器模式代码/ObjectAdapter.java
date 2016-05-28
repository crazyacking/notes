//�����������ģʽ
class Source{    				//ĳ��Դ��
    public void method1() {  
        System.out.println("this is original method!");  
    }  
} 

interface Targetable{    		//ĳ���ӿ�    
    public void method1();		//��ԭ���еķ�����ͬ
  
    public void method2();      //����ķ���
}

//ֻ��Ҫ�޸�Adapter���Դ�뼴��
class Wrapper implements Targetable {  
  
    private Source source;        	//�ؼ���1)�����������ж���ĳԴ��Ķ���	
    public Wrapper(Source source){  //�ؼ���2)ĳԴ��Ķ��󽫳�Ϊ����
        super();  
        this.source = source;  
    }  

    public void method2() {  
        System.out.println("this is the targetable method!");  
    }  

    public void method1() {  
        source.method1();  			
        				//�ؼ���3)��Ҫת���ķ���method1()�У�����ĳԴ��ķ���
    }  
} 

//�����ࣺ
public class ObjectAdapter{
    public static void main(String[] args) {  
        Source source = new Source();  
        Targetable target = new Wrapper(source);  
        target.method1();  
        target.method2();  
    }  
}