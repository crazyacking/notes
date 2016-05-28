//抽象工厂模式（Abstract Factory）
/*工厂方法模式有一个问题就是，类的创建依赖工厂类，也就是说，
 *如果想要拓展程序，必须对工厂类进行修改，这违背了闭包原则，
 *所以，从设计角度考虑，有一定的问题，如何解决？就用到抽象工厂模式，
 *创建多个工厂类，这样一旦需要增加新的功能，直接增加新的工厂类就可以了，
 *不需要修改之前的代码。 
 */
 //发送邮件还是发送短信案例，首先构造发送者接口
interface Sender {  
    public void Send();  
} 

//两个实现类：
class MailSender implements Sender {  
    public void Send() {  
        System.out.println("this is mailsender!");  
    }  
}  

class SmsSender implements Sender {
    public void Send() {  
        System.out.println("this is sms sender!");  
    }  
}  

//再提供一个构造工厂对象的接口：
interface Provider {  
    public Sender produce();  
} 

//两个工厂类：分别来生产(构造)对象
class SendMailFactory implements Provider { 
    public Sender produce(){  
        return new MailSender();  
    }  
}

class SendSmsFactory implements Provider{
    public Sender produce() {  
        return new SmsSender();  
    }  
} 

public class AbstractFactory{    
    public static void main(String[] args) {  
        Provider provider = new SendMailFactory();  
        Sender sender = provider.produce();  
        sender.Send();  
    }  
}
  
