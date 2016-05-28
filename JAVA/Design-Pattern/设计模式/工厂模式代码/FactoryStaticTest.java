//��̬��������ģʽ��������Ķ����������ģʽ��ķ�����Ϊ��̬�ģ�
//����Ҫ����ʵ����ֱ�ӵ��ü��ɡ�
interface Sender {  					//�ӿ�
    public void Send();  
} 

class MailSender implements Sender {  	//����1�������ʼ�
    public void Send() {  
        System.out.println("this is mailsender!");  
    }  
}

class SmsSender implements Sender {  	//����2�����Ͷ���
    public void Send() {  
        System.out.println("this is sms sender!");  
    }  
}

class SendFactory {  					//��̬��������ģʽ      
    public static Sender produceMail(){  
        return new MailSender();  
    }  
      
    public static Sender produceSms(){  
        return new SmsSender();  
    }  
}

public class FactoryStaticTest {    			//���ò���
    public static void main(String[] args) {  
        SendFactory factory = new SendFactory();  
        Sender sender = factory.produceMail();  	
        //ע���������Ҫ������Ҳ���Թ�����ʽ������󡣵������Խ���
        sender.Send();  
    }  
}