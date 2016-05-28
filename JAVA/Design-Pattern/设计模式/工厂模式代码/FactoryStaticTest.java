//静态工厂方法模式，将上面的多个工厂方法模式里的方法置为静态的，
//不需要创建实例，直接调用即可。
interface Sender {  					//接口
    public void Send();  
} 

class MailSender implements Sender {  	//子类1，发送邮件
    public void Send() {  
        System.out.println("this is mailsender!");  
    }  
}

class SmsSender implements Sender {  	//子类2，发送短信
    public void Send() {  
        System.out.println("this is sms sender!");  
    }  
}

class SendFactory {  					//静态工厂方法模式      
    public static Sender produceMail(){  
        return new MailSender();  
    }  
      
    public static Sender produceSms(){  
        return new SmsSender();  
    }  
}

public class FactoryStaticTest {    			//调用测试
    public static void main(String[] args) {  
        SendFactory factory = new SendFactory();  
        Sender sender = factory.produceMail();  	
        //注意这里，不需要参数，也可以工厂方式构造对象。但交互性降低
        sender.Send();  
    }  
}