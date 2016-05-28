//�����������ģʽ���Ƕ���ͨ��������ģʽ�ĸĽ���
//����ͨ��������ģʽ�У�������ݵ��ַ�������
//������ȷ�������󣬶������������ģʽ���ṩ�������������
//�ֱ𴴽�����
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

class SendFactory {  					//�����������
   public Sender produceMail(){  
        return new MailSender();  
    }  
      
    public Sender produceSms(){  
        return new SmsSender();  
    }  
}

public class FactoryMoreTest {    			//���ò���
    public static void main(String[] args) {  
        SendFactory factory = new SendFactory();  
        Sender sender = factory.produceMail();  	
        //ע���������Ҫ������Ҳ���Թ�����ʽ������󡣵������Խ���
        sender.Send();  
    }  
}