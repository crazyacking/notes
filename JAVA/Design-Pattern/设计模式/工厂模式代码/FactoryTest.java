//普通工厂模式，就是建立一个工厂类，对实现了同一接口的一些类进行实例的创建
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

class SendFactory {    					//工厂类
    public Sender produce(String type) {  
        if ("mail".equals(type)) {  
            return new MailSender();  
        } else if ("sms".equals(type)) {  
            return new SmsSender();  
        } else {  
            System.out.println("请输入正确的类型!");  
            return null;  
        }  
    }  
}

public class FactoryTest {    			//调用测试
    public static void main(String[] args) {  
        SendFactory factory = new SendFactory();  
        Sender sender = factory.produce("mail");  	//注意这里，依据字符串参数构造出的对象
        sender.Send();  
    }  
}