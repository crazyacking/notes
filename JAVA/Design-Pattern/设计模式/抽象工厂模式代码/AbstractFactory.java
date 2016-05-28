//���󹤳�ģʽ��Abstract Factory��
/*��������ģʽ��һ��������ǣ���Ĵ������������࣬Ҳ����˵��
 *�����Ҫ��չ���򣬱���Թ���������޸ģ���Υ���˱հ�ԭ��
 *���ԣ�����ƽǶȿ��ǣ���һ�������⣬��ν�������õ����󹤳�ģʽ��
 *������������࣬����һ����Ҫ�����µĹ��ܣ�ֱ�������µĹ�����Ϳ����ˣ�
 *����Ҫ�޸�֮ǰ�Ĵ��롣 
 */
 //�����ʼ����Ƿ��Ͷ��Ű��������ȹ��췢���߽ӿ�
interface Sender {  
    public void Send();  
} 

//����ʵ���ࣺ
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

//���ṩһ�����칤������Ľӿڣ�
interface Provider {  
    public Sender produce();  
} 

//���������ࣺ�ֱ�������(����)����
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
  
