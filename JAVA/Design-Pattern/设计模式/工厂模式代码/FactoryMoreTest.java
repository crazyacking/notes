//多个工厂方法模式，是对普通工厂方法模式的改进，
//在普通工厂方法模式中，如果传递的字符串出错，
//则不能正确创建对象，而多个工厂方法模式是提供多个工厂方法，
//分别创建对象。
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

class SendFactory {  					//多个工厂方法
   public Sender produceMail(){  
        return new MailSender();  
    }  
      
    public Sender produceSms(){  
        return new SmsSender();  
    }  
}

public class FactoryMoreTest {    			//调用测试
    public static void main(String[] args) {  
        SendFactory factory = new SendFactory();  
        Sender sender = factory.produceMail();  	
        //注意这里，不需要参数，也可以工厂方式构造对象。但交互性降低
        sender.Send();  
    }  
}