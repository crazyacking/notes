//类的适配器模式
class Source{    				//某个源类
    public void method1() {  
        System.out.println("this is original method!");  
    }  
} 

interface Targetable{    		//某个接口    
    public void method1();		//与原类中的方法相同
  
    public void method2();      //新类的方法
}

//关键：适配器让Source类和Targetable的method1方法在调用时，成了统一的一个方法
class Adapter extends Source implements Targetable{  
    public void method2() {  
        System.out.println("this is the targetable method!");  
    }  
}  

//Adapter类继承Source类，实现Targetable接口，下面是测试类：
public class ClassAdapter{ 
    public static void main(String[] args) {  
        Targetable target = new Adapter();  
        target.method1();  
        target.method2();  
    }  
}