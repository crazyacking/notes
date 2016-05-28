interface Handler {  
    public void operator();  
} 

abstract class AbstractHandler {      
    private Handler handler;   
    public Handler getHandler() {  
        return handler;  
    }    
    public void setHandler(Handler handler) {  
        this.handler = handler;  
    }       
}   

class MyHandler extends AbstractHandler implements Handler {    
    private String name;    
    public MyHandler(String name) {  
        this.name = name;  
    }    
    public void operator() {  				//关键：1)关键链模式设置，在调用时，形成了类似递归的对象链的调用
        System.out.println(name+"deal!");  
        if(getHandler()!=null){  
            getHandler().operator();  
        }  
    }  
}  

public class ResponsibilityChainTest {    
    public static void main(String[] args) {  
        MyHandler h1 = new MyHandler("h1");  
        MyHandler h2 = new MyHandler("h2");  
        MyHandler h3 = new MyHandler("h3");  
  
        h1.setHandler(h2);  				//关键：2)建立对象链
        h2.setHandler(h3);  
  
        h1.operator();  					//关键：3)调用关键链
    }  
} 