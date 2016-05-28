//接口的适配器模式

//1)某接口，里面有多个抽象方法，如果给类实现，要实现很多方法不方便
interface Sourceable {        
    public void method1();  
    public void method2();  
}  

//2)关键：适配器类是一个抽象类，继承了接口后，把要实现的方法统统实现
abstract class Wrapper2 implements Sourceable{
    public void method1(){}  
    public void method2(){}  
}    

//3)子类不再直接继承接口，转而继承作为抽象类的适配器类
class SourceSub1 extends Wrapper2 {  
    public void method1(){  
        System.out.println("the sourceable interface's first Sub1!");  
    }  
}
 
class SourceSub2 extends Wrapper2 {  	//3)子类不再直接继承接口，转而继承作为抽象类的适配器类
    public void method2(){  
        System.out.println("the sourceable interface's second Sub2!");  
    }  
}

public class InterfaceAdapter{ //测试类
    public static void main(String[] args) {  
        Sourceable source1 = new SourceSub1();  
        Sourceable source2 = new SourceSub2(); 
        source1.method1();  
        source1.method2();  
        source2.method1();  
        source2.method2();  
    }  
}