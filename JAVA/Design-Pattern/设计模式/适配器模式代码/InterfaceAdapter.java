//�ӿڵ�������ģʽ

//1)ĳ�ӿڣ������ж�����󷽷����������ʵ�֣�Ҫʵ�ֺܶ෽��������
interface Sourceable {        
    public void method1();  
    public void method2();  
}  

//2)�ؼ�������������һ�������࣬�̳��˽ӿں󣬰�Ҫʵ�ֵķ���ͳͳʵ��
abstract class Wrapper2 implements Sourceable{
    public void method1(){}  
    public void method2(){}  
}    

//3)���಻��ֱ�Ӽ̳нӿڣ�ת���̳���Ϊ���������������
class SourceSub1 extends Wrapper2 {  
    public void method1(){  
        System.out.println("the sourceable interface's first Sub1!");  
    }  
}
 
class SourceSub2 extends Wrapper2 {  	//3)���಻��ֱ�Ӽ̳нӿڣ�ת���̳���Ϊ���������������
    public void method2(){  
        System.out.println("the sourceable interface's second Sub2!");  
    }  
}

public class InterfaceAdapter{ //������
    public static void main(String[] args) {  
        Sourceable source1 = new SourceSub1();  
        Sourceable source2 = new SourceSub2(); 
        source1.method1();  
        source1.method2();  
        source2.method1();  
        source2.method2();  
    }  
}