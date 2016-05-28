//对象的适配器模式
class Source{    				//某个源类
    public void method1() {  
        System.out.println("this is original method!");  
    }  
} 

interface Targetable{    		//某个接口    
    public void method1();		//与原类中的方法相同
  
    public void method2();      //新类的方法
}

//只需要修改Adapter类的源码即可
class Wrapper implements Targetable {  
  
    private Source source;        	//关键：1)在适配器类中定义某源类的对象	
    public Wrapper(Source source){  //关键：2)某源类的对象将成为参数
        super();  
        this.source = source;  
    }  

    public void method2() {  
        System.out.println("this is the targetable method!");  
    }  

    public void method1() {  
        source.method1();  			
        				//关键：3)在要转换的方法method1()中，调用某源类的方法
    }  
} 

//测试类：
public class ObjectAdapter{
    public static void main(String[] args) {  
        Source source = new Source();  
        Targetable target = new Wrapper(source);  
        target.method1();  
        target.method2();  
    }  
}