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
    public void operator() {  				//�ؼ���1)�ؼ���ģʽ���ã��ڵ���ʱ���γ������Ƶݹ�Ķ������ĵ���
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
  
        h1.setHandler(h2);  				//�ؼ���2)����������
        h2.setHandler(h3);  
  
        h1.operator();  					//�ؼ���3)���ùؼ���
    }  
} 